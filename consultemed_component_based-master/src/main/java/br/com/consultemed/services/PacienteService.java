package br.com.consultemed.services;

import java.util.List;

import javax.inject.Inject;

import br.com.consultemed.models.Paciente;
import br.com.consultemed.repository.repositories.PacienteRepository;

public class PacienteService {
	
	@Inject
	private PacienteRepository dao;
	
	public List<Paciente> listaPaciente(){
		return this.dao.listaPacientes();
	}
	
	public void salvarPaciente(Paciente paciente) {
		this.dao.salvarPaciente(paciente);
	}
	
	public void deletarPaciente(Long id) throws Exception {
		this.dao.deleteById(id);
	}
}
