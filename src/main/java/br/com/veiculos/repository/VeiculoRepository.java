package br.com.veiculos.repository;

import br.com.veiculos.domain.Cor;
import br.com.veiculos.domain.Filial;
import br.com.veiculos.domain.Modelo;
import br.com.veiculos.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    List<Veiculo> findAllByCodModeloIn(List<Modelo> modelo);
    List<Veiculo> findAll();
    List<Veiculo> findAllByCodModelo(Modelo modelo);
    List<Veiculo> findByCodModeloAndCodCor(Modelo modelo, Cor cor);
    List<Veiculo> findAllByCodFilial(Filial filial);
    Veiculo findByPlaca(String placa);
}