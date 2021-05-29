package br.com.zup.MercadoLivre.Transacao;

import br.com.zup.MercadoLivre.Transacao.Compra;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompraRepository extends CrudRepository<Compra, Long> {

    @Query(value = "select count(*) from compra as p inner join transacao as o on  p.id = o.compra_id where compra_id = :compra and status_pagamento = 'SUCESSO' ", nativeQuery = true)
    Optional<Integer> compraSucesso(Long compra);


}
