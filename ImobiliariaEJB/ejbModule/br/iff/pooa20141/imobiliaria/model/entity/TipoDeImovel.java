package br.iff.pooa20141.imobiliaria.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_de_imovel database table.
 * 
 */
@Entity
@Table(name="tipo_de_imovel")
@NamedQuery(name="TipoDeImovel.findAll", query="SELECT t FROM TipoDeImovel t")
public class TipoDeImovel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_de_imovel")
	private Integer idTipoDeImovel;

	private String descricao;

	@Column(name="tipo_de_contrato")
	private String tipoDeContrato;

	private double valor;

	//bi-directional many-to-one association to Imovel
	@OneToMany(mappedBy="tipoDeImovel")
	private List<Imovel> imovels;

	public TipoDeImovel() {
	}

	public Integer getIdTipoDeImovel() {
		return this.idTipoDeImovel;
	}

	public void setIdTipoDeImovel(Integer idTipoDeImovel) {
		this.idTipoDeImovel = idTipoDeImovel;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoDeContrato() {
		return this.tipoDeContrato;
	}

	public void setTipoDeContrato(String tipoDeContrato) {
		this.tipoDeContrato = tipoDeContrato;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Imovel> getImovels() {
		return this.imovels;
	}

	public void setImovels(List<Imovel> imovels) {
		this.imovels = imovels;
	}

	public Imovel addImovel(Imovel imovel) {
		getImovels().add(imovel);
		imovel.setTipoDeImovel(this);

		return imovel;
	}

	public Imovel removeImovel(Imovel imovel) {
		getImovels().remove(imovel);
		imovel.setTipoDeImovel(null);

		return imovel;
	}

	
	
	

}