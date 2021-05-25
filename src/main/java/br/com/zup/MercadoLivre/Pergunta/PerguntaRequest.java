package br.com.zup.MercadoLivre.Pergunta;

import br.com.zup.MercadoLivre.Login.Usuario;
import br.com.zup.MercadoLivre.Produto.Produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PerguntaRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    public PerguntaRequest(String titulo,Long produto, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Pergunta toModel(Usuario usuario, Produto produto){
       return new Pergunta(this.titulo,usuario, produto, this.descricao);
    }
}
