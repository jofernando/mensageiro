package jofernando.github.com.primeiro.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
public class MensagemPrivada extends Mensagem {
	@ManyToOne
	private Usuario destinatario;
}
