/**
 * 
 */
package br.com.consultemed.utils;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class Messages {

	/**
	 * Nome do arquivo de properties.
	 */
	private static final String RESOURCE_FILE_BASE = "pt_BR";

	private static ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_FILE_BASE);
	
	/**
	 * Recupera uma mensagem do arquivo de properties.
	 * 
	 * @param key
	 *            A chave da propriedade.
	 * @return O valor da propriedade.
	 */
	public static String getMessage(String key) {
		return bundle.getString(key);
	}
	
	/**
	 * Recupera uma mensagem do arquivo de properties.
	 * @param baseName O nome do resource file.
	 * @param key A chave da propriedade.
	 * @return O valor da propriedade.
	 */
	public static String getMessage(String baseName, String key) {
		bundle = ResourceBundle.getBundle(baseName);
		return bundle.getString(key);
	}

	/**
	 * Metodo para exibir uma mensagem de erro na tela.
	 * 
	 * @param msg
	 */
	public static void errorMsg(String msg){

		msg = bundle.getString(msg);
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "erro", msg);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);

	}
	
	/**
	 * Metodo para exibir uma mensagem de erro na tela ao lado do componente.
	 * 
	 * @param msg
	 */
	public static void errorMsg(String msg, String id){

		msg = bundle.getString(msg);
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(id, fm);

	}
	
	/**
	 * Metodo para exibir uma mensagem de sucesso na tela.
	 * 
	 * @param msg
	 */
	public static void sucessoMsg(String msg){

		msg = bundle.getString(msg);
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_FATAL, "notice", msg);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);

	}
	
	/**
	 * Metodo para exibir uma mensagem de sucesso na tela ao lado do componente.
	 * 
	 * @param msg
	 */
	public static void sucessoMsg(String msg, String id){

		msg = bundle.getString(msg);
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(id, fm);

	}
	
	/**
	 * Metodo para exibir uma mensagem informativa na tela.
	 * 
	 * @param msg
	 */
	public void infoMsg(String msg){

		msg = bundle.getString(msg);
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "info", msg);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);

	}
	
	/**
	 * Metodo para exibir uma mensagem informativa na tela ao lado do componente.
	 * 
	 * @param msg
	 */
	public static void infoMsg(String msg, String id){

		msg = bundle.getString(msg);
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(id, fm);

	}
	
	/**
	 * Metodo para exibir uma mensagem de alerta na tela.
	 * 
	 * @param msg
	 */
	public static void warningMsg(String msg){

		msg = bundle.getString(msg);
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, msg,"");
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);

	}
	
	/**
	 * Metodo para exibir uma mensagem de alerta na tela.
	 * 
	 * @param msg
	 */
	public static void warningMsg(String msg, String id){

		msg = bundle.getString(msg);
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(id, fm);

	}

	
	/**
	 * Metodo para exibir uma mensagem de informacao do resources passando parametros.
	 * 
	 * @param msg
	 * @param values
	 */
	public static void infoMsgReplace(String msg, String... values) {
		String line = bundle.getString(msg);
		Pattern pattern = Pattern.compile("\\{[0-9]{1,4}\\}");
		Matcher matcher = pattern.matcher(line);
		String resultLine = "";
		
		for (String param : values) {
			resultLine = matcher.replaceFirst(param);
			matcher = pattern.matcher(resultLine);
		}
		
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "info", resultLine);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);
		
	}
	
	/**
	 * Metodo para exibir uma mensagem de warning do resources passando parametros.
	 * 
	 * @param msg
	 * @param values
	 */
	public static void warningMsgReplace(String msg, String... values) {
		String line = bundle.getString(msg);
		Pattern pattern = Pattern.compile("\\{[0-9]{1,4}\\}");
		Matcher matcher = pattern.matcher(line);
		String resultLine = "";
		
		for (String param : values) {
			resultLine = matcher.replaceFirst(param);
			matcher = pattern.matcher(resultLine);
		}
		
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, "warning", resultLine);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);
		
	}
	
	/**
	 * Metodo para exibir uma mensagem de erro do resources passando parametros.
	 * 
	 * @param msg
	 * @param values
	 */
	public static void warningMsgReplace(String msg, String id,String... values) {
		String line = bundle.getString(msg);
		Pattern pattern = Pattern.compile("\\{[0-9]{1,4}\\}");
		Matcher matcher = pattern.matcher(line);
		String resultLine = "";
		
		for (String param : values) {
			resultLine = matcher.replaceFirst(param);
			matcher = pattern.matcher(resultLine);
		}
		
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, resultLine, resultLine);
		
		FacesContext fc = FacesContext.getCurrentInstance();
		System.err.println(fc.getClientIdsWithMessages().toString());
		fc.addMessage(id, fm);
		
	}
	
	/**
	 * Metodo para exibir uma mensagem de erro do resources passando parametros.
	 * 
	 * @param msg
	 * @param values
	 */
	public static void errorMsgReplace(String msg, String... values) {
		String line = bundle.getString(msg);
		Pattern pattern = Pattern.compile("\\{[0-9]{1,4}\\}");
		Matcher matcher = pattern.matcher(line);
		String resultLine = "";
		
		for (String param : values) {
			resultLine = matcher.replaceFirst(param);
			matcher = pattern.matcher(resultLine);
		}
		
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, resultLine, resultLine);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);
		
	}
	
	/**
	 * Metodo para exibir uma mensagem de erro do resources passando parametros.
	 * 
	 * @param msg
	 * @param values
	 */
	public static void errorMsgReplace(String msg, String id,String... values) {
		String line = bundle.getString(msg);
		Pattern pattern = Pattern.compile("\\{[0-9]{1,4}\\}");
		Matcher matcher = pattern.matcher(line);
		String resultLine = "";
		
		for (String param : values) {
			resultLine = matcher.replaceFirst(param);
			matcher = pattern.matcher(resultLine);
		}
		
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, resultLine, resultLine);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(id, fm);
		
	}
	
	/**
	 * Metodo para exibir uma mensagem de sucesso do resources passando parametros.
	 * 
	 * @param msg
	 * @param values
	 */
	public static void sucessoMsgReplace(String msg, String... values) {
		String line = bundle.getString(msg);
		Pattern pattern = Pattern.compile("\\{[0-9]{1,4}\\}");
		Matcher matcher = pattern.matcher(line);
		String resultLine = "";
		
		for (String param : values) {
			resultLine = matcher.replaceFirst(param);
			matcher = pattern.matcher(resultLine);
		}
		
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_FATAL, "notice", resultLine);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);
		
	}
	
	/**
	 * Metodo para exibir uma mensagem de erro ao lado do componete. usando o atributo "validate"
	 * 
	 * @param msg
	 */
	public static void errorValidateMsg(String msg) throws ValidatorException{

		msg = bundle.getString(msg);
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "erro", msg);
		throw new ValidatorException(fm);
	}
	
	/**
	 * Metodo para exibir uma mensagem de sucesso ao lado do componete. usando o atributo "validate"
	 * 
	 * @param msg
	 */
	public static void sucessoValidateMsg(String msg) throws ValidatorException{

		msg = bundle.getString(msg);
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_FATAL, "notice", msg);
		throw new ValidatorException(fm);

	}
	
	/**
	 * Metodo para exibir uma mensagem de info ao lado do componete. usando o atributo "validate"
	 * 
	 * @param msg
	 */
	public static void infoValidateMsg(String msg) throws ValidatorException{

		msg = bundle.getString(msg);
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "info", msg);
		throw new ValidatorException(fm);

	}
	
	/**
	 * Metodo para exibir uma mensagem de warning ao lado do componete. usando o atributo "validate"
	 * 
	 * @param msg
	 */
	public static void warningValidateMsg(String msg) throws ValidatorException{

		msg = bundle.getString(msg);
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, "warning", msg);
		throw new ValidatorException(fm);

	}
	
	/**
	 * Metodo para exibir uma mensagem de info ao lado do componete passando parametros. usando o atributo "validate"
	 * Metodo para exibir uma mensagem de informacao do resources passando parametros.
	 * 
	 * @param msg
	 * @param values
	 */
	public static void infoValidateMsgReplace(String msg, String... values) throws ValidatorException {
		String line = bundle.getString(msg);
		Pattern pattern = Pattern.compile("\\{[0-9]{1,4}\\}");
		Matcher matcher = pattern.matcher(line);
		String resultLine = "";
		
		for (String param : values) {
			resultLine = matcher.replaceFirst(param);
			matcher = pattern.matcher(resultLine);
		}
		
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "info", resultLine);
		throw new ValidatorException(fm);
		
	}
	
	/**
	 *  Metodo para exibir uma mensagem de warning ao lado do componete passando parametros. usando o atributo "validate"
	 * 
	 * @param msg
	 * @param values
	 */
	public static void warningValidateMsgReplace(String msg, String... values) throws ValidatorException{
		String line = bundle.getString(msg);
		Pattern pattern = Pattern.compile("\\{[0-9]{1,4}\\}");
		Matcher matcher = pattern.matcher(line);
		String resultLine = "";
		
		for (String param : values) {
			resultLine = matcher.replaceFirst(param);
			matcher = pattern.matcher(resultLine);
		}
		
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, "warning", resultLine);
		throw new ValidatorException(fm);
	}
	
	
	/**
	 *  Metodo para exibir uma mensagem de error ao lado do componete passando parametros. usando o atributo "validate"
	 * 
	 * @param msg
	 * @param values
	 */
	public static void errorValidateMsgReplace(String msg, String... values) throws ValidatorException {
		String line = bundle.getString(msg);
		Pattern pattern = Pattern.compile("\\{[0-9]{1,4}\\}");
		Matcher matcher = pattern.matcher(line);
		String resultLine = "";
		
		for (String param : values) {
			resultLine = matcher.replaceFirst(param);
			matcher = pattern.matcher(resultLine);
		}
		
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, resultLine, resultLine);
		throw new ValidatorException(fm);
		
	}
	
	/**
	 *  Metodo para exibir uma mensagem de sucesso ao lado do componete passando parametros. usando o atributo "validate"
	 * 
	 * @param msg
	 * @param values
	 */
	public static void sucessoValidateMsgReplace(String msg, String... values) throws ValidatorException {
		String line = bundle.getString(msg);
		Pattern pattern = Pattern.compile("\\{[0-9]{1,4}\\}");
		Matcher matcher = pattern.matcher(line);
		String resultLine = "";
		
		for (String param : values) {
			resultLine = matcher.replaceFirst(param);
			matcher = pattern.matcher(resultLine);
		}
		
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_FATAL, "notice", resultLine);
		throw new ValidatorException(fm);
		
	}


}
