package br.iff.pooa20141.imobiliaria.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private Integer idUsuario;

	private String cpf;

	private String email;

	private String endereco;

	private String nome;

	private String telefone;

	//bi-directional many-to-one association to AgendamentoDeVisita
	@OneToMany(mappedBy="usuario")
	private List<AgendamentoDeVisita> agendamentoDeVisitas;

	//bi-directional many-to-one association to Proposta
	@OneToMany(mappedBy="usuario")
	private List<Proposta> propostas;

	public Usuario() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<AgendamentoDeVisita> getAgendamentoDeVisitas() {
		return this.agendamentoDeVisitas;
	}

	public void setAgendamentoDeVisitas(List<AgendamentoDeVisita> agendamentoDeVisitas) {
		this.agendamentoDeVisitas = agendamentoDeVisitas;
	}

	public AgendamentoDeVisita addAgendamentoDeVisita(AgendamentoDeVisita agendamentoDeVisita) {
		getAgendamentoDeVisitas().add(agendamentoDeVisita);
		agendamentoDeVisita.setUsuario(this);

		return agendamentoDeVisita;
	}

	public AgendamentoDeVisita removeAgendamentoDeVisita(AgendamentoDeVisita agendamentoDeVisita) {
		getAgendamentoDeVisitas().remove(agendamentoDeVisita);
		agendamentoDeVisita.setUsuario(null);

		return agendamentoDeVisita;
	}

	public List<Proposta> getPropostas() {
		return this.propostas;
	}

	public void setPropostas(List<Proposta> propostas) {
		this.propostas = propostas;
	}

	public Proposta addProposta(Proposta proposta) {
		getPropostas().add(proposta);
		proposta.setUsuario(this);

		return proposta;
	}

	public Proposta removeProposta(Proposta proposta) {
		getPropostas().remove(proposta);
		proposta.setUsuario(null);

		return proposta;
	}

}