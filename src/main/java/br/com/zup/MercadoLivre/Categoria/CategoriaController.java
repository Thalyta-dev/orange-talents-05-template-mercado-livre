package br.com.zup.MercadoLivre.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public void save(@RequestBody  @Valid CategoriaRequest categoriaRequest){

            categoriaRepository.save(categoriaRequest.toModel(categoriaRepository));

    }
}
