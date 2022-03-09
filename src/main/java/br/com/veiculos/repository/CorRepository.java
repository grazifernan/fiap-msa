package br.com.veiculos.repository;

import br.com.veiculos.domain.Cor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorRepository extends JpaRepository<Cor, Integer> {
    List<Cor> findAll();
    Cor findBycodCor(int codCor);
}