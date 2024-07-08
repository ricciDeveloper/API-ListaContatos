package spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.Model.ListaContatos;
@Repository
public interface ListaRepository extends JpaRepository<ListaContatos, Long> {
}
