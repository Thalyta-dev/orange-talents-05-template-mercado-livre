package br.com.zup.MercadoLivre.Categoria;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @Column(nullable = true)
    private String nome;

    @ManyToOne
    private Categoria categoriaMae;

    public Categoria() {
    }


    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoriaMae() {
        return categoriaMae;
    }

    public String getNome() {
        return  this.nome;
    }

    public void setCategoriaMae(Categoria categoriaMae) {
        this.categoriaMae = categoriaMae;
    }




}
