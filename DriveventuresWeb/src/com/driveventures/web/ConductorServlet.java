package com.driveventures.web;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.Controller.utils.Actions;
import com.driveventures.Controller.utils.Errors;
import com.driveventures.Controller.utils.ParameterNames;
import com.driveventures.Controller.utils.SessionAttributeNames;
import com.driveventures.Controller.utils.SessionManager;
import com.driveventures.model.Coche;
import com.driveventures.model.Conductor;
import com.driveventures.model.Usuario;
import com.driveventures.service.CacheService;
import com.driveventures.service.CocheService;
import com.driveventures.service.ConductorService;
import com.driveventures.service.Impl.CocheServiceImpl;
import com.driveventures.service.Impl.ConductorServiceImpl;

import DBCUtils.DataException;
import DBCUtils.MailException;

/**
 * Servlet implementation class ConductorServlet
 */
@WebServlet("/Conductor")
public class ConductorServlet extends HttpServlet {

    
	private static Logger logger = LogManager.getLogger(UsuarioServlet.class);
	
	private ConductorService conductorService = null;
	private CocheService cocheService = null;
    private CacheService cacheService = null;
    
    
    public ConductorServlet() {
        super();
        conductorService = new ConductorServiceImpl();
        cocheService = new CocheServiceImpl();
        
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter(ParameterNames.ACTION);

		String target = null;
		boolean redirect = false;
		
		
if (Actions.REGISTRO_CONDUCTOR.equalsIgnoreCase(action)){
			
	Usuario u = (Usuario) SessionManager.get(request, SessionAttributeNames.USER);
	
	
		

			String dni = request.getParameter("dni");
			request.setAttribute(dni, dni);
			
			String Residencia = request.getParameter("Residencia");
			request.setAttribute(Residencia, Residencia);
			
			String Idioma = request.getParameter("Idioma");
			request.setAttribute(Idioma, Idioma);
			//Cambiar Idioma >>
			System.out.println("Registrando a " + Idioma + "....");
			response.getWriter().append("Served at: ").append(request.getContextPath());
	       Writer w = response.getWriter();
	       
	       
	       try {
	   		//capa de negocio
	    	   Conductor c = new Conductor();
	    	   HttpSession session = request.getSession();
	    	   c.setUser_id(u.getId());
	    	   c.setDni(dni);
	    	   c.setResidencia(Residencia);
	    	   c.setIdioma_principal(Idioma);
	   		c = conductorService.create(c);

	   		request.setAttribute("Perfil", c);
	   		w.append("Conductor:");
	   		w.append(c.toString());
	   		request.getRequestDispatcher("html/common/Home.jsp").forward(request, response);;
	   		
	   	} catch (DataException de) {
	   		de.printStackTrace();
	   		w.append(de.getMessage());
	   		} catch(MailException e) {
	   		e.printStackTrace();
	   		w.append(e.getMessage());
	   	} catch (EmailException e) {
	   		e.printStackTrace();
	   		w.append(e.getMessage());
	   	} catch (Exception e) {
			e.printStackTrace();
		}
			
		} else if( Actions.REGISTRO_COCHE.equalsIgnoreCase(action)) {
			
			String nombre = request.getParameter("nombre");
			Integer anho_creacion = Integer.parseInt(request.getParameter("anho_creacion"));
			Integer plazas = Integer.parseInt(request.getParameter("plazas"));
			String matricula = request.getParameter("matricula");
			Long modelo = Long.parseLong(request.getParameter("modelo"));
			Long user_id = Long.parseLong(request.getParameter("user_id"));
			
			System.out.println("Registrando el coche " + nombre + "....");
			response.getWriter().append("Served at: ").append(request.getContextPath());
	       Writer w = response.getWriter();
	       
	       try {
		   		//capa de negocio
		    	   Coche c = new Coche();
		    	   c.setNombre(nombre);
		    	   c.setFechaMatriculacion(anho_creacion);
		    	   c.setPlazas(plazas);
		    	   c.setMatricula(matricula);
		    	   c.setIdModelo(modelo);
		    	   HttpSession session = request.getSession();
		    	   c.setIdConductor((Long) session.getAttribute("sesion_idusuario"));
		   		c = cocheService.registrar(c);
		   		request.setAttribute("Perfil", c);

		   		request.getRequestDispatcher("html/common/Home.jsp").forward(request, response);;
		   		
		   	} catch (DataException de) {
		   		de.printStackTrace();
		   		w.append(de.getMessage());
		   		
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}  else if(Actions.LOGIN_CONDUCTOR.equalsIgnoreCase(action)) {
			
			

			String email = request.getParameter(ParameterNames.EMAIL);
			request.setAttribute(email, email);
			String password = request.getParameter(ParameterNames.PASSWORD);
			request.setAttribute(password, password);
			
			
			System.out.println("Logeando a " + email + "....");
			response.getWriter().append("Served at: ").append(request.getContextPath());
	       Writer w = response.getWriter();

			
			
			try { 
				
				Conductor c = null;
				c = conductorService.login(email, password);
				HttpSession session = request.getSession();
		   		session.setAttribute("usr", c);
				request.setAttribute("results", c);
				request.getRequestDispatcher("html/Home.jsp").forward(request, response);;
			} catch (DataException e) {
				logger.warn(e.getMessage(),e);
			}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());

		} else if(Actions.MIS_COCHES.equalsIgnoreCase(action)) {
			

			Usuario u = (Usuario) SessionManager.get(request, SessionAttributeNames.USER);
			
			Long id = Long.valueOf(u.getId());

			logger.info("Buscando el coche del usuario " + u.getId() + "....");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			Writer w = response.getWriter();
			Coche c = null;

       
			try {
			
				 c = cocheService.findById(id);
				 
				 if (c == null) {
					 request.getRequestDispatcher("html/RegistroCoche.jsp").forward(request, response);;
				 }
				request.setAttribute("Coche", c);
				HttpSession session = request.getSession();
				request.getRequestDispatcher("html/Coche.jsp").forward(request, response);;
			} catch (DataException e) {
				logger.warn(e.getMessage(),e);
			} catch (SQLException e) {
				logger.warn(e.getMessage(), e);
			}

			response.getWriter().append("Served at: ").append(request.getContextPath());

		} else if(Actions.DELETE_COCHE.equalsIgnoreCase(action)) {

			Usuario u = (Usuario) SessionManager.get(request, SessionAttributeNames.USER);
			
			Long id = Long.valueOf(u.getId());
			
			  Writer w = response.getWriter();
			  
			try {
			
				cocheService.delete(id);
				request.getRequestDispatcher("/common/Home.jsp").forward(request, response);;
			}
			catch (DataException de) {
		   		de.printStackTrace();
		   		w.append(de.getMessage());
		   		} catch (SQLException e) {

				e.printStackTrace();
			}
		}
			
			
		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
