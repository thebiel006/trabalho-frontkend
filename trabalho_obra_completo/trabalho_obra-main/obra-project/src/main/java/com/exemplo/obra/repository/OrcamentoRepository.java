package com.exemplo.obra.repository;

import com.exemplo.obra.entity.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
    Optional<Orcamento> findByNumero(String numero);
    Optional<Orcamento> findByNomeClienteIgnoreCase(String nomeCliente);
}
