package br.com.zup.MercadoLivre.Opnião;

import br.com.zup.MercadoLivre.Login.Usuario;
import br.com.zup.MercadoLivre.Produto.Produto;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Opniao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    @NotNull
    private Produto produto;

    @NotBlank
    private String titulo;

    @Column(columnDefinition = "tinyint")
    @Range(min = 1, max = 5)
    private byte nota;

    @NotBlank
    @Length(max = 500)
    private  String descricao;

    public Opniao() {
    }

    public Opniao(Usuario usuario, Produto produto, String titulo, byte nota, String descricao) {
        this.usuario = usuario;
        this.produto = produto;
        this.titulo = titulo;
        this.nota = nota;
        this.descricao = descricao;
    }
}
