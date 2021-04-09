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

import com.driveventures.model.Conductor;
import com.driveventures.service.ConductorService;
import com.driveventures.service.Impl.ConductorServiceImpl;

import DBCUtils.DataException;


@WebServlet("/ConductorFind")
public class ConductorFind extends HttpServlet {
	
	private ConductorService conductorService = null;
   
    public ConductorFind() {
    	conductorService = new ConductorServiceImpl(); 
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
