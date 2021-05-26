package br.com.zup.MercadoLivre.Produto.Imagens;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public interface UparImagem {

    public  String saveImagem(MultipartFile imagens);
}
