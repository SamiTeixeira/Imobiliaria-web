package br.iff.pooa20141.imobiliaria.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.imobiliaria.model.entity.TipoDeImovel;


@Stateless
@LocalBean
public class TipoDeImovelPersistence extends AbstractPersistence implements
		TipoDeImovelPersistenceRemote {
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistenceRemote#inserir(java.lang.String, java.lang.String)
	 */
	@Override
	public TipoDeImovel inserir(int idTipoDeImovel, String tipoDeContrato, String descricao, double valor ) {
		TipoDeImovel tipoDeImovel = new TipoDeImovel();
		tipoDeImovel.setIdTipoDeImovel(idTipoDeImovel);
		tipoDeImovel.setTipoDeContrato(tipoDeContrato);
		tipoDeImovel.setDescricao(descricao);
		tipoDeImovel.setValor(valor);
		super.insert(tipoDeImovel);
		return tipoDeImovel;
	}
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistenceRemote#update(java.lang.String, java.lang.String)
	 */
	@Override
	public TipoDeImovel update(int idTipoDeImovel, String tipoDeContrato, String descricao, double valor ) {
		TipoDeImovel tipoDeImovel = super.find(TipoDeImovel.class, idTipoDeImovel);
		tipoDeImovel.setIdTipoDeImovel(idTipoDeImovel);
		tipoDeImovel.setTipoDeContrato(tipoDeContrato);
		tipoDeImovel.setDescricao(descricao);
		tipoDeImovel.setValor(valor);
		super.update(tipoDeImovel);
		return tipoDeImovel;
	}
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistenceRemote#find(java.lang.String)
	 */
	@Override
	public TipoDeImovel find(int idTipoDeImovel) {
		return super.find(TipoDeImovel.class,idTipoDeImovel);
	}
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistenceRemote#delete(java.lang.String)
	 */
	@Override
	public void delete(int idTipoDeImovel) {
		super.delete(TipoDeImovel.class, idTipoDeImovel);
	}

	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistenceRemote#findAll()
	 */
	@XmlElement(name = "tipoDeImoveis")
	public List<TipoDeImovel> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(TipoDeImovel.class);
	}
	

}
