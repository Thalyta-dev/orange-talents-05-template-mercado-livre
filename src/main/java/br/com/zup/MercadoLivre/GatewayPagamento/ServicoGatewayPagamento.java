package br.com.zup.MercadoLivre.GatewayPagamento;

import org.springframework.beans.factory.annotation.Autowired;
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

       return   transacaoController.pagseguro(pagSeguro,id,request.getHeader("Authorization"));

    }

    @PostMapping("/retorno-paypal/{id}")
    public ResponseEntity<?> payPal(@PathVariable  Long id, HttpServletRequest request){

        String status = "ERRO";

        if (retornaStatus()){
            status = "SUCESS";
        }

        PayPal payPal = new PayPal(retornaIdTransacao(), status);

        return   transacaoController.payPal(payPal,id,request.getHeader("Authorization"));

    }
    public Long retornaIdTransacao(){

        Random random = new Random();

        Integer numero = random.nextInt(40);

        return  numero.longValue();
    }


    public Boolean retornaStatus(){

        Random random = new Random();

        Boolean statusCompra = random.nextBoolean();

        return  statusCompra;
    }
}
