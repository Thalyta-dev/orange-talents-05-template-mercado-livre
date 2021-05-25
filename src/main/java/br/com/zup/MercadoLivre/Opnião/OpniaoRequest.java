package br.com.zup.MercadoLivre.Opnião;

import br.com.zup.MercadoLivre.Login.Usuario;
import br.com.zup.MercadoLivre.Produto.Produto;
import br.com.zup.MercadoLivre.Produto.ProdutoRepository;
import br.com.zup.MercadoLivre.Validacoes.ExisteId;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class OpniaoRequest {


    @NotBlank
    private String titulo;

    @Range(min = 1, max = 5)
    private byte nota;

    @NotBlank
    @Length(max = 500)
    private  String descricao;

    public String getTitulo() {
        return titulo;
    }

    public byte getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public Opniao toModel(ProdutoRepository produtoRepository, Usuario usuario, Produto produto){

        return new Opniao(usuario,produto, this.titulo, this.nota, this.descricao);

    }

}
