package br.iff.pooa20141.imobiliaria.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.imobiliaria.model.entity.Proposta;
import br.iff.pooa20141.imobiliaria.model.entity.Imovel;
import br.iff.pooa20141.imobiliaria.model.entity.Usuario;

@Stateless
@LocalBean

public class PropostaPersistence extends AbstractPersistence implements
		PropostaPersistenceRemote {
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.PropostaPersistenceRemote#inserir(java.lang.String, java.lang.String)
	 */
	@Override
	public Proposta inserir(int idProposta, String satatus, double valor, Imovel imovel, Usuario usuario ){
		Proposta proposta = new Proposta();
		proposta.setIdProposta(idProposta);
		proposta.setSatatus(satatus);
		proposta.setValor(valor);
		proposta.setImovel(imovel);
		proposta.setUsuario(usuario);
		super.insert(proposta);
		return proposta;
	}
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.PropostaPersistenceRemote#update(java.lang.String, java.lang.String)
	 */
	@Override
	public Proposta update(int idProposta, String satatus, double valor, Imovel imovel, Usuario usuario ) {
		Proposta proposta = super.find(Proposta.class, idProposta);
		proposta.setIdProposta(idProposta);
		proposta.setSatatus(satatus);
		proposta.setValor(valor);
		proposta.setImovel(imovel);
		proposta.setUsuario(usuario);
		super.update(proposta);
		return proposta;
	}
	
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.PropostaPersistenceRemote#find(java.lang.String)
	 */
	@Override
	public Proposta find(int idProposta) {
		return super.find(Proposta.class,idProposta);
	}
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.PropostaPersistenceRemote#delete(java.lang.String)
	 */
	@Override
	public void delete(int idProposta) {
		super.delete(Proposta.class, idProposta);
	}
	
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.PropostaPersistenceRemote#findAll()
	 */
	@XmlElement(name = "propostas")
	public List<Proposta> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(Proposta.class);
	}

}
