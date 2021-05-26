package br.com.zup.MercadoLivre.Pergunta;


import br.com.zup.MercadoLivre.Login.Usuario;
import br.com.zup.MercadoLivre.Produto.Produto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Pergunta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    private LocalDateTime dateTime;

    @NotNull
    @ManyToOne
    private Usuario usuario;

    @NotNull
    @ManyToOne
    private Produto produto;

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescricao() {
        return descricao;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public Produto getProduto() {
        return produto;
    }


    public Pergunta(String titulo, Usuario usuario, Produto produto, String descricao) {

        this.produto = produto;
        this.titulo = titulo;
        this.usuario = usuario;
        this.dateTime = LocalDateTime.now();
        this.descricao = descricao;
    }


    public Pergunta( ) {

    }
}


