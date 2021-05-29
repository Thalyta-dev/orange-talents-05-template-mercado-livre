package br.com.zup.MercadoLivre.NF;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/gerarNfs")
public class NF {


    @PostMapping
    public String gerarNfs(HttpServletRequest request, @RequestBody DadosNf dadosNf){
        return "nf gerada";
    }


}
