package br.com.zup.MercadoLivre.Pergunta;

import br.com.zup.MercadoLivre.Login.Usuario;
import br.com.zup.MercadoLivre.Login.UsuarioResponse;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PerguntaResponse {

    private String titulo;

    private String descricao;

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }


    public PerguntaResponse(Pergunta pergunta) {

        this.titulo = pergunta.getTitulo();
        this.descricao = pergunta.getDescricao();
    }
}
