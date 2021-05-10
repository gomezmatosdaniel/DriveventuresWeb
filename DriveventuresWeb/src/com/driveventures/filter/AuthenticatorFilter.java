package com.driveventures.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.driveventures.utils.AttributeNames;
import com.driveventures.utils.ErrorCodes;
import com.driveventures.utils.Errors;
import com.driveventures.utils.ParameterNames;
import com.driveventures.utils.SessionAttributeNames;
import com.driveventures.utils.ViewPaths;

/**
 * Servlet Filter implementation class AuthenticatorFilter
 */
@WebFilter("/AuthenticatorFilter")
public class AuthenticatorFilter implements Filter {
	
 
	private static Logger logger = LogManager.getLogger(AuthenticatorFilter.class);

    public AuthenticatorFilter() {
    
    }

	public void doFilter(ServletRequest request, 
						 ServletResponse response, 
						 FilterChain chain) throws IOException, ServletException {				
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		Errors errors = new Errors();
		
		if ((SessionManager.get(httpRequest, SessionAttributeNames.USER)==null)) {			
			// Usuario no autenticado
			logger.info("Usuario debe autenticarse");
			
			errors.addError(ParameterNames.ACTION, ErrorCodes.NOT_LOGGED);
			
			request.setAttribute(AttributeNames.ERROR, errors);
			request.getRequestDispatcher(ViewPaths.LOGIN).forward(request, response);
			
			
		} else {
			// Usuario autenticado o accion no protegida
			chain.doFilter(request, response);
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {
		
	}
	

}