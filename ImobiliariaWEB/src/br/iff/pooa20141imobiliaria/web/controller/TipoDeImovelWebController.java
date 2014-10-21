package br.iff.pooa20141imobiliaria.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistence;
import br.iff.pooa20141.imobiliaria.model.entity.TipoDeImovel;


@ManagedBean(name = "tipoDeImovelPrime")
@SessionScoped
public class TipoDeImovelWebController {

	@EJB(lookup = "java:app/ImobiliariaWEB/TipoDeImovelPersistence!br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistence")
	private TipoDeImovelPersistence ttipoDeImovel;

	private TipoDeImovel tipoDeImovel;
	private TipoDeImovel tipoDeImovelSelecionado = new TipoDeImovel();

	public TipoDeImovel getTipoDeImovel() {
		if (tipoDeImovel == null) {
			tipoDeImovel = new TipoDeImovel();
		}
		return tipoDeImovel;
	}

	public List<TipoDeImovel> getAllTipoDeImovel() {
		return ttipoDeImovel.findAll();
	}

	public void salva() {

		if (ttipoDeImovel.find(tipoDeImovel.getIdTipoDeImovel()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("proprietario Ja Cadastrado"));

		} else {
			ttipoDeImovel.insert(tipoDeImovel);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
	}

	public void delete() {

		if (ttipoDeImovel.find(tipoDeImovelSelecionado.getIdTipoDeImovel()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Tipo de Imovel não Existe"));

		} else {
			ttipoDeImovel.delete(tipoDeImovelSelecionado.getIdTipoDeImovel());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public TipoDeImovel getTipoDeImovelSelecionado() {

		return tipoDeImovelSelecionado;
	}

	public void setTipoDeImovelSelecionado(TipoDeImovel tipoDeImovelSelecionado) {
		this.tipoDeImovelSelecionado = tipoDeImovelSelecionado;

	}

	public void update() {

		if (ttipoDeImovel.find(tipoDeImovelSelecionado.getIdTipoDeImovel()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Tipo de Imovel não Existe"));

		} else {

			ttipoDeImovel.update(tipoDeImovelSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
	}

	public TipoDeImovelWebController() {

	}

}