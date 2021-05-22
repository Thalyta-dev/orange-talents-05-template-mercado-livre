package br.com.zup.MercadoLivre.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @PostMapping
    public void save(@RequestBody  @Valid  LoginRequest loginRequest){
            loginRepository.save(loginRequest.toModel());

    }
}
