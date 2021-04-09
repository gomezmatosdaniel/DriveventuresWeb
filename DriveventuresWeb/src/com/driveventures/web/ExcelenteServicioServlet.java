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

import com.driveventures.model.Conductor;
import com.driveventures.service.ConductorService;
import com.driveventures.service.Impl.ConductorServiceImpl;

import DBCUtils.DataException;


@WebServlet("/ExcelenteServicio")
public class ExcelenteServicioServlet extends HttpServlet {
	
	private static Logger logger = LogManager.getLogger(ViajesServlet.class);
	private ConductorService conductorService = null;

    public ExcelenteServicioServlet() {
        super();
        conductorService = new ConductorServiceImpl();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
