package spring.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.Model.ListaContatos;
import spring.Service.ListaService;

import java.util.List;

@RestController
@RequestMapping("contatos")
public class ListRestController {
    private final ListaService listaService;

    public ListRestController(ListaService listaService) {
        this.listaService = listaService;
    }

    @GetMapping
    public ResponseEntity<Iterable<ListaContatos>> buscarTodosContatos(){
        return ResponseEntity.ok(listaService.buscarTodosContatos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaContatos> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(listaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ListaContatos> inserirContato(@RequestBody ListaContatos contato) {
        listaService.inserirContato(contato);
        return ResponseEntity.ok(contato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaContatos> atualizarContato(@PathVariable Long id, @RequestBody ListaContatos contato){
        listaService.atualizarContato(id, contato);
        return ResponseEntity.ok(contato);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ListaContatos> deletarContato(@PathVariable Long id){
        listaService.deletarContato(id);
        return ResponseEntity.ok().build();
    }
}
