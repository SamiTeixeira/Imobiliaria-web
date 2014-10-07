package br.iff.pooa20141.imobiliaria.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.imobiliaria.model.entity.TipoDeImovel;


@Remote
public interface TipoDeImovelPersistenceRemote {
	
	public TipoDeImovel inserir(int idTipoDeImovel, String tipoDeContrato, String descricao, double valor );

	public TipoDeImovel update(int idTipoDeImovel, String tipoDeContrato, String descricao, double valor);

	public TipoDeImovel find(int idTipoDeImovel);

	public void delete(int idTipoDeImovel);

	@XmlElement(name = "tipoDeImovel")
	public List<TipoDeImovel> findAll();
	

}
