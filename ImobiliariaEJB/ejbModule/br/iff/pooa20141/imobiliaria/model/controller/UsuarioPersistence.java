package br.iff.pooa20141.imobiliaria.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.imobiliaria.model.entity.Usuario;

@Stateless
@LocalBean



public class UsuarioPersistence extends AbstractPersistence implements
		UsuarioPersistenceRemote {

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistenceRemote#inserir(java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario inserir(int idUsuario,  String nome, String cpf, String telefone, String email, String endereco) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);
		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setTelefone(telefone);
		usuario.setEmail(email);
		usuario.setEndereco(endereco);
		super.insert(usuario);
		return usuario;
	}
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistenceRemote#update(java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario update(int idUsuario,  String nome, String cpf, String telefone, String email, String endereco) {
		Usuario usuario = super.find(Usuario.class, idUsuario);
		usuario.setIdUsuario(idUsuario);
		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setTelefone(telefone);
		usuario.setEmail(email);
		usuario.setEndereco(endereco);
		super.update(usuario);
		return usuario;
	}
	
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistenceRemote#find(java.lang.String)
	 */
	@Override
	public Usuario find(int idUsuario) {
		return super.find(Usuario.class,idUsuario);
	}
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistenceRemote#delete(java.lang.String)
	 */
	@Override
	public void delete(int idUsuario) {
		super.delete(Usuario.class, idUsuario);

	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistenceRemote#findAll()
	 */
	@XmlElement(name = "usuarios")
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(Usuario.class);
	}

	
	
}
