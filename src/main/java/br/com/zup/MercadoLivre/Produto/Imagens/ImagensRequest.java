package br.com.zup.MercadoLivre.Produto.Imagens;


import br.com.zup.MercadoLivre.Produto.Produto;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImagensRequest {

    @NotEmpty
    @Size(min = 1)
    private List<MultipartFile> multipartFiles = new ArrayList<>();

    public List<MultipartFile> getMultipartFiles() {
        return multipartFiles;
    }

    public void setMultipartFiles(List<MultipartFile> multipartFiles) {
        this.multipartFiles = multipartFiles;
    }

    public String TransformaImg(MultipartFile multipartFile) throws  IOException {
        return  new String(Base64.encodeBase64(multipartFile.getBytes()), "UTF-8");

    }

    public List<Imagens> toModel(UparImagem save, Produto produto) {


        return this.multipartFiles.stream().map(o -> {
           try {
               return new Imagens( o.getOriginalFilename(),TransformaImg(o),save.saveImagem(o), produto );
           } catch (IOException e) {
               e.printStackTrace();
           }
                   return null;
               }
       ).collect(Collectors.toList());
    }
}
