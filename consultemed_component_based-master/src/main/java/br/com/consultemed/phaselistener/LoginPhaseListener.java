/**
 * 
 */
package br.com.consultemed.phaselistener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class LoginPhaseListener implements PhaseListener {
	private static final long serialVersionUID = 1L;

	private FacesContext facesContext;

	@Override
	public void afterPhase(PhaseEvent event) {
		this.facesContext = event.getFacesContext();
		String viewId = this.facesContext.getViewRoot().getId();
		System.out.println(viewId);
	}

	@Override
	public void beforePhase(PhaseEvent event) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
