package br.com.zup.MercadoLivre.Compra;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public enum MetodoPagamento {
    PAYPAL{
        @Override
        String retornaUrl(Compra compra, UriComponentsBuilder uriComponentsBuilder) {
            URI uri = uriComponentsBuilder.path("/compra/{id}/fecharcompras").buildAndExpand(compra.getId()).toUri();
           return "paypal.com?buyerId=" + compra.getId() + "&redirectUrl=" + uri ;
        }
    },
    PAGSEGURO{

        @Override
        String retornaUrl(Compra compra, UriComponentsBuilder uriComponentsBuilder) {
            URI uri = uriComponentsBuilder.path("/compra/{id}/fecharcompras").buildAndExpand(compra.getId()).toUri();
            return "pagseguro.com?returnId=" + compra.getId() + "&redirectUrl=" + uri ;
        }
    };

    abstract String retornaUrl(Compra compra, UriComponentsBuilder uriComponentsBuilder);

}
