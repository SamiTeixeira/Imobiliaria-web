package br.iff.pooa20141.imobiliaria.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proprietario database table.
 * 
 */
@Entity
@NamedQuery(name="Proprietario.findAll", query="SELECT p FROM Proprietario p")
public class Proprietario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idproprietario;

	private String cpf;

	private String email;

	private String endereco;

	private String nome;

	private String telefone;

	//bi-directional many-to-one association to Imovel
	@OneToMany(mappedBy="proprietario")
	private List<Imovel> imovels;

	public Proprietario() {
	}

	public Integer getIdproprietario() {
		return this.idproprietario;
	}

	public void setIdproprietario(Integer idproprietario) {
		this.idproprietario = idproprietario;
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

	public List<Imovel> getImovels() {
		return this.imovels;
	}

	public void setImovels(List<Imovel> imovels) {
		this.imovels = imovels;
	}

	public Imovel addImovel(Imovel imovel) {
		getImovels().add(imovel);
		imovel.setProprietario(this);

		return imovel;
	}

	public Imovel removeImovel(Imovel imovel) {
		getImovels().remove(imovel);
		imovel.setProprietario(null);

		return imovel;
	}

}