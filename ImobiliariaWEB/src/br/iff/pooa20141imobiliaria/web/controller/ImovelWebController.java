package br.iff.pooa20141imobiliaria.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistence;
import br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistence;
import br.iff.pooa20141.imobiliaria.model.entity.Imovel;
import br.iff.pooa20141.imobiliaria.model.entity.TipoDeImovel;

@ManagedBean(name = "imovelPrime")
@SessionScoped
public class ImovelWebController {

	@EJB(lookup = "java:app/ImobiliariaWEB/TipoDeImovelPersistence!br.iff.pooa20141.imobiliaria.model.controller.TipoDeImovelPersistence")
	private TipoDeImovelPersistence ttipoDeImovel;

	@EJB(lookup = "java:app/ImobiliariaWEB/ImovelPersistence!br.iff.pooa20141.imobiliaria.model.controller.ImovelPersistence")
	private ImovelPersistence iimovel;

	private Imovel imovel;
	private Imovel imovelSelecionado = new Imovel();

	public Imovel getImovel() {
		if (imovel == null) {
			imovel = new Imovel();
		}
		return imovel;
	}

	public List<Imovel> getAllImovel() {
		return iimovel.findAll();
	}

	public List<TipoDeImovel> getAllTipoDeImovel() {
		return ttipoDeImovel.findAll();
	}

	public void salva() {
		
		if (iimovel.find(imovel.getIdImovel()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Imovel Ja Cadastrado"));

		} else {

			iimovel.insert(imovel);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
		
	}

	public void delete() {

		if (iimovel.find(imovelSelecionado.getIdImovel()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("imovel não Existe"));

		} else {
			iimovel.delete(imovelSelecionado.getIdImovel());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Imovel getImovelSelecionado() {

		return imovelSelecionado;
	}

	public void setImovelSelecionado(Imovel imovelSelecionado) {
		this.imovelSelecionado = imovelSelecionado;

	}

	public void update() {

		
		if (iimovel.find(imovelSelecionado.getIdImovel()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("imovel não Existe"));

		} else {

			iimovel.update(imovelSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
		
	}

	public ImovelWebController() {

	}

}