//package br.com.consultemed.filters;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.com.consultemed.models.Usuario;
//import br.com.consultemed.utils.Constantes;
//
///**
// * Servlet Filter implementation class FilterAdmin
// */
//@WebFilter(filterName = "/filterAdmin", urlPatterns = { "/admin/usuarios/*" })
//public class FilterAdmin implements Filter {
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//
//		HttpServletRequest httpRequest = (HttpServletRequest) request;
//		HttpServletResponse httpResponse = (HttpServletResponse) response;
//		Usuario usuarioLogado = (Usuario) (httpRequest.getSession().getAttribute("user"));
//
//		String acao = request.getParameter(Constantes.ACTION);
//
//		if (!usuarioLogado.isAdministrador()) {
//			if (!acao.equalsIgnoreCase(Constantes.LISTAR)) {
//				RequestDispatcher rd = request.getRequestDispatcher("/acessoNegado");
//				rd.forward(httpRequest, httpResponse);
//			}else {
//				chain.doFilter(httpRequest, httpResponse);
//			}
//		} else {
//			chain.doFilter(httpRequest, httpResponse);
//		}
//	}
//
//	public void destroy() {
//
//	}
//
//	public void init(FilterConfig fConfig) throws ServletException {
//
//	}
//
//}
