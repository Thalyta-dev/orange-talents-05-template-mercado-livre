package br.com.zup.MercadoLivre.Login;




import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class LoginRequest {

    @Email
    @NotEmpty
    private String email;


    @NotNull
    @Length(min = 8, message = "A senha não tem o tamanho necessario")
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
        return new Login(this.email, this.senha, this.localDateTime);
    }
}
