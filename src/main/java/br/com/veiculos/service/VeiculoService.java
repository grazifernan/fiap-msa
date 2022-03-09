package br.com.veiculos.service;

import br.com.veiculos.domain.*;
import br.com.veiculos.dto.VeiculoDTO;
import br.com.veiculos.dto.VeiculoNovoDTO;
import br.com.veiculos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final MarcaRepository marcaRepository;
    private final ModeloRepository modeloRepository;
    private final FilialRepository filialRepository;
    private final CorRepository corRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository, MarcaRepository marcaRepository,
                              ModeloRepository modeloRepository, FilialRepository filialRepository,
                              CorRepository corRepository){

        this.veiculoRepository = veiculoRepository;
        this.marcaRepository = marcaRepository;
        this.modeloRepository = modeloRepository;
        this.filialRepository = filialRepository;
        this.corRepository = corRepository;
    }

    @Transactional
    public List<VeiculoDTO> buscarVeiculosPorMarca(int codMarca){

        List<Veiculo> veiculoList;
        Marca marca = new Marca();
        marca.setCodMarca(codMarca);
        List<Modelo> modelo;
        modelo = modeloRepository.findAllBycodMarca(marca);

        if (codMarca > 0){

            veiculoList = veiculoRepository.findAllByCodModeloIn(modelo);
        }else{
            veiculoList = veiculoRepository.findAll();
        }

        return veiculoList.stream()
                .map(veiculo -> new VeiculoDTO(veiculo) )
                .collect(Collectors.toList());

    }

    @Transactional
    public List<VeiculoDTO> buscarVeiculosPorModelo(int codModelo){

        List<Veiculo> veiculoList;
        Modelo modelo = new Modelo();
        modelo.setCodModelo(codModelo);

        if (codModelo > 0){

            veiculoList = veiculoRepository.findAllByCodModelo(modelo);
        }else{
            veiculoList = veiculoRepository.findAll();
        }

        return veiculoList.stream()
                .map(veiculo -> new VeiculoDTO(veiculo) )
                .collect(Collectors.toList());
    }

    @Transactional
    public List<VeiculoDTO> buscarVeiculoPorAno(int codMarca, int codModelo, Long ano){

        List<Veiculo> veiculoList;
        Marca marca = new Marca();
        marca.setCodMarca(codMarca);
        Modelo modelo = new Modelo();
        modelo.setCodModelo(codModelo);
        modelo.setAno(ano);
        modelo.setCodMarca(marca);


        //ALTERAÇÕES PENDENTES: mudar o ano para uma constante
        if (codModelo > 0 && codMarca > 0 && ano > 1900){

            veiculoList = veiculoRepository.findAllByCodModelo(modelo);
        }else{
            veiculoList = veiculoRepository.findAll();
        }

        return veiculoList.stream()
                .map(veiculo -> new VeiculoDTO(veiculo) )
                .collect(Collectors.toList());
    }

    @Transactional
    public List<VeiculoDTO> buscarVeiculoPorCor(int codMarca, int codModelo, Long ano, int codCor){

        List<Veiculo> veiculoList;
        Marca marca = new Marca();
        marca.setCodMarca(codMarca);
        Cor cor = new Cor();
        cor.setCodCor(codCor);
        Modelo modelo = new Modelo();
        modelo.setCodModelo(codModelo);
        modelo.setAno(ano);
        modelo.setCodMarca(marca);

        if (codModelo > 0 && codMarca > 0 && codCor > 0){

            veiculoList = veiculoRepository.findByCodModeloAndCodCor(modelo, cor);
        }else{
            veiculoList = veiculoRepository.findAll();
        }

        return veiculoList.stream()
                .map(veiculo -> new VeiculoDTO(veiculo) )
                .collect(Collectors.toList());
    }

    @Transactional
    public List<VeiculoDTO> buscarVeiculosPorFilial(int codFilial){

        List<Veiculo> veiculoList;
        Filial filial = new Filial();
        filial.setcodFilial(codFilial);

        if (codFilial > 0 ){

            veiculoList = veiculoRepository.findAllByCodFilial(filial);
        }else{
            veiculoList = veiculoRepository.findAll();
        }

        return veiculoList.stream()
                .map(veiculo -> new VeiculoDTO(veiculo) )
                .collect(Collectors.toList());
    }

    @Transactional
    public VeiculoDTO buscarVeiculoPorPlaca(String placa){

        Veiculo veiculo;
        veiculo = veiculoRepository.findByPlaca(placa);
        return new VeiculoDTO(veiculo);
    }

    public VeiculoDTO cadastrarVeiculo(VeiculoNovoDTO veiculoNovo) {
        Modelo modelo = new Modelo();
        modelo.setCodModelo(veiculoNovo.getCodModelo());

        Cor cor = new Cor();
        cor.setCodCor(veiculoNovo.getCodCor());

        Filial filial = new Filial();
        filial.setcodFilial(veiculoNovo.getCodFilial());

        Veiculo veiculo = new Veiculo();
        veiculo.setCodModelo(modelo);
        veiculo.setCodCor(cor);
        veiculo.setCodFilial(filial);
        veiculo.setDescricao(veiculoNovo.getDescricao());
        veiculo.setPlaca(veiculoNovo.getPlaca());
        veiculo.setKm(veiculoNovo.getKm());
        veiculo.setValor(veiculoNovo.getValor());
        veiculo.setRenavam(veiculoNovo.getRenavam());

        // Veiculo veiculo = new Veiculo(veiculoNovo);
        Veiculo savedVeiculo = veiculoRepository.save(veiculo);
        return new VeiculoDTO(savedVeiculo);

    }

    @Transactional
    public Marca buscarMarcaPorCodigo(int codMarca){
        Marca marca;

        marca = marcaRepository.findAllBycodMarca(codMarca);
        return new Marca(marca);
    }

    @Transactional
    public List<Marca> listarMarcas(){

        List<Marca> marcaList;
        marcaList = marcaRepository.findAll();

        return marcaList.stream()
                .map(marca -> new Marca(marca) )
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Modelo> buscarModeloPorMarca(int codMarca){

        List<Modelo> modeloList;
        Marca marca = new Marca();
        marca.setCodMarca(codMarca);

        modeloList = modeloRepository.findAllBycodMarca(marca);

        return modeloList.stream()
                .map(modelo -> new Modelo(modelo) )
                .collect(Collectors.toList());
    };

    @Transactional
    public List<Modelo> listarModelos(){

        List<Modelo> modeloList;
        modeloList = modeloRepository.findAll();

        return modeloList.stream()
                .map(modelo -> new Modelo(modelo) )
                .collect(Collectors.toList());

    };

    @Transactional
    public Filial buscarFilialPorCodigo(int codFilial){

        Filial filial;
        filial = filialRepository.findBycodFilial(codFilial);
        return new Filial(filial);

    };

    @Transactional
    public List<Filial> listarFiliais(){

        List<Filial> filialList;
        filialList = filialRepository.findAll();

        return filialList.stream()
                .map(filial -> new Filial(filial) )
                .collect(Collectors.toList());

    };



    @Transactional
    public List<Cor> listarCores(){
        List<Cor> corList;
        corList = corRepository.findAll();

        return corList.stream()
                .map(cor -> new Cor(cor) )
                .collect(Collectors.toList());
    };

    public Cor buscarCor(int codCor){
        Cor corRepo = corRepository.findBycodCor(codCor);
        Cor cor = new Cor(corRepo);
        return cor;
    };


}
