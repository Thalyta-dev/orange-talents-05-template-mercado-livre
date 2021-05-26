package br.com.zup.MercadoLivre.Produto.Imagens;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



public class salvaImagem implements UparImagem{


    @Override
    public String saveImagem(MultipartFile imagens) {
        return "https://Imagens" + imagens.getOriginalFilename();
    }

}
