package br.com.zup.MercadoLivre.Produto.Imagens;

import java.util.List;

public class ImagemResponse {

    private String nomeImagem;

    private String url;

    public ImagemResponse(Imagens imagens) {

        this.nomeImagem = imagens.getNome();
        this.url = imagens.getUrl();
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public String getUrl() {
        return url;
    }
}
