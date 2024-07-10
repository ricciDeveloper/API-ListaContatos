package spring.Service.Impl;

import org.springframework.stereotype.Service;
import spring.Model.ListaContatos;
import spring.Repository.ListaRepository;
import spring.Service.ListaService;

import java.util.List;
import java.util.Optional;

@Service
public class ListaServiceImpl implements ListaService {
    //injetamos o repository via construtor por boas práticas. Para teste podemos injetá-lo com autowired
    private final ListaRepository listaRepository;

    public ListaServiceImpl(ListaRepository listaRepository) {
        this.listaRepository = listaRepository;
    }

    @Override
    public Iterable<ListaContatos> buscarTodosContatos() {
        return listaRepository.findAll();
    }

    @Override
    public ListaContatos buscarPorId(Long id) {
        Optional<ListaContatos> contato = listaRepository.findById(id);
        return contato.get();
    }

    @Override
    public void inserirContato(ListaContatos contato) {
        listaRepository.save(contato);
    }

    @Override
    public void atualizarContato(Long id, ListaContatos contato) {
        Optional<ListaContatos> contatoBd = listaRepository.findById(id);
        if(contatoBd.isPresent()){
            listaRepository.save(contato);
        }else{
            throw new IllegalArgumentException("Contato não localizado pelo ID.");
        }
    }

    @Override
    public void deletarContato(Long id) {
        listaRepository.deleteById(id);
    }

    @Override
    public List<ListaContatos> buscarPorNome(String nomeContato) {

        return listaRepository.findByNomeContatoContainingIgnoreCase(nomeContato);
    }
}
