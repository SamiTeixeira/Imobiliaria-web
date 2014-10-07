package br.iff.pooa20141imobiliaria.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.imobiliaria.model.controller.ProprietarioPersistence;
import br.iff.pooa20141.imobiliaria.model.entity.Proprietario;

@ManagedBean(name = "proprietarioPrime")
@SessionScoped
public class ProprietarioWebController {

	@EJB(lookup = "java:app/ImobiliariaWEB/ProprietarioPersistence!br.iff.pooa20141.imobiliaria.model.controller.ProprietarioPersistence")
	private ProprietarioPersistence jproprietario;

	private Proprietario proprietario;
	private Proprietario proprietarioSelecionado = new Proprietario();

	public Proprietario getProprietario() {
		if (proprietario == null) {
			proprietario = new Proprietario();
		}
		return proprietario;
	}

	public List<Proprietario> getAllProprietario() {
		return jproprietario.findAll();
	}

	public void salva() {

		if (jproprietario.find(proprietario.getIdproprietario()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("proprietario Ja Cadastrado"));

		} else {
			jproprietario.insert(proprietario);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
	}

	public void delete() {

		if (jproprietario.find(proprietarioSelecionado.getIdproprietario()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("proprietario não Existe"));

		} else {
			jproprietario.delete(proprietarioSelecionado.getIdproprietario());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Proprietario getProprietarioSelecionado() {

		return proprietarioSelecionado;
	}

	public void setProprietarioSelecionado(Proprietario proprietarioSelecionado) {
		this.proprietarioSelecionado = proprietarioSelecionado;

	}

	public void update() {

		if (jproprietario.find(proprietarioSelecionado.getIdproprietario()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("proprietario não Existe"));

		} else {

			jproprietario.update(proprietarioSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
	}

	public ProprietarioWebController() {

	}

}
