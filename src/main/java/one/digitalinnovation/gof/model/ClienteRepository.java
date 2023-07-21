package one.digitalinnovation.gof.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findByNomeContainingIgnoreCase(String nomeParcial);
    List<Cliente> findByEndereco(Endereco endereco);
}