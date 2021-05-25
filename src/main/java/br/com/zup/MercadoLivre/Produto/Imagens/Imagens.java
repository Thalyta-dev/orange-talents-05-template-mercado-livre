package br.com.zup.MercadoLivre.Produto.Imagens;

import br.com.zup.MercadoLivre.Produto.Produto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Imagens {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private  String nome;

    private String url;

    public String getUrl() {
        return url;
    }

    @Column(columnDefinition = "text")
    private String imagem;

    public Imagens() {
    }

    public String getNome() {
        return nome;
    }

    public Imagens(String nome, String imagem, String url) {
        this.imagem = imagem;
        this.nome = nome;
        this.url = url;

    }


}
