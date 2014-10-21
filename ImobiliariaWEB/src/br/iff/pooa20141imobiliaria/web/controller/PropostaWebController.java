package br.iff.pooa20141imobiliaria.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.imobiliaria.model.controller.PropostaPersistence;
import br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistence;
import br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistence;
import br.iff.pooa20141.imobiliaria.model.entity.Proposta;
import br.iff.pooa20141.imobiliaria.model.entity.Usuario;
import br.iff.pooa20141.imobiliaria.model.entity.Imovel;

@ManagedBean(name = "propostaPrime")
@SessionScoped
public class PropostaWebController {

	@EJB(lookup = "java:app/ImobiliariaWEB/UsuarioPersistence!br.iff.pooa20141.imobiliaria.model.controller.UsuarioPersistence")
	private UsuarioPersistence jusuario;
	
	@EJB(lookup = "java:app/ImobiliariaWEB/ImovelPersistence!br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistence")
	private ImovelPersistence iimovel;

	@EJB(lookup = "java:app/ImobiliariaWEB/PropostaPersistence!br.iff.pooa20141.imobiliaria.model.controller.PropostaPersistence")
	private PropostaPersistence pproposta;

	private Proposta proposta;
	private Proposta propostaSelecionado = new Proposta();

	public Proposta getProposta() {
		if (proposta == null) {
			proposta = new Proposta();
		}
		return proposta;
	}

	public List<Proposta> getAllProposta() {
		return pproposta.findAll();
	}

	public List<Usuario> getAllUsuario() {
		return jusuario.findAll();
	}
	
	public List<Imovel> getAllImovel() {
		return iimovel.findAll();
	}

	public void salva() {
		
		if (pproposta.find(proposta.getIdProposta()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("proposta Ja Cadastrado"));

		} else {

			pproposta.insert(proposta);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
		
	}

	public void delete() {

		if (pproposta.find(propostaSelecionado.getIdProposta()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("proposta não Existe"));

		} else {
			pproposta.delete(propostaSelecionado.getIdProposta());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Proposta getPropostaSelecionado() {

		return propostaSelecionado;
	}

	public void setPropostaSelecionado(Proposta propostaSelecionado) {
		this.propostaSelecionado = propostaSelecionado;

	}

	public void update() {

		
		if (pproposta.find(propostaSelecionado.getIdProposta()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("proposta não Existe"));

		} else {

			pproposta.update(propostaSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
		
	}

	public PropostaWebController() {

	}

}