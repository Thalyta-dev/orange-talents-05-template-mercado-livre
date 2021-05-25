package br.com.zup.MercadoLivre.Produto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    @Query(value = "select * from produto where id = :id_produto and usuario_id = :id_usuario", nativeQuery = true)
    Optional<Produto> findByUsuarioLogado(Long id_produto, Long id_usuario);
}
