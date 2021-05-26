package br.com.zup.MercadoLivre.Produto;

import br.com.zup.MercadoLivre.Categoria.CategoriaRepository;
import br.com.zup.MercadoLivre.Login.Usuario;

import br.com.zup.MercadoLivre.Produto.Imagens.*;
import br.com.zup.MercadoLivre.TratandoErros.ErrosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ControllerProduto {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ImagemRepository imagemRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public void save(@RequestBody @Valid ProdutoRequest produtoRequest, @AuthenticationPrincipal Usuario usuario){
        produtoRepository.save(produtoRequest.toModel(categoriaRepository, usuario));

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> save(@Valid ImagensRequest insereImagensRequest, @PathVariable Long id, @AuthenticationPrincipal Usuario usuario, salvaImagem imagem){

       Optional<Produto>  produto = produtoRepository.findById(id);

        if(produto.isEmpty()) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrosDto("Produto","Produto não existe"));
        }

        Optional<Produto> usuario1 = produtoRepository.findByUsuarioLogado(id,usuario.getId());

        if (usuario1.isEmpty()){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrosDto("Usuario","O usuario logado não é vendedor do produto"));

        }

        List<Imagens> imagens = (List<Imagens>) imagemRepository.saveAll(insereImagensRequest.toModel(imagem, produto.get()));

        produto.get().getImagens().addAll(imagens);

        return ResponseEntity.ok(produto.get().getImagens().stream().map(ImagemResponse::new).collect(Collectors.toList()));


    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getProduto(@PathVariable Long id){

        Optional<Produto>  produto = produtoRepository.findById(id);

        if(produto.isEmpty()) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrosDto("Produto","Produto não existe"));
        }

        return ResponseEntity.ok(produto.stream().map(o -> new ProdutoResponse(produto.get(),produtoRepository)).collect(Collectors.toList()));


    }
}
