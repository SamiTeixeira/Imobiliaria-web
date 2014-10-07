package br.iff.pooa20141.imobiliaria.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.imobiliaria.model.entity.Proprietario;


@Stateless
@LocalBean
public class ProprietarioPersistence extends AbstractPersistence implements
		ProprietarioPersistenceRemote {

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.ProprietarioPersistenceRemote#inserir(java.lang.String, java.lang.String)
	 */
	@Override
	public Proprietario inserir(int idProprietario,  String nome, String cpf, String telefone, String email, String endereco) {
		Proprietario proprietario = new Proprietario();
		proprietario.setIdproprietario(idProprietario);
		proprietario.setNome(nome);
		proprietario.setCpf(cpf);
		proprietario.setTelefone(telefone);
		proprietario.setEmail(email);
		proprietario.setEndereco(endereco);
		super.insert(proprietario);
		return proprietario;
	}
	
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistenceRemote#update(java.lang.String, java.lang.String)
	 */
	@Override
	public Proprietario update(int idProprietario,  String nome, String cpf, String telefone, String email, String endereco) {
		Proprietario proprietario = super.find(Proprietario.class, idProprietario);
		proprietario.setIdproprietario(idProprietario);
		proprietario.setNome(nome);
		proprietario.setCpf(cpf);
		proprietario.setTelefone(telefone);
		proprietario.setEmail(email);
		proprietario.setEndereco(endereco);
		super.update(proprietario);
		return proprietario;
	}
	
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.ProprietarioPersistenceRemote#find(java.lang.String)
	 */
	@Override
	public Proprietario find(int idProprietario) {
		return super.find(Proprietario.class,idProprietario);
	}
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.ProprietarioPersistenceRemote#delete(java.lang.String)
	 */
	@Override
	public void delete(int idProprietario) {
		super.delete(Proprietario.class, idProprietario);

	}
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.ProprietarioPersistenceRemote#findAll()
	 */
	@XmlElement(name = "proprietarios")
	public List<Proprietario> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(Proprietario.class);
	}

	
}
