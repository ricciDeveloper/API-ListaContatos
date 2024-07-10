package spring.Service;

import org.springframework.stereotype.Service;
import spring.Model.ListaContatos;

import java.util.List;


public interface ListaService {
    Iterable<ListaContatos> buscarTodosContatos();

    ListaContatos buscarPorId(Long id);

    void inserirContato(ListaContatos contato);

    void atualizarContato(Long id, ListaContatos contato);

    void deletarContato(Long id);

    List<ListaContatos> buscarPorNome(String nomeContato);
    List<ListaContatos> buscarPorApelido(String apelido);
}
