package br.com.zup.MercadoLivre.Transacao;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface FinalizaCompra {

        @PostMapping("/pagseguro.com/{idCompra}")
        void pagSeguro(@PathVariable Long idCompra);

        @PostMapping("/paypal.com/{idCompra}")
        void paypal(@PathVariable Long idCompra);

}
