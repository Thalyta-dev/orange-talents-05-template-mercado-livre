package br.com.zup.MercadoLivre.Produto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    @Query(value = "select * from produto where id = :id_produto and vendedor_id = :id_usuario", nativeQuery = true)
    Optional<Produto> findByUsuarioLogado(Long id_produto, Long id_usuario);

    @Query(value = "select avg(o.nota) from produto as p inner join opniao as o on  p.id = o.produto_id where produto_id = :id_produto ", nativeQuery = true)
    Optional<Float> mediaDeAvaliaçoes(Long id_produto);

    @Query(value = "select count(o.nota) from produto as p inner join opniao as o on  p.id = o.produto_id where produto_id = :id_produto ", nativeQuery = true)
    Optional<Integer> quantidadeNota(Long id_produto);

}
