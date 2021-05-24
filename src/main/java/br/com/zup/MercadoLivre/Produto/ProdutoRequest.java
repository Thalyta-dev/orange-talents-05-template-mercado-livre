package br.com.zup.MercadoLivre.Produto;


import br.com.zup.MercadoLivre.Categoria.Categoria;
import br.com.zup.MercadoLivre.Categoria.CategoriaRepository;
import br.com.zup.MercadoLivre.Login.Usuario;
import br.com.zup.MercadoLivre.Produto.Caracteristicas.CarasteristcasRequest;
import br.com.zup.MercadoLivre.Validacoes.ExisteId;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ProdutoRequest {

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
    @ExisteId(domainClass = Categoria.class, fieldName = "id", message = "Esta categoria ainda não foi cadastrada, escolha outra")
    private Long categoria;

    @NotEmpty
    private Set<CarasteristcasRequest> caracteristicas;

    public Produto toModel(CategoriaRepository categoriaRepository,Usuario usuario){
        Optional<Categoria> categoria = categoriaRepository.findById(this.categoria);


       return new Produto(this.nome, this.valor,  this.quantidade, this.descricao, categoria.get(), this.caracteristicas, usuario);

    }

    public String getNome() {
        return nome;
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

    public Long getCategoria() {
        return categoria;
    }

    public Set<CarasteristcasRequest> getCaracteristicas() {
        return caracteristicas;
    }
}
