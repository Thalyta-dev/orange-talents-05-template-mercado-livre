package br.com.zup.MercadoLivre.Pergunta;

public class Email implements  EnviarEmailServer{

    @Override
    public String enviarEmail(Pergunta pergunta) {

        return "De: " + pergunta.getUsuario().toString() + "\n"
                + "Para: " + pergunta.getProduto().toString() + "\n"
                + "Assunto: Uma pergunta foi adicionada ao produto " + pergunta.getProduto().getNome() + "\n"
                + "Titulo da pergunta: " + pergunta.getTitulo() + "\n"
                + "Descrição: " + pergunta.getDescricao() + "\n"
                + "Data da pergunta: A pegunta foi feita ás " + pergunta.getDateTime().getHour() + "h:" + pergunta.getDateTime().getMinute()  + ", " +pergunta.getDateTime().getDayOfMonth()+"/" +pergunta.getDateTime().getMonth() + "\n";

    }
}
