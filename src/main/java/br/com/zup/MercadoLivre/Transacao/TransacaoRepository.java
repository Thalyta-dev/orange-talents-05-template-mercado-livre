package br.com.zup.MercadoLivre.Transacao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransacaoRepository extends CrudRepository<Transacao,Long> {

    @Query(value = "select count(*) from  transacao where idpagamento = :pagamento and status_pagamento = 'SUCESSO' ", nativeQuery = true)
    Optional<Integer> idTransacaoUnico(Long pagamento);
}
