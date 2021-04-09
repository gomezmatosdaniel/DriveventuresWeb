package com.driveventures.Controller.utils;

import javax.servlet.http.HttpServletRequest;

public class ParamUtils {

	public static final String getParameter(HttpServletRequest request, String name) {		
		String value = (String) request.getParameter(name);							
		if (value==null) value = "";
		return value;
	}
	
}
