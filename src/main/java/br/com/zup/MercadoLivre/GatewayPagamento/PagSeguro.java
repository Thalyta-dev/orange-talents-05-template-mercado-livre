package br.com.zup.MercadoLivre.GatewayPagamento;

import br.com.zup.MercadoLivre.Transacao.Compra;
import br.com.zup.MercadoLivre.Transacao.StatusPagamento;
import br.com.zup.MercadoLivre.Transacao.Transacao;

public class PagSeguro implements  GatawayPagamento{


    private   Long idpagamento;
    private String statusCompraRetorno;


    public PagSeguro(Long idpagamento, String statusCompraRetorno) {
        this.idpagamento = idpagamento;
        this.statusCompraRetorno = statusCompraRetorno;
    }

    @Override
    public StatusPagamento statusPagamento() {

        if (statusCompraRetorno.equalsIgnoreCase("1")){
            return StatusPagamento.SUCESSO;
        }
        return StatusPagamento.FALHA;

    }

    public String getStatusCompraRetorno() {

        return statusCompraRetorno;
    }

    public Long getIdpagamento() {

        return idpagamento;
    }

    public Transacao toModel(Compra compra){

       StatusPagamento statusCompra = statusPagamento();
        return new Transacao(compra, statusCompra, this.idpagamento);

    }
}
