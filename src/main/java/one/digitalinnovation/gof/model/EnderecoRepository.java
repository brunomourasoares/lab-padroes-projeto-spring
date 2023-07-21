package one.digitalinnovation.gof.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
    List<Endereco> findByBairroIgnoreCase(String bairro);
}