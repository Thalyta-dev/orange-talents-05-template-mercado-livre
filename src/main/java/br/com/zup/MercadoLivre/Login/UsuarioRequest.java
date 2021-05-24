package br.com.zup.MercadoLivre.Login;




import br.com.zup.MercadoLivre.Validacoes.UniqueValue;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class UsuarioRequest {

    @Email
    @NotEmpty
    @UniqueValue(domainClass = Usuario.class, fieldName = "email", message = "O email de login já está em uso")
    private String email;


    @NotNull
    @Length(min = 8, message = "A senha não tem o tamanho necessário de 8 caracters")
    private String senha;

    @PastOrPresent
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

    public Usuario toModel(){
        return new Usuario(this.email, new BCryptPasswordEncoder().encode(this.senha), this.localDateTime);
    }

}
