/**
 * 
 */
package br.com.consultemed.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.consultemed.models.Medico;
import br.com.consultemed.services.MedicoService;
import lombok.Getter;
import lombok.Setter;

/**
 * @author carlosbarbosagomesfilho
 *
 */
@Named
@RequestScoped
public class MedicoController{
	
	@Getter
	@Setter
	private List<Medico> medicos;

	@Inject
	@Getter
	@Setter
	private Medico medico;
	
	@Getter
	@Setter
	private Medico medicoEditar;
	
	@Inject
	private MedicoService service;
	
	
	public String editar() {
		this.medico = this.medicoEditar;
		return "/pages/medicos/addMedicos.xhtml";
	}
	
	public String excluir() throws Exception {
		this.medico = this.medicoEditar;
		this.service.deletarMedico(this.medico.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
		return "/pages/medicos/medicos.xhtml?faces-redirect=true";
	}
	
	public String novoMedico() {
		this.medico = new Medico();
		return "/pages/medicos/addMedicos.xhtml?faces-redirect=true";
	}
	
	public String addMedico() {
			this.service.salvarMedico(this.medico);
			return "/pages/medicos/medicos.xhtml?faces-redirect=true";
	}
	
	public List<Medico> listaMedicos(){
		this.medicos = this.service.listaMedico();
		return medicos;
	}
}
