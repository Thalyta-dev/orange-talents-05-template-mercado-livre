package br.com.zup.MercadoLivre;

import br.com.zup.MercadoLivre.NF.NF;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


@EnableSpringDataWebSupport
@EnableFeignClients
@SpringBootApplication
public class MercadoLivreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadoLivreApplication.class, args);



	}

}
