package br.com.zup.MercadoLivre.Produto.Imagens;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UparImagem {

    public  String saveImagem(MultipartFile imagens);
}
