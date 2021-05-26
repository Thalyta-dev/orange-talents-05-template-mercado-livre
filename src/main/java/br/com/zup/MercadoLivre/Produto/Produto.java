package br.com.zup.MercadoLivre.Produto;


import br.com.zup.MercadoLivre.Categoria.Categoria;
import br.com.zup.MercadoLivre.Login.Usuario;
import br.com.zup.MercadoLivre.Opnião.Opniao;
import br.com.zup.MercadoLivre.Pergunta.Pergunta;
import br.com.zup.MercadoLivre.Produto.Caracteristicas.Caracteristicas;
import br.com.zup.MercadoLivre.Produto.Caracteristicas.CarasteristcasRequest;
import br.com.zup.MercadoLivre.Produto.Imagens.Imagens;
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
    Usuario vendedor;

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

    @OneToMany(mappedBy = "produto")
    private List<Opniao> opniao;

    @OneToMany(mappedBy = "produto")
    private List<Pergunta> perguntas;

    @OneToMany(mappedBy = "produto")
    private List<Imagens> imagens;

    public Long getId() {
        return id;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public List<Imagens> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagens> imagens) {
        this.imagens = imagens;
    }

    public Produto() {
    }

    public Set<Caracteristicas> getCaracteristicas() {
        return caracteristicas;
    }

    @Override
    public String toString() {
        return  vendedor.toString();

    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Opniao> getOpniao() {
        return opniao;
    }

    public String getNome() {
        return nome;
    }

    public Produto(String nome, BigDecimal valor, Integer quantidade,
                   String descricao, Categoria categoria, Set<CarasteristcasRequest> caracteristicas, Usuario vendedor) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = categoria;
        this.caracteristicas = caracteristicas.stream().map(o -> new Caracteristicas(o, this)).collect(Collectors.toSet());;
        this.vendedor = vendedor;
    }


}
