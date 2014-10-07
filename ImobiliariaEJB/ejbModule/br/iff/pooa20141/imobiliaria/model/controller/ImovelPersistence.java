package br.iff.pooa20141.imobiliaria.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.imobiliaria.model.entity.Imovel;
import br.iff.pooa20141.imobiliaria.model.entity.Proprietario;
import br.iff.pooa20141.imobiliaria.model.entity.TipoDeImovel;


@Stateless
@LocalBean
public class ImovelPersistence extends AbstractPersistence implements
		ImovelPersistenceRemote {
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistenceRemote#inserir(java.lang.String, java.lang.String)
	 */
	@Override
	public Imovel inserir(int idImovel, int area, int areaDeServico, int areaExterna, int banheiro, int cozinha, String endereco, int garagem, int quarto, int sala, Proprietario proprietario, TipoDeImovel tipoDeImovel) {
		Imovel imovel = new Imovel();
		imovel.setIdImovel(idImovel);
		imovel.setProprietario(proprietario);
		imovel.setTipoDeImovel(tipoDeImovel);
		imovel.setArea(area);
		imovel.setAreaDeServico(areaDeServico);
		imovel.setAreaExterna(areaExterna);
		imovel.setBanheiro(banheiro);
		imovel.setCozinha(cozinha);
		imovel.setEndereco(endereco);
		imovel.setGaragem(garagem);
		imovel.setQuarto(quarto);
		imovel.setSala(sala);
		super.insert(imovel);
		return imovel;
	}
	
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistenceRemote#update(java.lang.String, java.lang.String)
	 */
	@Override
	public Imovel update(int idImovel, int area, int areaDeServico, int areaExterna, int banheiro, int cozinha, String endereco, int garagem, int quarto, int sala, Proprietario proprietario, TipoDeImovel tipoDeImovel) {
		Imovel imovel = super.find(Imovel.class, idImovel);
		imovel.setIdImovel(idImovel);
		imovel.setProprietario(proprietario);
		imovel.setTipoDeImovel(tipoDeImovel);
		imovel.setArea(area);
		imovel.setAreaDeServico(areaDeServico);
		imovel.setAreaExterna(areaExterna);
		imovel.setBanheiro(banheiro);
		imovel.setCozinha(cozinha);
		imovel.setEndereco(endereco);
		imovel.setGaragem(garagem);
		imovel.setQuarto(quarto);
		imovel.setSala(sala);
		super.update(imovel);
		return imovel;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistenceRemote#find(java.lang.String)
	 */
	@Override
	public Imovel find(int idImovel) {
		return super.find(Imovel.class,idImovel);
	}
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistenceRemote#delete(java.lang.String)
	 */
	@Override
	public void delete(int idImovel) {
		super.delete(Imovel.class, idImovel);

	}
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistenceRemote#findAll()
	 */
	@XmlElement(name = "imoveis")
	public List<Imovel> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(Imovel.class);
	}
	
}
	

