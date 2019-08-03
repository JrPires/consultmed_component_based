package br.com.consultemed.security;

import br.com.consultemed.models.Usuario;

public interface Autenticador {

	public Usuario autenticador(String login, String senha);
}
