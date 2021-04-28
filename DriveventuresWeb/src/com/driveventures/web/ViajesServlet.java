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

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.Controller.utils.Actions;
import com.driveventures.Controller.utils.Errors;
import com.driveventures.Controller.utils.ParameterNames;
import com.driveventures.model.Conductor;
import com.driveventures.service.ConductorService;
import com.driveventures.service.Results;
import com.driveventures.service.Impl.ConductorServiceImpl;

import DBCUtils.DataException;


@WebServlet("/Viajes")
public class ViajesServlet extends HttpServlet {
	
	private static Logger logger = LogManager.getLogger(ViajesServlet.class);
	private ConductorService conductorService = null;
	
	
    public ViajesServlet() {
        super();
        conductorService = new ConductorServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String action = request.getParameter(ParameterNames.ACTION);

		Errors errors = new Errors();

		String target = null;
		boolean redirect = false;
		
		
		String url = "";
		
if( Actions.BUENARUTA.equalsIgnoreCase(action)) {
			
			int buenaruta = Integer.parseInt(request.getParameter("Viajes"));
			
			System.out.println("Buscando las Buenas Rutas " + buenaruta + "....");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			Writer w = response.getWriter();
			

			try {
				
				List<Conductor> c = conductorService.findByBuenaRuta(buenaruta);
				request.setAttribute("ViajesResult", c);
				HttpSession session = request.getSession();
				request.getRequestDispatcher("html/ViajesResult.jsp").forward(request, response);;
			} catch (DataException e) {
				logger.warn(e.getMessage(),e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}  
		else if( Actions.BUENACONVERSACION.equalsIgnoreCase(action)) {
			
			int buenaconversacion = Integer.parseInt(request.getParameter("Viajes"));

			System.out.println("Buscando Buenas Conversaciones " + buenaconversacion + "....");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			Writer w = response.getWriter();
			

			try {
				
				List<Conductor> c = conductorService.findByBuenaConversacion(buenaconversacion);
				request.setAttribute("ViajesResult", c);
				HttpSession session = request.getSession();
				request.getRequestDispatcher("html/ViajesResult.jsp").forward(request, response);;
			} catch (DataException e) {
				logger.warn(e.getMessage(),e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().append("Served at: ").append(request.getContextPath());
		
		} else if( Actions.EXCELENTESERVICIO.equalsIgnoreCase(action)) {
			
			int excelenteservicio = Integer.parseInt(request.getParameter("Viajes"));

			System.out.println("Buscando Excelentes Servicios " + excelenteservicio + "....");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			Writer w = response.getWriter();
			

			try {
				
				List<Conductor> c = conductorService.findByExcelenteServicio(excelenteservicio);
				request.setAttribute("ViajesResult", c);
				HttpSession session = request.getSession();
				request.getRequestDispatcher("html/ViajesResult.jsp").forward(request, response);;
			} catch (DataException e) {
				logger.warn(e.getMessage(),e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
			
		} else if( Actions.VIAJES.equalsIgnoreCase(action)) {
			int viajes = Integer.parseInt(request.getParameter("Viajes"));
			
			System.out.println("Buscando los viajes " + viajes + "....");
			response.getWriter().append("Served at: ").append(request.getContextPath());
	       Writer w = response.getWriter();

			
			
			try {
				
				List<Conductor> c = conductorService.findByViajes(viajes);
				request.setAttribute("ViajesResult", c);
				HttpSession session = request.getSession();
				request.getRequestDispatcher("html/ViajesResult.jsp").forward(request, response);;
			} catch (DataException e) {
				logger.warn(e.getMessage(),e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			response.getWriter().append("Served at: ").append(request.getContextPath());
		} else if( Actions.RESIDENCIA.equalsIgnoreCase(action)) {
			
			String Residencia = (request.getParameter("residencia"));
			System.out.println("Buscando el conductor con " + Residencia + "....");
			response.getWriter().append("Served at: ").append(request.getContextPath());
	       Writer w = response.getWriter();
	       
	       try {
	   		///capa de negocio
	   		List<Conductor> c = conductorService.findByResidencia(Residencia.trim());
	   		request.setAttribute("ResidenciaResults", c);
	   		w.append("Coche:");
	   		w.append(c.toString());
	   		request.getRequestDispatcher("/html/ResidenciaResults.jsp").forward(request, response);;
	   		
	   	} catch (DataException de) {
	   		de.printStackTrace();
	   		w.append(de.getMessage());
	   	} catch (SQLException e) {
	   		w.append(e.getMessage());
	   		e.printStackTrace();
	   	}
		}

	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
