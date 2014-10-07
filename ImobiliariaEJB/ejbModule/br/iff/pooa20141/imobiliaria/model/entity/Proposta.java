package br.iff.pooa20141.imobiliaria.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the proposta database table.
 * 
 */
@Entity
@NamedQuery(name="Proposta.findAll", query="SELECT p FROM Proposta p")
public class Proposta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_proposta")
	private Integer idProposta;

	private String satatus;

	private double valor;

	//bi-directional many-to-one association to Imovel
	@ManyToOne
	@JoinColumn(name="fk_imovel")
	private Imovel imovel;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="fk_usuario")
	private Usuario usuario;

	public Proposta() {
	}

	public Integer getIdProposta() {
		return this.idProposta;
	}

	public void setIdProposta(Integer idProposta) {
		this.idProposta = idProposta;
	}

	public String getSatatus() {
		return this.satatus;
	}

	public void setSatatus(String satatus) {
		this.satatus = satatus;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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