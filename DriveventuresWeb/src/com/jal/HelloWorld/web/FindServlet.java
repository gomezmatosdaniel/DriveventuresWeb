package com.jal.HelloWorld.web;

import java.io.IOException;

import java.io.Writer;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.driveventures.model.Coche;
import com.driveventures.model.Conductor;
import com.driveventures.service.CocheService;
import com.driveventures.service.ConductorService;
import com.driveventures.service.Impl.CocheServiceImpl;
import com.driveventures.service.Impl.ConductorServiceImpl;

import DBCUtils.DataException;


@WebServlet("/login")
public class FindServlet extends HttpServlet {
	
	private ConductorService conductorService = null;

    public FindServlet() {
    	conductorService = new ConductorServiceImpl();     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int viajes = Integer.parseInt(request.getParameter("viajes"));
		System.out.println("Buscando el conductor con " + viajes + "....");
		response.getWriter().append("Served at: ").append(request.getContextPath());
       Writer w = response.getWriter();

		

	try {
		///capa de negocio
		Conductor c = conductorService.
		request.setAttribute("results", c);
		w.append("Coche:");
		w.append(c.toString());
		request.getRequestDispatcher("/html/results.jsp").forward(request, response);;
		
	} catch (DataException de) {
		de.printStackTrace();
		w.append(de.getMessage());
	} catch (SQLException e) {
		w.append(e.getMessage());
		e.printStackTrace();
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
