package jofernando.github.com.primeiro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jofernando.github.com.primeiro.models.Endereco;
import jofernando.github.com.primeiro.models.Grupo;
import jofernando.github.com.primeiro.models.MensagemGrupo;
import jofernando.github.com.primeiro.models.MensagemPrivada;
import jofernando.github.com.primeiro.models.Usuario;
import jofernando.github.com.primeiro.repositorios.GrupoRepositorio;
import jofernando.github.com.primeiro.repositorios.MensagemGrupoRepositorio;
import jofernando.github.com.primeiro.repositorios.MensagemPrivadaRepositorio;
import jofernando.github.com.primeiro.repositorios.UsuarioRepositorio;

@SpringBootTest
class PrimeiroApplicationTests {
	
	@Autowired
	private UsuarioRepositorio userRep;
	@Autowired
	private GrupoRepositorio grupoRep;
	@Autowired
	private MensagemPrivadaRepositorio msgpRep;
	@Autowired
	private MensagemGrupoRepositorio msggRep;

	@Test
	void contextLoads() {
		Endereco end = Endereco.builder()
				.logradouro("rua manoel tenorio")
				.cidade("iati")
				.cep("55345-000")
				.bairro("centro")
				.uf("pe")
				.build();
		Endereco end1 = Endereco.builder()
				.logradouro("rua emilia eliziario")
				.cidade("iati")
				.cep("55345-000")
				.bairro("centro")
				.uf("pe")
				.build();
		Usuario user = Usuario.builder()
				.email("joao@gmail.com")
				.nome("joao")
				.telefone("87981352717")
				.endereco(end)
				.build();
		Usuario admin = Usuario.builder()
				.email("jhon@gmail.com")
				.nome("jhon")
				.telefone("87981325717")
				.endereco(end1)
				.build();
		user = this.userRep.save(user);
		admin = this.userRep.save(admin);
		List<Usuario> membros = new ArrayList<>();
		membros.add(user);
		Grupo grupo = Grupo.builder()
				.nome("super chat")
				.administrador(admin)
				.membros(membros)
				.build();
		grupo = this.grupoRep.save(grupo);
		MensagemPrivada msg = MensagemPrivada.builder()
				.horario(LocalDate.now())
				.texto("iae man")
				.remetente(user)
				.destinatario(admin)
				.build();
		msg = this.msgpRep.save(msg);
		MensagemGrupo msggrupo = MensagemGrupo.builder()
				.horario(LocalDate.now())
				.texto("fala grupo")
				.remetente(user)
				.build();
		msggrupo = this.msggRep.save(msggrupo);
		List<MensagemGrupo> msgsGrupo = new ArrayList<>();
		msgsGrupo.add(msggrupo);
		grupo.setMensagens(msgsGrupo);
		grupo = this.grupoRep.save(grupo);
	}

}
