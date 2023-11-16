package jofernando.github.com.primeiro.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jofernando.github.com.primeiro.models.Endereco;

@Repository
public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {

}
