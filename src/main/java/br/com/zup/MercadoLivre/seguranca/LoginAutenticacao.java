package br.com.zup.MercadoLivre.seguranca;




import br.com.zup.MercadoLivre.Login.Login;
import br.com.zup.MercadoLivre.Validacoes.UniqueValue;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class LoginAutenticacao {

    private String email;

    private String senha;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public UsernamePasswordAuthenticationToken toAutenticationToken() {
        return  new UsernamePasswordAuthenticationToken(email,senha);
    }
}
