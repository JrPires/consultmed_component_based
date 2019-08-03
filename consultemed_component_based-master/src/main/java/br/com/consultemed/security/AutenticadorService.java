/**
 * 
 */
package br.com.consultemed.security;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.consultemed.models.Usuario;
import br.com.consultemed.repository.security.AutenticadorRepository;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class AutenticadorService implements Autenticador, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AutenticadorRepository autenticadorRepository;
	
	public Usuario autenticador(String login, String senha) {
		return this.autenticadorRepository.autenticador(login, senha);
	}

}
