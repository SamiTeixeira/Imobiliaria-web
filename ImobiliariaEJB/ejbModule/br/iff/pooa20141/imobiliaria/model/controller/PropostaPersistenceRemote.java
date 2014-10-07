package br.iff.pooa20141.imobiliaria.model.controller;


import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.imobiliaria.model.entity.Proposta;
import br.iff.pooa20141.imobiliaria.model.entity.Imovel;
import br.iff.pooa20141.imobiliaria.model.entity.Usuario;

@Remote

public interface PropostaPersistenceRemote {

	public Proposta inserir(int idProposta, String satatus, double valor, Imovel imovel, Usuario usuario );

	public Proposta update(int idProposta, String satatus, double valor, Imovel imovel, Usuario usuario);

	public Proposta find(int idProposta);

	public void delete(int idProposta);

	@XmlElement(name = "proposta")
	public List<Proposta> findAll();
}
