package com.driveventures.Controller.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionManager {

	public static Object get(HttpServletRequest request, String attName) {
		return getSession(request).getAttribute(attName);
	}

	public static void set(HttpServletRequest request, String attName, Object attValue) {
		getSession(request).setAttribute(attName, attValue);
	}
	
	/**
	 * Método factoria de la sesión, y sus objetos mandatorios.
	 * @param request
	 * @return
	 */
	protected static HttpSession getSession(HttpServletRequest request) {
		HttpSession httpSession = request.getSession(false);
	
		return httpSession;
	}	
	
	
}
