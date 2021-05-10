package com.driveventures.controller;

import java.io.IOException;

import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.util.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import com.driveventures.model.Conductor;
import com.driveventures.model.Usuario;
import com.driveventures.service.ConductorService;
import com.driveventures.service.UsuarioService;
import com.driveventures.service.Impl.ConductorServiceImpl;
import com.driveventures.service.Impl.UsuarioServiceImpl;
import com.driveventures.utils.Actions;
import com.driveventures.utils.AttributeNames;
import com.driveventures.utils.CookieManager;
import com.driveventures.utils.Errores;
import com.driveventures.utils.Errors;
import com.driveventures.utils.ParameterNames;
import com.driveventures.utils.SessionAttributeNames;
import com.driveventures.utils.SessionManager;
import com.driveventures.utils.ValidationUtils;
import com.driveventures.utils.ViewPaths;
import com.driveventures.utils.WebConstants;

import DBCUtils.DataException;
import DBCUtils.MailException;


@WebServlet("/Usuario")
public class UsuarioServlet extends HttpServlet {
	
       
	private static Logger logger = LogManager.getLogger(UsuarioServlet.class);
	
	private UsuarioService usuarioService = null;
	private ConductorService conductorService = null;
	
    public UsuarioServlet() {
        super();
        usuarioService = new UsuarioServiceImpl();
        conductorService = new ConductorServiceImpl();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		String action = request.getParameter(ParameterNames.ACTION);
		Errors errors = new Errors();

		
		if(Actions.LOGIN.equalsIgnoreCase(action)) {
			
			

			String email = request.getParameter(ParameterNames.EMAIL.trim());
			String password = request.getParameter(ParameterNames.PASSWORD.trim());
			
			password = ValidationUtils.passwordValidator(password,errors,ParameterNames.PASSWORD, true);
			email = ValidationUtils.emailValidator(email,errors,ParameterNames.EMAIL, true);
			
			boolean hasErrors = false;
			
			
			if (StringUtils.isNullOrEmpty(email)) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_USER, Errores.REQUIRED_FIELD);
			}
			if (StringUtils.isNullOrEmpty(password)) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_PASSWORD, Errores.REQUIRED_FIELD);
			}

			if (hasErrors) {
				// Si hay errores.. se los muestro y no continuo
				request.getRequestDispatcher(ViewPaths.LOGIN).forward(request, response);
			} else {
			
			try {
				
				Usuario u = null;
				Conductor c = null;

				u = usuarioService.login(email.trim(), password.trim());
				if (u==null) {
					request.setAttribute(AttributeNames.ERROR, Errores.USER_NOT_FOUND);
					request.getRequestDispatcher(ViewPaths.LOGIN).forward(request, response);
					return;
					
				}
				if(email == null || "".equals(email) || password == null || "".equals(password)){
					throw new ServletException("Mandatory Parameter missing");
				}
				HttpSession session = request.getSession();
		   		session.setAttribute("usr", u);
		   		session.setAttribute("conductor", c);
				request.setAttribute("results", u);
				request.getRequestDispatcher(ViewPaths.HOME).forward(request, response);
				return;
				
				
			} catch (DataException e) {
				logger.warn(e.getMessage(),e);
				request.getRequestDispatcher(ViewPaths.LOGIN).forward(request, response);
				return;
			} 
		
		
		}
		}
		
		else if( Actions.LOGOUT.equalsIgnoreCase(action)) {
			
			if (SessionAttributeNames.USER != null) {
			SessionManager.set(request, SessionAttributeNames.USER, null);
			request.getRequestDispatcher(ViewPaths.HOME).forward(request, response);
			} 
			
			
		} else if (Actions.REGISTRO.equalsIgnoreCase(action)){
			
			String email = request.getParameter(ParameterNames.EMAIL);
			
			String nombre = request.getParameter(ParameterNames.NOMBRE);
			
			String apellidos = request.getParameter(ParameterNames.APELLIDOS);
			
			String password = request.getParameter(ParameterNames.PASSWORD);
			
			boolean hasErrors = false;
			
			if (StringUtils.isNullOrEmpty(email)) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_USER, Errores.REQUIRED_FIELD);
			}
			if (email == null) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_USER, Errores.REQUIRED_FIELD);
			}
			
			if (StringUtils.isNullOrEmpty(nombre)) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_USER, Errores.REQUIRED_FIELD);
			}
			if (nombre == null) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_USER, Errores.REQUIRED_FIELD);
			}
			
			if (StringUtils.isNullOrEmpty(apellidos)) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_USER, Errores.REQUIRED_FIELD);
			}
			if (apellidos == null) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_USER, Errores.REQUIRED_FIELD);
			}
			
			if (StringUtils.isNullOrEmpty(password)) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_USER, Errores.REQUIRED_FIELD);
			}
			if (password == null) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_USER, Errores.REQUIRED_FIELD);
			}
			if (hasErrors) {
				// Si hay errores.. se los muestro y no continuo
				request.getRequestDispatcher(ViewPaths.REGISTRO).forward(request, response);
			} else {
			
			
			logger.info("Registrando a " + nombre + "....");
			response.getWriter().append("Served at: ").append(request.getContextPath());
	       Writer w = response.getWriter();
	       
	       
	       try {
	    		Usuario u = new Usuario();
				
				u.setEmail(ValidationUtils.emailValidator(email,errors,ParameterNames.EMAIL, true));
				u.setNombre(ValidationUtils.namesOnlyLettersValidator(nombre,errors,ParameterNames.NOMBRE, true));
				u.setApellidos(ValidationUtils.namesOnlyLettersValidator(apellidos,errors,ParameterNames.APELLIDOS, true));
				u.setPassword(ValidationUtils.passwordValidator(password,errors,ParameterNames.PASSWORD, true));
	   		u = usuarioService.create(u);
	   		
	   		if (u==null) {
				request.setAttribute(AttributeNames.ERROR, Errores.USER_NOT_FOUND);
				request.getRequestDispatcher(ViewPaths.REGISTRO).forward(request, response);
			}
	   		HttpSession session = request.getSession();
	   		session.setAttribute("usr", u);

	   		request.setAttribute("Perfil", u);
	   		w.append("Usuario:");
	   		w.append(u.toString());
	   		request.getRequestDispatcher(ViewPaths.PERFIL).forward(request, response);;
	   		
	   	} catch (DataException de) {
	   		de.printStackTrace();
	   		w.append(de.getMessage());
	   		request.setAttribute(AttributeNames.ERROR, Errores.GENERIC_ERROR);
			request.getRequestDispatcher(ViewPaths.REGISTRO).forward(request, response);
	   		} catch(MailException e) {
	   		e.printStackTrace();
	   		w.append(e.getMessage());
	   		request.setAttribute(AttributeNames.ERROR, Errores.GENERIC_ERROR);
			request.getRequestDispatcher(ViewPaths.REGISTRO).forward(request, response);
	   	} catch (EmailException e) {
	   		e.printStackTrace();
	   		w.append(e.getMessage());
	   		request.setAttribute(AttributeNames.ERROR, Errores.GENERIC_ERROR);
			request.getRequestDispatcher(ViewPaths.REGISTRO).forward(request, response);
	   	}
			}
		} else if( Actions.EDITPROFILE.equalsIgnoreCase(action)) {
			
			Usuario u = (Usuario) SessionManager.get(request, SessionAttributeNames.USER);
		     
			String nombre = request.getParameter("Nombre");
			request.setAttribute(nombre, nombre);
			
			String apellidos = request.getParameter("Apellidos");
			request.setAttribute(apellidos, apellidos);
			
			String email = request.getParameter("Email");
			request.setAttribute(apellidos, apellidos);
			
			System.out.println("Editando a " + nombre + "....");
			response.getWriter().append("Served at: ").append(request.getContextPath());
	       Writer w = response.getWriter();
	       
	       boolean hasErrors = false;
	       
	       if (StringUtils.isNullOrEmpty(nombre)) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_USER, Errores.REQUIRED_FIELD);
			}
			
			if (StringUtils.isNullOrEmpty(apellidos)) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_USER, Errores.REQUIRED_FIELD);
			}
			
			if (StringUtils.isNullOrEmpty(email)) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_USER, Errores.REQUIRED_FIELD);
			}

			if (hasErrors) {
				// Si hay errores.. se los muestro y no continuo
				request.getRequestDispatcher(ViewPaths.PERFIL).forward(request, response);
			} else {
			
			try {
		   		//capa de negocio
		    	   u.setId(u.getId());
		    	   u.setEmail(email);
		    	   u.setNombre(nombre);
		    	   u.setApellidos(apellidos);
		   		usuarioService.update(u);
		   		
		   		HttpSession session = request.getSession();
		   		session.setAttribute("usr", u);

		   		request.setAttribute("Perfil", u);
		   		w.append("Usuario:");
		   		w.append(u.toString());
		   		request.getRequestDispatcher(ViewPaths.PERFIL).forward(request, response);;
		   		
		   	} catch (DataException de) {
		   		de.printStackTrace();
		   		w.append(de.getMessage());
		   		}	
			}
		} else if( Actions.DELETE_ACCOUNT.equalsIgnoreCase(action)) {
			Usuario u = (Usuario) SessionManager.get(request, SessionAttributeNames.USER);
			  Writer w = response.getWriter();
			  
			try {
				usuarioService.delete(u.getId());
				if (SessionAttributeNames.USER != null) {
					SessionManager.set(request, SessionAttributeNames.USER, null);
					
				request.getRequestDispatcher(ViewPaths.HOME).forward(request, response);;
			}
			}
			catch (DataException de) {
		   		
		   		w.append(de.getMessage());
		   		} 
		} else if(Actions.REMEMBERME.equalsIgnoreCase(action)) {
			
			String email = request.getParameter(ParameterNames.EMAIL);
			String checked = request.getParameter(ParameterNames.CHECKED);

			Boolean check = Boolean.valueOf(checked);

			Cookie cookie = CookieManager.getCookie(request, WebConstants.REMEMBERME);

			if(check){
				if(!StringUtils.isEmptyOrWhitespaceOnly(email)) {
					CookieManager.addCookie(response, WebConstants.REMEMBERME, email, "/", 365*24*60*60);
				}
			} else {
				if (cookie != null) {
					CookieManager.removeCookie(response, WebConstants.REMEMBERME, "/");
				}
			}
			
		}
	}
		       
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
