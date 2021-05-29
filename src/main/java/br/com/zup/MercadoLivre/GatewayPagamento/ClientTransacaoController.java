package br.com.zup.MercadoLivre.GatewayPagamento;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.validation.Valid;


@FeignClient(name="transacaoController", url = "http://localhost:8080/finalizaCompra")
public interface ClientTransacaoController {


    @PostMapping("/paypay/{idcompra}")
    public ResponseEntity<String> payPal(@RequestBody PayPal transacaoRequest, @PathVariable Long idcompra, @RequestHeader("Authorization")  String token);

    @PostMapping("/pagseguro/{idcompra}")
    public ResponseEntity<String> pagseguro(@RequestBody PagSeguro transacaoRequest, @PathVariable Long idcompra, @RequestHeader("Authorization") String token);

}
