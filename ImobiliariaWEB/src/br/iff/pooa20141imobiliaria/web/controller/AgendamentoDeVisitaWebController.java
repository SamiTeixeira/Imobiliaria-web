package br.iff.pooa20141imobiliaria.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistence;
import br.iff.pooa20141.imobiliaria.model.entity.Imovel;
import br.iff.pooa20141.imobiliaria.model.entity.AgendamentoDeVisita;
import br.iff.pooa20141.imobiliaria.model.controller.AgendamentoDeVisitaPersistence;
import br.iff.pooa20141.imobiliaria.model.entity.Usuario;
import br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistence;


@ManagedBean(name = "agendamentoDeVisitaPrime")
@SessionScoped
public class AgendamentoDeVisitaWebController {

	@EJB(lookup = "java:app/ImobiliariaWEB/AgendamentoDeVisitaPersistence!br.iff.pooa20141.imobiliaria.model.controller.AgendamentoDeVisitaPersistence")
	private AgendamentoDeVisitaPersistence aagendamentoDeVisita;

	@EJB(lookup = "java:app/ImobiliariaWEB/ImovelPersistence!br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistence")
	private ImovelPersistence iimovel;
	
	@EJB(lookup = "java:app/ImobiliariaWEB/UsuarioPersistence!br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistence")
	private UsuarioPersistence jusuario;
	

	private AgendamentoDeVisita agendamentoDeVisita;
	private AgendamentoDeVisita agendamentoDeVisitaSelecionado = new AgendamentoDeVisita();

	public AgendamentoDeVisita getAgendamentoDeVisita() {
		if (agendamentoDeVisita == null) {
			agendamentoDeVisita = new AgendamentoDeVisita();
		}
		return agendamentoDeVisita;
	}

	public List<AgendamentoDeVisita> getAllAgendamentoDeVisita() {
		return aagendamentoDeVisita.findAll();
	}

	public List<Imovel> getAllImovel() {
		return iimovel.findAll();
	}
	
	public List<Usuario> getAllUsuario() {
		return jusuario.findAll();
	}

	public void salva() {
		
		if (aagendamentoDeVisita.find(agendamentoDeVisita.getIdAgendamentoDeVisita()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Agendamento de Visita Ja Cadastrado"));

		} else {

			aagendamentoDeVisita.insert(agendamentoDeVisita);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
		
	}

	public void delete() {

		if (aagendamentoDeVisita.find(agendamentoDeVisitaSelecionado.getIdAgendamentoDeVisita()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Agendamento de visita não Existe"));

		} else {
			aagendamentoDeVisita.delete(agendamentoDeVisitaSelecionado.getIdAgendamentoDeVisita());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public AgendamentoDeVisita getAgendamentoDeVisitaSelecionado() {

		return agendamentoDeVisitaSelecionado;
	}

	public void setAgendamentoDeVisitaSelecionado(AgendamentoDeVisita agendamentoDeVisitaSelecionado) {
		this.agendamentoDeVisitaSelecionado = agendamentoDeVisitaSelecionado;

	}

	public void update() {

		
		if (aagendamentoDeVisita.find(agendamentoDeVisitaSelecionado.getIdAgendamentoDeVisita()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Agendamento de Visita não Existe"));

		} else {

			aagendamentoDeVisita.update(agendamentoDeVisitaSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
		
	}

	public AgendamentoDeVisitaWebController() {

	}
}
