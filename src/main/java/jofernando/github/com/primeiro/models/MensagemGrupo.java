package jofernando.github.com.primeiro.models;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
public class MensagemGrupo extends Mensagem {

}
