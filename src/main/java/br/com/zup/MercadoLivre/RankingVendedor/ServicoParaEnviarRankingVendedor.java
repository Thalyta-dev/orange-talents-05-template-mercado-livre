package br.com.zup.MercadoLivre.RankingVendedor;

import br.com.zup.MercadoLivre.NF.DadosNf;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@FeignClient(name="ranking", url = "http://localhost:8080/rankingVendedor")
public interface ServicoParaEnviarRankingVendedor {


      @PostMapping
      public String ranking(@RequestHeader("Authorization") String token,  RankingVendedorDto vendedorDto);

}


