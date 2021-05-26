package br.com.zup.MercadoLivre.Compra;

import br.com.zup.MercadoLivre.Login.Usuario;
import br.com.zup.MercadoLivre.Produto.Produto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING)
    private Status status = Status.INICIADO;

    @NotNull
    @ManyToOne
    private Usuario comprador;

    @Positive
    @NotNull
    private Integer quantidadeProduto;

    @NotNull
    @ManyToOne
    private Produto produto;

    @Positive
    private BigDecimal valorAtualProduto;

    @Enumerated(EnumType.STRING)
    private  MetodoPagamento metodoPagamento;

    @Deprecated
    public Compra() {
    }

    public Compra(Usuario comprador, Integer quantidadeProduto, Produto produto,
                  BigDecimal valorAtualProduto, MetodoPagamento metodoPagamento) {

        this.comprador = comprador;
        this.quantidadeProduto = quantidadeProduto;
        this.produto = produto;
        this.valorAtualProduto = valorAtualProduto;
        this.metodoPagamento = metodoPagamento;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public Long getId() {
        return id;
    }
}
