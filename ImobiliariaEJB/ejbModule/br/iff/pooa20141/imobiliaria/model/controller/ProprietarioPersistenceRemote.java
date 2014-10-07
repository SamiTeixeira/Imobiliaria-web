package br.iff.pooa20141.imobiliaria.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.imobiliaria.model.entity.Proprietario;

@Remote

public interface ProprietarioPersistenceRemote {
	
	public Proprietario inserir(int idProprietario,  String nome, String cpf, String telefone, String email, String endereco);

	public Proprietario update(int idProprietario,  String nome, String cpf, String telefone, String email, String endereco);

	public Proprietario find(int idProprietario);

	public void delete(int idProprietario);

	@XmlElement(name = "proprietario")
	public List<Proprietario> findAll();

}
