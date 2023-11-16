package jofernando.github.com.primeiro.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jofernando.github.com.primeiro.models.MensagemGrupo;

@Repository
public interface MensagemGrupoRepositorio extends JpaRepository<MensagemGrupo, Long> {

}
