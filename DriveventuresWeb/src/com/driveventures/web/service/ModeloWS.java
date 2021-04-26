package com.driveventures.web.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.driveventures.model.Modelo;
import com.google.gson.Gson;


@WebServlet("/modelows")
public class ModeloWS extends HttpServlet {
	// private ModeloService modeloService = null; 
	
	private static final Gson JSON_SERIALIZER = new Gson();

    public ModeloWS() {     
        // modeloService = new ModeloServiceImpl(); 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(
				ToStringBuilder.reflectionToString(request.getParameterMap()));
		
		String action = request.getParameter("action");
		if ("searchByMarca".equalsIgnoreCase(action)) {
			String idMarcaStr = request.getParameter("id");
			if (!StringUtils.isBlank(idMarcaStr)) {
				Long idMarca = Long.valueOf(idMarcaStr);
				// List<Modelo> modeloService.findByMarca(idMarca);
				List<Modelo> modelos = new ArrayList<Modelo>();
				Modelo m;
				for (int i = 0; i<idMarca/100; i++) {
					m = new Modelo();
					m.setId(i);
					m.setNombreModelo("Modelo "+i+" "+System.currentTimeMillis());				
					modelos.add(m);
				}

				
				String jsonResponse = JSON_SERIALIZER.toJson(modelos);
				System.out.println(jsonResponse);

				response.setContentType("application/json");
				ServletOutputStream os = response.getOutputStream();			
				os.write(jsonResponse.getBytes());
				os.flush();
				
			
			}
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
