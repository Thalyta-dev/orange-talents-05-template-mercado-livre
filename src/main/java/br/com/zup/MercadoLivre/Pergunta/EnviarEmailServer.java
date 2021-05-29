package br.com.zup.MercadoLivre.Pergunta;

import br.com.zup.MercadoLivre.Produto.Produto;
import org.springframework.stereotype.Component;

@Component
public interface EnviarEmailServer {

    public String enviarEmail(String remetente, String destinatario, String assunto, String corpo);

}
