package one.digitalinnovation.gof.service;

import java.util.List;

import one.digitalinnovation.gof.model.Cliente;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author falvojr
 */
public interface ClienteService {

	Iterable<Cliente> buscarTodos();

	Cliente buscarPorId(Long id);

	List<Cliente> buscarPorNome(String nomeParcial);

	List<Cliente> buscarPorBairro(String bairro);

	void inserir(Cliente cliente);

	void atualizar(Long id, Cliente cliente);

	void deletar(Long id);
}
