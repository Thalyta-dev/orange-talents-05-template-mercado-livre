package br.com.zup.MercadoLivre.Transacao;

import br.com.zup.MercadoLivre.Transacao.Compra;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public enum MetodoPagamento {

    PAYPAL{

        @Override
        URI retornaUrl(Compra compra, UriComponentsBuilder uriComponentsBuilder) {

            URI uri = uriComponentsBuilder.path("/gateway/retorno-paypal/{id}").buildAndExpand(compra.getId()).toUri();
            return uri ;

        }

    },
    PAGSEGURO{

        @Override
        URI retornaUrl(Compra compra, UriComponentsBuilder uriComponentsBuilder) {
            URI uri = uriComponentsBuilder.path("/gateway/retorno-pagseguro/{id}").buildAndExpand(compra.getId()).toUri();
            return uri;
        }

    };

    abstract URI retornaUrl(Compra compra, UriComponentsBuilder uriComponentsBuilder);


}
