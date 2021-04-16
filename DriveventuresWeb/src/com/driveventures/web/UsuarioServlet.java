package com.driveventures.web;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.Controller.utils.Actions;
import com.driveventures.Controller.utils.AttributeNames;
import com.driveventures.Controller.utils.ErrorCodes;
import com.driveventures.Controller.utils.Errors;
import com.driveventures.Controller.utils.ParameterNames;
import com.driveventures.Controller.utils.SessionAttributeNames;
import com.driveventures.Controller.utils.SessionManager;
import com.driveventures.Controller.utils.ViewPaths;
import com.driveventures.model.Usuario;
import com.driveventures.service.ConductorService;
import com.driveventures.service.UsuarioService;
import com.driveventures.service.Impl.ConductorServiceImpl;
import com.driveventures.service.Impl.UsuarioServiceImpl;

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

		String target = null;
		boolean redirect = false;
		
		
		String url = "";
		
		if(Actions.LOGIN.equalsIgnoreCase(action)) {
			
			

			String email = request.getParameter(ParameterNames.EMAIL);
			request.setAttribute(email, email);
			String password = request.getParameter(ParameterNames.PASSWORD);
			request.setAttribute(password, password);

			boolean hasErrors = false;

			if (StringUtils.isEmpty(email)) {
				hasErrors = true;
				request.setAttribute(AttributeNames.ERROR_USER, Errors.REQUIRED_FIELD_ERROR);
			}
			if (StringUtils.isEmpty(password)) {
				hasErrors = true;
				
				request.setAttribute(AttributeNames.ERROR_PASSWORD, Errors.REQUIRED_FIELD_ERROR);
			}

			if (hasErrors) {
				// Si hay errores.. se los muestro y si no continuo
				request.setAttribute(AttributeNames.EMAIL, email);
				target = ViewPaths.LOGIN;
			} else {
			
			
			
			try {
				
				Usuario u = null;
	
				u = usuarioService.login(email, password);
				HttpSession session = request.getSession();
		   		session.setAttribute("usr", u);
		   		session.setAttribute("sesion_idusuario", u.getId() );
				request.setAttribute("results", u);
				request.getRequestDispatcher("html/Home.jsp").forward(request, response);;
			} catch (DataException e) {
				logger.warn(e.getMessage(),e);
			}
		
		}
		}
		else if( Actions.LOGOUT.equalsIgnoreCase(action)) {
			
			SessionManager.set(request, SessionAttributeNames.USER, null);
			
			target = "";
			redirect = true;
		
		} else if (Actions.REGISTRO.equalsIgnoreCase(action)){
			
			String email = request.getParameter("email");
			request.setAttribute(email, email);
			String nombre = request.getParameter("Nombre");
			request.setAttribute(nombre, nombre);
			String apellidos = request.getParameter("Apellidos");
			request.setAttribute(apellidos, apellidos);
			String password = request.getParameter("Password");
			request.setAttribute(password, password);
			
			System.out.println("Registrando a " + nombre + "....");
			response.getWriter().append("Served at: ").append(request.getContextPath());
	       Writer w = response.getWriter();
	       
	       
	       try {
	   		//capa de negocio
	    	   Usuario u = new Usuario();
	    	   u.setEmail(email);
	    	   u.setNombre(nombre);
	    	   u.setApellidos(apellidos);
	    	   u.setPassword(password);
	   		u = usuarioService.create(u);
	   		HttpSession session = request.getSession();
	   		session.setAttribute("usr", u);

	   		request.setAttribute("Perfil", u);
	   		w.append("Usuario:");
	   		w.append(u.toString());
	   		request.getRequestDispatcher("html/Perfil.jsp").forward(request, response);;
	   		
	   	} catch (DataException de) {
	   		de.printStackTrace();
	   		w.append(de.getMessage());
	   		} catch(MailException e) {
	   		e.printStackTrace();
	   		w.append(e.getMessage());
	   	} catch (EmailException e) {
	   		e.printStackTrace();
	   		w.append(e.getMessage());
	   	}
			
		} 
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
