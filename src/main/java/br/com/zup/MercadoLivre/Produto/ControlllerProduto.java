package br.com.zup.MercadoLivre.Produto;

import br.com.zup.MercadoLivre.Categoria.Categoria;
import br.com.zup.MercadoLivre.Categoria.CategoriaRepository;
import br.com.zup.MercadoLivre.Login.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ControlllerProduto {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public void save(@RequestBody @Valid ProdutoRequest produtoRequest, @AuthenticationPrincipal Usuario usuario){
        produtoRepository.save(produtoRequest.toModel(categoriaRepository, usuario));

    }
}
