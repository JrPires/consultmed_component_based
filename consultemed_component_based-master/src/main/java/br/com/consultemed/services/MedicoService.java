/**
 * 
 */
package br.com.consultemed.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.consultemed.models.Medico;
import br.com.consultemed.repository.repositories.MedicoRepository;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class MedicoService {

	@Inject
	private MedicoRepository dao;
	
	public List<Medico> listaMedico(){
		return this.dao.listaMedicos();
	}
	
	public void salvarMedico(Medico medico) {
		this.dao.salvarMedico(medico);
	}
	
	public void deletarMedico(Long id) throws Exception {
		this.dao.deleteById(id);
	}
	
	public boolean MedicoByCrm(String email) {
		if(this.dao.MedicoByCrm(email)) {
			return true;
		}else {
			return false;
		}
	}
	
}
