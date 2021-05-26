package br.com.zup.MercadoLivre.Compra;


import br.com.zup.MercadoLivre.Login.Usuario;
import br.com.zup.MercadoLivre.Pergunta.Email;
import br.com.zup.MercadoLivre.Pergunta.EnviarEmailServer;
import br.com.zup.MercadoLivre.Produto.Produto;
import br.com.zup.MercadoLivre.Produto.ProdutoRepository;
import br.com.zup.MercadoLivre.TratandoErros.ErrosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private Email enviarEmailServer;

    @PostMapping("/{id}")
    public ResponseEntity<?> saveCompra(@PathVariable Long id, @AuthenticationPrincipal Usuario usuario,
                                        @RequestBody @Valid CompraRequest compraRequest,  UriComponentsBuilder uriBuilder){
        Optional<Produto> produto = produtoRepository.findById(id);

        if(!produto.isEmpty() &&
                !produto.get().existQuantidadeProdutoAndRetira(compraRequest.getQuantidadeProduto())){

            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrosDto("Produto","Não tem estoque do produto"));

        }

        Compra compra = compraRepository.save(compraRequest.toModel(produto.get(), usuario));

        enviarEmailServer.enviarEmail(usuario.getUsername(),produto.get().getVendedor().getUsername(), "Uma venda foi realizada", "o produto "+ produto.get().getNome() + "foi vendido");

        return ResponseEntity.status(302).body(compra.getMetodoPagamento().retornaUrl(compra,uriBuilder));



    }
}
