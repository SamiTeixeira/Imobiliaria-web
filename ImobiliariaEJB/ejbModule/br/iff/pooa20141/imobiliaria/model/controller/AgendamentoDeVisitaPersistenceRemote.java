package br.iff.pooa20141.imobiliaria.model.controller;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.imobiliaria.model.entity.AgendamentoDeVisita;
import br.iff.pooa20141.imobiliaria.model.entity.Imovel;
import br.iff.pooa20141.imobiliaria.model.entity.Usuario;

@Remote

public interface AgendamentoDeVisitaPersistenceRemote {
	
	public AgendamentoDeVisita inserir(int idAgendamentoDeVisita, Date data, String hora, Imovel imovel, Usuario usuario);

	public AgendamentoDeVisita update(int idAgendamentoDeVisita, Date data, String hora, Imovel imovel, Usuario usuario);

	public AgendamentoDeVisita find(int idAgendamentoDeVisita);

	public void delete(int idAgendamentoDeVisita);

	@XmlElement(name = "agendamentoDeVisita")
	public List<AgendamentoDeVisita> findAll();

}
