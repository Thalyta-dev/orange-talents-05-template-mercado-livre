package br.com.zup.MercadoLivre.Compra;

import br.com.zup.MercadoLivre.Login.Usuario;
import br.com.zup.MercadoLivre.Produto.Produto;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class CompraRequest {

    @Positive
    @NotNull
    @Range(min= 1)
    private Integer quantidadeProduto;

    @NotNull
    private  MetodoPagamento metodoPagamento;

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
