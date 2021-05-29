package br.com.zup.MercadoLivre.Transacao;

import javax.validation.constraints.NotNull;

public class TransacaoRequest {


    @NotNull
    private Long idpagamento;

    @NotNull
    private StatusPagamento statusCompraRetorno;

    public TransacaoRequest(Long idpagamento, StatusPagamento statusCompraRetorno) {
        this.idpagamento = idpagamento;
        this.statusCompraRetorno = statusCompraRetorno;
    }


}
