package br.com.zup.MercadoLivre.Login;

import br.com.zup.MercadoLivre.Validacoes.UniqueValue;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class LoginRequest {

    @Email
    @NotEmpty
    @UniqueValue(fieldName = "email", domainClass = Login.class)
    private String email;

    @NotNull
    private String senha;

    private LocalDateTime localDateTime = LocalDateTime.now();

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Login toModel(){

        String senha = new BCryptPasswordEncoder().encode(this.senha);
        return new Login(this.email, senha, this.localDateTime);
    }
}
