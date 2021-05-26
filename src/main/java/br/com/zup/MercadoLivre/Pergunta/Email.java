package br.com.zup.MercadoLivre.Pergunta;

import org.springframework.stereotype.Component;

@Component
public class Email implements  EnviarEmailServer{

    @Override
    public String enviarEmail(String remetente, String destinatario, String assunto, String corpo) {

        return "De: " + remetente+ "\n"
                + "Para: " + destinatario + "\n"
                + "Assunto: " + assunto + "\n"
                + "Corpo do email: " + corpo;

    }
}
