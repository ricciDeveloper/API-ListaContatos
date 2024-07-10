package spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.Model.ListaContatos;

import java.util.List;


@Repository
public interface ListaRepository extends JpaRepository<ListaContatos, Long> {

    List<ListaContatos> findByNomeContatoContainingIgnoreCase(String nomeContato);
    List<ListaContatos> findByApelidoContainingIgnoreCase(String apelido);
}
