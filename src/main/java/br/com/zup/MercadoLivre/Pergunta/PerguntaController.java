package br.com.zup.MercadoLivre.Pergunta;


import br.com.zup.MercadoLivre.Categoria.CategoriaRequest;
import br.com.zup.MercadoLivre.Login.Usuario;
import br.com.zup.MercadoLivre.Produto.Produto;
import br.com.zup.MercadoLivre.Produto.ProdutoRepository;
import br.com.zup.MercadoLivre.TratandoErros.ErrosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {

    @Autowired
    private  PerguntaRepository perguntaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/{id}")
    public ResponseEntity<?> save(@RequestBody @Valid PerguntaRequest perguntaRequest, @AuthenticationPrincipal Usuario usuario, @PathVariable Long id, Email enviarEmailServer){

        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrosDto("Produto","Produto não existe"));
        }
       Pergunta pergunta= perguntaRepository.save(perguntaRequest.toModel(usuario,produto.get()));

        return  ResponseEntity.status(HttpStatus.OK).body( enviarEmailServer.enviarEmail(pergunta));

    }
}
