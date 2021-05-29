package br.com.zup.MercadoLivre.Transacao;

import br.com.zup.MercadoLivre.Login.Usuario;
import br.com.zup.MercadoLivre.Produto.Produto;
import br.com.zup.MercadoLivre.Transacao.Compra;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CompraRequest {

    @Positive
    @NotNull
    @Range(min= 1)
    private Integer quantidadeProduto;

    @NotNull
    private MetodoPagamento metodoPagamento;

    public CompraRequest(Integer quantidadeProduto, MetodoPagamento metodoPagamento) {
        this.quantidadeProduto = quantidadeProduto;
        this.metodoPagamento = metodoPagamento;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public Compra toModel(Produto produto, Usuario comprador){

        return new Compra(comprador, this.quantidadeProduto, produto, produto.getValor(), this.metodoPagamento);
    }
}
