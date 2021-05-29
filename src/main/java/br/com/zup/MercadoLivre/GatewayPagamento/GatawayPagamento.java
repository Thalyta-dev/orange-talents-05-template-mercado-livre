package br.com.zup.MercadoLivre.GatewayPagamento;

import br.com.zup.MercadoLivre.Transacao.Compra;
import br.com.zup.MercadoLivre.Transacao.StatusPagamento;
import br.com.zup.MercadoLivre.Transacao.Transacao;

public interface GatawayPagamento {
    
    StatusPagamento statusPagamento();
    Transacao toModel(Compra compra);

    Long getIdpagamento();
}
