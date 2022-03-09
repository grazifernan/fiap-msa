package br.com.veiculos.repository;

import br.com.veiculos.domain.Filial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilialRepository extends JpaRepository<Filial, Integer> {

    List<Filial> findAll();
    Filial findBycodFilial(int codFilial);

}
