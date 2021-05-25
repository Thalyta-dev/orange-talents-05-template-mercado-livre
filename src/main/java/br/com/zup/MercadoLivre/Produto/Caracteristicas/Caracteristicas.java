package br.com.zup.MercadoLivre.Produto.Caracteristicas;

import br.com.zup.MercadoLivre.Produto.Produto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Caracteristicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Column(columnDefinition = "text")
    private String descricao;

    @ManyToOne
    private Produto produto;
    public Caracteristicas(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Caracteristicas() {
    }

    public Caracteristicas(CarasteristcasRequest carasteristcasRequest, Produto produto) {
        this.nome = carasteristcasRequest.getNome();
        this.descricao = carasteristcasRequest.getDescricao();
        this.produto = produto;
    }


}
