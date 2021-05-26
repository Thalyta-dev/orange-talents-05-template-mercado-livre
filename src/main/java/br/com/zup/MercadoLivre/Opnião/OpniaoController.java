package br.com.zup.MercadoLivre.Opnião;


import br.com.zup.MercadoLivre.Login.Usuario;
import br.com.zup.MercadoLivre.Produto.Produto;
import br.com.zup.MercadoLivre.Produto.ProdutoRepository;
import br.com.zup.MercadoLivre.TratandoErros.ErrosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/opnioes")
public class OpniaoController {

    @Autowired
    private OpniaoRepository opniaoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/{id}")
    public ResponseEntity<?> save(@Valid @RequestBody OpniaoRequest opniaoRequest, @PathVariable Long id, @AuthenticationPrincipal Usuario usuario){

        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrosDto("Produto","Produto não existe"));
        }

        produto.get().getOpniao().add(opniaoRepository.save(opniaoRequest.toModel(produtoRepository, usuario, produto.get())));
        return  ResponseEntity.status(HttpStatus.OK).build();
    }
}
