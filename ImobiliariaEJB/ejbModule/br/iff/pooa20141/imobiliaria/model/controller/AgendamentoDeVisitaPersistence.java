package br.iff.pooa20141.imobiliaria.model.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.imobiliaria.model.entity.AgendamentoDeVisita;
import br.iff.pooa20141.imobiliaria.model.entity.Imovel;
import br.iff.pooa20141.imobiliaria.model.entity.Usuario;

@Stateless
@LocalBean
public class AgendamentoDeVisitaPersistence extends AbstractPersistence
		implements AgendamentoDeVisitaPersistenceRemote {

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.PropostaPersistenceRemote#inserir(java.lang.String, java.lang.String)
	 */
	@Override
	public AgendamentoDeVisita inserir(int idAgendamentoDeVisita, Date data, String hora, Imovel imovel, Usuario usuario) {
		AgendamentoDeVisita agendamentoDeVisita = new AgendamentoDeVisita();
		agendamentoDeVisita.setIdAgendamentoDeVisita(idAgendamentoDeVisita);
		agendamentoDeVisita.setData(data);
		agendamentoDeVisita.setHora(hora);
		agendamentoDeVisita.setImovel(imovel);
		agendamentoDeVisita.setUsuario(usuario);
		super.insert(agendamentoDeVisita);
		return agendamentoDeVisita;
	}
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.AgendamentoDeVisitaPersistenceRemote#update(java.lang.String, java.lang.String)
	 */
	@Override
	public AgendamentoDeVisita update(int idAgendamentoDeVisita, Date data, String hora, Imovel imovel, Usuario usuario) {
		AgendamentoDeVisita agendamentoDeVisita = super.find(AgendamentoDeVisita.class, idAgendamentoDeVisita);
		agendamentoDeVisita.setIdAgendamentoDeVisita(idAgendamentoDeVisita);
		agendamentoDeVisita.setData(data);
		agendamentoDeVisita.setHora(hora);
		agendamentoDeVisita.setImovel(imovel);
		agendamentoDeVisita.setUsuario(usuario);
		super.update(agendamentoDeVisita);
		return agendamentoDeVisita;
	}
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.AgendamentoDeVisitaPersistenceRemote#find(java.lang.String)
	 */
	@Override
	public AgendamentoDeVisita find(int idAgendamentoDeVisita) {
		return super.find(AgendamentoDeVisita.class,idAgendamentoDeVisita);
	}
	
	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.AgendamentoDeVisitaPersistenceRemote#delete(java.lang.String)
	 */
	@Override
	public void delete(int idAgendamentoDeVisita) {
		super.delete(AgendamentoDeVisita.class, idAgendamentoDeVisita);
	}
	

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.imobiliaria.model.controller.AgendamentoDeVisitaPersistenceRemote#findAll()
	 */
	@XmlElement(name = "AgendamentoDeVisitas")
	public List<AgendamentoDeVisita> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(AgendamentoDeVisita.class);
	}
	

}
