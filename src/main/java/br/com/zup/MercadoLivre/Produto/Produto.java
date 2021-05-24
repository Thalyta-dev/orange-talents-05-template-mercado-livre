package br.com.zup.MercadoLivre.Produto;


import br.com.zup.MercadoLivre.Categoria.Categoria;
import br.com.zup.MercadoLivre.Login.Usuario;
import br.com.zup.MercadoLivre.Produto.Caracteristicas.Caracteristicas;
import br.com.zup.MercadoLivre.Produto.Caracteristicas.CarasteristcasRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    Usuario usuario;

    @NotBlank
    private String nome;

    @NotNull
    @Range(min = 1)
    private BigDecimal valor;

    @Range(min = 0)
    private Integer quantidade;

    @Column(columnDefinition = "text")
    @Length(max= 1000)
    private String descricao;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Set<Caracteristicas> caracteristicas;

    public Produto(String nome, BigDecimal valor, Integer quantidade,
                   String descricao, Categoria categoria, Set<CarasteristcasRequest> caracteristicas, Usuario usuario) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = categoria;
        this.caracteristicas = caracteristicas.stream().map(o -> new Caracteristicas(o, this)).collect(Collectors.toSet());;
        this.usuario = usuario;
    }
}
