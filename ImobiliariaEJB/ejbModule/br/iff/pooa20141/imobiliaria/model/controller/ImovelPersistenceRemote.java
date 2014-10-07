package br.iff.pooa20141.imobiliaria.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.imobiliaria.model.entity.Imovel;
import br.iff.pooa20141.imobiliaria.model.entity.Proprietario;
import br.iff.pooa20141.imobiliaria.model.entity.TipoDeImovel;
@Remote


public interface ImovelPersistenceRemote {
	
	public Imovel inserir(int idImovel, int area, int areaDeServico, int areaExterna, int banheiro, int cozinha, String endereco, int garagem, int quarto, int sala, Proprietario proprietario, TipoDeImovel tipoDeImovel);

	public Imovel update(int idImovel, int area, int areaDeServico, int areaExterna, int banheiro, int cozinha, String endereco, int garagem, int quarto, int sala, Proprietario proprietario, TipoDeImovel tipoDeImovel);

	public Imovel find(int idImovel);

	public void delete(int idImovel);

	@XmlElement(name = "imovel")
	public List<Imovel> findAll();

}
