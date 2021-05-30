package br.com.zup.MercadoLivre.GatewayPagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@RestController
@RequestMapping("/gateway")
public class ServicoGatewayPagamento {


    @Autowired
    private ClientTransacaoController transacaoController;

    @PostMapping("/retorno-pagseguro/{id}")
    public ResponseEntity<?> pagSeguro(@PathVariable  Long id, HttpServletRequest request){

        String status = "0";

        if (retornaStatus()){
            status = "1";
        }

        PagSeguro pagSeguro = new PagSeguro(retornaIdTransacao(), status);

        ResponseEntity<String>  retorno = transacaoController.pagseguro(pagSeguro, id, request.getHeader("Authorization" ));

        if (retorno.getStatusCode() != HttpStatus.OK){
            return  ResponseEntity.status(retorno.getStatusCode()).body(retorno.getBody());
        }

        return retorno;

    }

    @PostMapping("/retorno-paypal/{id}")
    public ResponseEntity<?> payPal(@PathVariable  Long id, HttpServletRequest request){

        String status = "ERRO";

        if (retornaStatus()){
            status = "SUCESS";
        }

        PayPal payPal = new PayPal(retornaIdTransacao(), status);

        ResponseEntity<String>  retorno = transacaoController.payPal(payPal,id,request.getHeader("Authorization"));

        if (retorno.getStatusCode() != HttpStatus.OK){
            System.out.println("olá");
            return  ResponseEntity.status(retorno.getStatusCode()).body(retorno.getBody());
        }

        return retorno;

    }
    public Long retornaIdTransacao(){

        Random random = new Random();

        Integer numero = random.nextInt(40);

        return  numero.longValue();
    }


    public Boolean retornaStatus(){

        System.out.println("olá");

        Random random = new Random();

        Boolean statusCompra = random.nextBoolean();

        return  statusCompra;
    }
}
