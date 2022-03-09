package br.com.veiculos.repository;

import br.com.veiculos.domain.Marca;
import br.com.veiculos.domain.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {

    List<Modelo> findAllBycodMarca(Marca marca);

    List<Modelo> findAll();
}

