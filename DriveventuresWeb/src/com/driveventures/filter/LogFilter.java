package com.driveventures.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Filtro para probar la entrada y salida que tracea cada petición.
 */
//@WebFilter("/*")
public class LogFilter implements Filter {

    public LogFilter() {
        
    }

	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("LogFilter: ");
		System.out.println("Ip origen: " +request.getRemoteAddr());
		System.out.println("Puerto origen" +request.getRemotePort());
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		System.out.println("URL" +httpRequest.getRequestURI());
		System.out.println("QueryString" +httpRequest.getQueryString());
		Map<String, String[]> params = httpRequest.getParameterMap();
		for (String pname: params.keySet()) {
			System.out.println(pname+"="+params.get(pname));
		}
		chain.doFilter(request, response);
		
		System.out.println("Vuelvo de la petición");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
