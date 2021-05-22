package br.com.zup.MercadoLivre.Login;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Login {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String senha;

    private LocalDateTime localDateTime;

    public Login(String email, String senha, LocalDateTime localDateTime) {
        this.email = email;
        this.senha =  new BCryptPasswordEncoder().encode(senha);
        this.localDateTime = localDateTime;
    }

    public Login( ) {
    }
}
