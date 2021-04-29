package com.driveventures.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class GetPageNumber {
	
private static Logger logger = LogManager.getLogger(GetPageNumber.class.getName());
	
	/**
	 * Obtiene el valor entero de un valor de parametro currentPageValue
	 */
	public static final int getPageNumber(String pageValue, int defaultValue) {
		int pageNumber = defaultValue;
		if (pageValue!=null) {
			try {
				pageNumber = Integer.valueOf(pageValue);
			} catch (NumberFormatException e) {
				logger.warn("Parece que hay un usuario navegando que se considera muy listo: "+pageValue);		
			}
		}
		return pageNumber;
	}
}
