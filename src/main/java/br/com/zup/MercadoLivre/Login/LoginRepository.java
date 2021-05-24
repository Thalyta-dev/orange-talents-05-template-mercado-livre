package br.com.zup.MercadoLivre.Login;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LoginRepository extends CrudRepository<Login, Long> {
    Optional<Login> findByEmail(String username);
}
