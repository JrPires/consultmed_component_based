package br.com.consultemed.services;

import java.util.List;

import javax.inject.Inject;

import br.com.consultemed.models.Funcionario;
import br.com.consultemed.repository.repositories.FuncionarioRepository;

public class FuncionarioService {
	
	@Inject
	private FuncionarioRepository dao;
	
	public List<Funcionario> listaFuncionario(){
		return this.dao.listaFuncionarios();
	}
	
	public void salvarFuncionario(Funcionario funcionario) {
		this.dao.salvarFuncionario(funcionario);
	}
	
	public void deletarFuncionario(Long id) throws Exception {
		this.dao.deleteById(id);
	}

}
