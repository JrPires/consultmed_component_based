package br.com.consultemed.utils;

import java.util.List;

import javax.inject.Inject;

import br.com.consultemed.models.Usuario;
import br.com.consultemed.repository.repositories.UsuarioRepository;
import br.com.consultemed.services.UsuarioService;

public class Main {

	@Inject
	private static UsuarioService service;

	public static void main(String[] args) {

		List<Usuario> usuarios = service.listaUsuario();
		System.out.println(usuarios.size());
	}

}
