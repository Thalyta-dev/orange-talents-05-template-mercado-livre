package br.com.zup.MercadoLivre.Categoria;

import br.com.zup.MercadoLivre.Validacoes.ExisteId;
import br.com.zup.MercadoLivre.Validacoes.UniqueValue;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "O nome já foi cadastrado")
    private String nome;

    @ExisteId(fieldName = "id", domainClass = Categoria.class, message = "Categoria mae ainda não foi cadastrada")
    private Long categoriaMae;

    public String getNome() {
        return nome;
    }

    public Long getCategoriaMae() {
        return categoriaMae;
    }

    public  Categoria toModel(CategoriaRepository categoriaRepository){

        Categoria categoria = new Categoria(this.nome);

        if(this.categoriaMae != null){

            Optional<Categoria> categoriaMae = categoriaRepository.findById(this.categoriaMae);

            if(categoriaMae.isPresent()){
                categoria.setCategoriaMae(categoria);
            }

        }

        return categoria;
    }
}
