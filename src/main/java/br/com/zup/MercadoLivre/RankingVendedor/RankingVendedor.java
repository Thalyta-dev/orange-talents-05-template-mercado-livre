package br.com.zup.MercadoLivre.RankingVendedor;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/rankingVendedor")
@RestController
public class RankingVendedor {

    @PostMapping
    public String ranking(HttpServletRequest request, @RequestBody  RankingVendedorDto vendedorDto){
        return "Este é o ranking";
    }
}
