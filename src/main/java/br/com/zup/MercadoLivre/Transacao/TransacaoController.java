package br.com.zup.MercadoLivre.Transacao;


import br.com.zup.MercadoLivre.GatewayPagamento.GatawayPagamento;
import br.com.zup.MercadoLivre.GatewayPagamento.PagSeguro;
import br.com.zup.MercadoLivre.GatewayPagamento.PayPal;
import br.com.zup.MercadoLivre.TratandoErros.ErrosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/finalizaCompra")
public class TransacaoController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private  TransacaoRepository transacaoRepository;

    @Autowired
    private FinalizaTransacao retornoTransacao;

    @PostMapping("/pagseguro/{idcompra}")
    public ResponseEntity<?> pagSeguro(@Valid @RequestBody PagSeguro transacaoRequest, @PathVariable Long idcompra, HttpServletRequest request){
        return setFinalizaCompra(transacaoRequest, idcompra,request);
    }


    @PostMapping("/paypay/{idcompra}")
    public ResponseEntity<?> payPal(@Valid @RequestBody PayPal transacaoRequest, @PathVariable Long idcompra, HttpServletRequest request){

        return setFinalizaCompra(transacaoRequest, idcompra,request);
    }


    public ResponseEntity<?> setFinalizaCompra(GatawayPagamento transacaoRequest,  Long idcompra, HttpServletRequest request){

        Optional<Compra> compra = compraRepository.findById(idcompra);

        if(compra.isEmpty()){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrosDto("Compra","Essa compra não exite"));
        }

        Optional<Integer> idTransacaoUnico = transacaoRepository.idTransacaoUnico(transacaoRequest.getIdpagamento());

        if(idTransacaoUnico.get()>0){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrosDto("Transacao","Id da transação não único"));
        }

        Optional<Integer> compraSucesso = compraRepository.compraSucesso(idcompra);

        if(compraSucesso.get()>0){
            return   ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrosDto("Compra","Essa compra já foi efetuada"));
        }

        Transacao transacao= transacaoRepository.save(transacaoRequest.toModel(compra.get()));
        compra.get().list.add(transacao);

        return retornoTransacao.transacao(transacao,request);

    }
}
