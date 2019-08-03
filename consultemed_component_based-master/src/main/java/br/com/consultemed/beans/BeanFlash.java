/**
 * 
 */
package br.com.consultemed.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * @author carlosbarbosagomesfilho
 *
 */

@ViewScoped
@ManagedBean
public class BeanFlash {

	public String redirection() {
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Realizado com sucesso"));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "/pages/medicos/medicos.xhtml?faces-redirect=true";
	}
}
