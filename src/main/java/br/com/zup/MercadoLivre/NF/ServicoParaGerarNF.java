package br.com.zup.MercadoLivre.NF;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name="nf", url = "http://localhost:8080/gerarNfs")
public interface ServicoParaGerarNF {

   @PostMapping
    public String gerarNfs(@RequestHeader("Authorization") String token, DadosNf dadosNf);
}
