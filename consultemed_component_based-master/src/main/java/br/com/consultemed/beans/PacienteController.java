package br.com.consultemed.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.consultemed.models.Paciente;
import br.com.consultemed.services.PacienteService;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class PacienteController {
	
	@Getter
	@Setter
	private List<Paciente> pacientes;

	@Inject
	@Getter
	@Setter
	private Paciente paciente;
	
	@Getter
	@Setter
	private Paciente pacienteEditar;
	
	@Inject
	private PacienteService service;
	
	
	public String editar() {
		this.paciente = this.pacienteEditar;
		return "/pages/pacientes/addPacientes.xhtml";
	}
	
	public String excluir() throws Exception {
		this.paciente = this.pacienteEditar;
		this.service.deletarPaciente(this.paciente.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
		return "/pages/pacientes/pacientes.xhtml?faces-redirect=true";
	}
	
	public String novoPaciente() {
		this.paciente = new Paciente();
		return "/pages/pacientes/addPacientes.xhtml?faces-redirect=true";
	}
	
	public String addPaciente() {
		this.service.salvarPaciente(this.paciente);
		return "/pages/pacientes/pacientes.xhtml?faces-redirect=true";
	}
	
	public List<Paciente> listaPacientes(){
		this.pacientes = this.service.listaPaciente();
		return pacientes;
	}
	
}
