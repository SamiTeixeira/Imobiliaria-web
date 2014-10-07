package br.iff.pooa20141.imobiliaria.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.imobiliaria.model.entity.Usuario;


@Remote

public interface UsuarioPersistenceRemote {
	
	public Usuario inserir(int idUsuario,  String nome, String cpf, String telefone, String email, String endereco);

	public Usuario update(int idUsuario,  String nome, String cpf, String telefone, String email, String endereco);

	public Usuario find(int idUsuario);

	public void delete(int idUsuario);

	@XmlElement(name = "usuario")
	public List<Usuario> findAll();

}
