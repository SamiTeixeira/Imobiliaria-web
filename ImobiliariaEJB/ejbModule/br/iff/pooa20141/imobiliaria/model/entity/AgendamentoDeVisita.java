package br.iff.pooa20141.imobiliaria.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the agendamento_de_visita database table.
 * 
 */
@Entity
@Table(name="agendamento_de_visita")
@NamedQuery(name="AgendamentoDeVisita.findAll", query="SELECT a FROM AgendamentoDeVisita a")
public class AgendamentoDeVisita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_agendamento_de_visita")
	private Integer idAgendamentoDeVisita;

	@Temporal(TemporalType.DATE)
	private Date data;

	private String hora;

	//bi-directional many-to-one association to Imovel
	@ManyToOne
	@JoinColumn(name="fk_imovel")
	private Imovel imovel;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="fk_usuario")
	private Usuario usuario;

	public AgendamentoDeVisita() {
	}

	public Integer getIdAgendamentoDeVisita() {
		return this.idAgendamentoDeVisita;
	}

	public void setIdAgendamentoDeVisita(Integer idAgendamentoDeVisita) {
		this.idAgendamentoDeVisita = idAgendamentoDeVisita;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Imovel getImovel() {
		return this.imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}