package br.iff.pooa20141.imobiliaria.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the imovel database table.
 * 
 */
@Entity
@NamedQuery(name="Imovel.findAll", query="SELECT i FROM Imovel i")
public class Imovel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_imovel")
	private Integer idImovel;

	private double area;

	@Column(name="area_de_servico")
	private Integer areaDeServico;

	@Column(name="area_externa")
	private Integer areaExterna;

	private Integer banheiro;

	private Integer cozinha;

	private String endereco;

	private Integer garagem;

	private Integer quarto;

	private Integer sala;

	//bi-directional many-to-one association to AgendamentoDeVisita
	@OneToMany(mappedBy="imovel")
	private List<AgendamentoDeVisita> agendamentoDeVisitas;

	//bi-directional many-to-one association to Proprietario
	@ManyToOne
	@JoinColumn(name="fk_proprietario")
	private Proprietario proprietario;

	//bi-directional many-to-one association to TipoDeImovel
	@ManyToOne
	@JoinColumn(name="fk_tipo_imovel")
	private TipoDeImovel tipoDeImovel;

	//bi-directional many-to-one association to Proposta
	@OneToMany(mappedBy="imovel")
	private List<Proposta> propostas;

	public Imovel() {
	}

	public Integer getIdImovel() {
		return this.idImovel;
	}

	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}

	public double getArea() {
		return this.area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Integer getAreaDeServico() {
		return this.areaDeServico;
	}

	public void setAreaDeServico(Integer areaDeServico) {
		this.areaDeServico = areaDeServico;
	}

	public Integer getAreaExterna() {
		return this.areaExterna;
	}

	public void setAreaExterna(Integer areaExterna) {
		this.areaExterna = areaExterna;
	}

	public Integer getBanheiro() {
		return this.banheiro;
	}

	public void setBanheiro(Integer banheiro) {
		this.banheiro = banheiro;
	}

	public Integer getCozinha() {
		return this.cozinha;
	}

	public void setCozinha(Integer cozinha) {
		this.cozinha = cozinha;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getGaragem() {
		return this.garagem;
	}

	public void setGaragem(Integer garagem) {
		this.garagem = garagem;
	}

	public Integer getQuarto() {
		return this.quarto;
	}

	public void setQuarto(Integer quarto) {
		this.quarto = quarto;
	}

	public Integer getSala() {
		return this.sala;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}

	public List<AgendamentoDeVisita> getAgendamentoDeVisitas() {
		return this.agendamentoDeVisitas;
	}

	public void setAgendamentoDeVisitas(List<AgendamentoDeVisita> agendamentoDeVisitas) {
		this.agendamentoDeVisitas = agendamentoDeVisitas;
	}

	public AgendamentoDeVisita addAgendamentoDeVisita(AgendamentoDeVisita agendamentoDeVisita) {
		getAgendamentoDeVisitas().add(agendamentoDeVisita);
		agendamentoDeVisita.setImovel(this);

		return agendamentoDeVisita;
	}

	public AgendamentoDeVisita removeAgendamentoDeVisita(AgendamentoDeVisita agendamentoDeVisita) {
		getAgendamentoDeVisitas().remove(agendamentoDeVisita);
		agendamentoDeVisita.setImovel(null);

		return agendamentoDeVisita;
	}

	public Proprietario getProprietario() {
		return this.proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public TipoDeImovel getTipoDeImovel() {
		return this.tipoDeImovel;
	}

	public void setTipoDeImovel(TipoDeImovel tipoDeImovel) {
		this.tipoDeImovel = tipoDeImovel;
	}

	public List<Proposta> getPropostas() {
		return this.propostas;
	}

	public void setPropostas(List<Proposta> propostas) {
		this.propostas = propostas;
	}

	public Proposta addProposta(Proposta proposta) {
		getPropostas().add(proposta);
		proposta.setImovel(this);

		return proposta;
	}

	public Proposta removeProposta(Proposta proposta) {
		getPropostas().remove(proposta);
		proposta.setImovel(null);

		return proposta;
	}

}