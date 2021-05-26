package br.com.zup.MercadoLivre.Login;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String username);
}
