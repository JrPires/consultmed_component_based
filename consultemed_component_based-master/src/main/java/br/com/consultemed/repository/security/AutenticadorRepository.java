package br.com.consultemed.repository.security;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.consultemed.models.Usuario;
import br.com.consultemed.utils.JPAUtils;

public class AutenticadorRepository {

	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	
	
	
	public Usuario autenticador(String login, String senha) {
		
		Usuario usuario = null;
		this.factory = emf.createEntityManager();
		
		try {
			Query query = this.factory.createNamedQuery("Usuario.loginUsuario");
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			usuario = (Usuario) query.getSingleResult();
			
			return usuario;
					
		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
			
		}finally {
			this.factory.close();
		}
		
		return usuario;
	}
}
