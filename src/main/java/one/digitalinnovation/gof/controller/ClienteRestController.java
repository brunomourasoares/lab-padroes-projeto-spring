package one.digitalinnovation.gof.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.service.ClienteService;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 * 
 * @author falvojr
 */
@RestController
@RequestMapping("clientes")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<Iterable<Cliente>> buscarTodos() {
		return ResponseEntity.ok(clienteService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Cliente> inserir(@Valid @RequestBody Cliente cliente) {
		clienteService.inserir(cliente);
		return ResponseEntity.ok(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {
		clienteService.atualizar(id, cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		clienteService.deletar(id);
		return ResponseEntity.ok().build();
	}

    @GetMapping("/nome/{nomeParcial}")
    public ResponseEntity<Object> listaDeClientesPorNomeParcial(@PathVariable String nomeParcial) {
        List<Cliente> listaClientes = clienteService.buscarPorNome(nomeParcial);
        if (listaClientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nome não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(listaClientes);
    }

	@GetMapping("/bairro/{bairro}")
    public ResponseEntity<Object> listaDeClientesPorBairro(@PathVariable String bairro) {
    	List<Cliente> listaClientes = clienteService.buscarPorBairro(bairro);
    	if (listaClientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bairro não encontrado!");
        }
    	return ResponseEntity.status(HttpStatus.OK).body(listaClientes);
    }
}
