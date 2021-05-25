package br.com.zup.MercadoLivre.Produto.Imagens;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

public class salvaImagem implements UparImagem{


    @Override
    public String saveImagem(MultipartFile imagens) {
        return "https://Imagens" + imagens.getOriginalFilename();
    }

}
