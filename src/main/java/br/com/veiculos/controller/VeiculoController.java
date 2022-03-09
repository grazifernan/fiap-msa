package br.com.veiculos.controller;

import br.com.veiculos.domain.*;
import br.com.veiculos.dto.VeiculoDTO;
import br.com.veiculos.dto.VeiculoNovoDTO;
import br.com.veiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//assim que implementar o jwt, precisamos retirar esta annotation, pois ela desabilita o CORS
@CrossOrigin
@RequestMapping("veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService){

        this.veiculoService = veiculoService;
    }

    @GetMapping("/listarcores")
    public List<Cor> listarCores(){
        return veiculoService.listarCores();
    }

    @GetMapping("/consultapormarca/{codMarca}")
    public List<VeiculoDTO> buscarVeiculosPorMarca(@PathVariable int codMarca){
        return veiculoService.buscarVeiculosPorMarca(codMarca);
    }

    @GetMapping("/consultapormodelo/{codModelo}")
    public List<VeiculoDTO> buscarVeiculosPorModelo(@PathVariable int codModelo){
        return veiculoService.buscarVeiculosPorModelo(codModelo);
    }

    @GetMapping("/consultaporano/{codMarca}/{codModelo}/{ano}")
    public List<VeiculoDTO> buscarVeiculoPorAno(@PathVariable int codMarca, @PathVariable int codModelo,
                                                @PathVariable Long ano){
        return veiculoService.buscarVeiculoPorAno(codMarca, codModelo, ano);
    }

    @GetMapping("/consultaporcor/{codMarca}/{codModelo}/{ano}/{codCor}")
    public List<VeiculoDTO> buscarVeiculoPorCor(@PathVariable int codMarca, @PathVariable int codModelo,
                                                @PathVariable Long ano, @PathVariable int codCor){
        return veiculoService.buscarVeiculoPorCor( codMarca,  codModelo,  ano, codCor);

    }

    @GetMapping("/consultaporfilial/{codFilial}")
    public List<VeiculoDTO> buscarVeiculosPorFilial(@PathVariable int codFilial){
        return veiculoService.buscarVeiculosPorFilial(codFilial);
    }

    @GetMapping("/consultaporplaca/{placa}")
    public VeiculoDTO buscarVeiculoPorPlaca(@PathVariable String placa){
        return veiculoService.buscarVeiculoPorPlaca(placa);
    }

    @GetMapping("/listarmarcas")
    public List<Marca> listarMarcas(){
        return veiculoService.listarMarcas();
    }

    @GetMapping("/listarmodelos/{codMarca}")
    public List<Modelo> buscarModeloPorMarca(@PathVariable int codMarca){
        return veiculoService.buscarModeloPorMarca(codMarca);
    }

    @GetMapping("/listarfiliais")
    public List<Filial> listarFiliais(){
        return veiculoService.listarFiliais();
    }



    @GetMapping("/buscarCor/{codCor}")
    public Cor buscarCor(@PathVariable int codCor) {
        return veiculoService.buscarCor(codCor);
    }


    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoDTO cadastrarVeiculo(@RequestBody VeiculoNovoDTO createVeiculoNovoDTO){

        createVeiculoNovoDTO.setCodCor(createVeiculoNovoDTO.getCodCor());
        createVeiculoNovoDTO.setCodFilial(createVeiculoNovoDTO.getCodFilial());
        createVeiculoNovoDTO.setCodModelo(createVeiculoNovoDTO.getCodModelo());
        createVeiculoNovoDTO.setDescricao(createVeiculoNovoDTO.getDescricao());
        createVeiculoNovoDTO.setKm(createVeiculoNovoDTO.getKm());
        createVeiculoNovoDTO.setPlaca(createVeiculoNovoDTO.getPlaca());
        createVeiculoNovoDTO.setRenavam(createVeiculoNovoDTO.getRenavam());
        createVeiculoNovoDTO.setValor(createVeiculoNovoDTO.getValor());
        createVeiculoNovoDTO.setCodFilial(createVeiculoNovoDTO.getCodFilial());

        return veiculoService.cadastrarVeiculo(createVeiculoNovoDTO);
    }


}
