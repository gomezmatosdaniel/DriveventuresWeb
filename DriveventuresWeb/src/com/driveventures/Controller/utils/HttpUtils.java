package com.driveventures.Controller.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class HttpUtils {
	/** Log */
	private static final Logger logger = LogManager.getLogger(HttpUtils.class);
	

	private static final int SB_SIZE = 256;
	
	/** Constructor */
	private HttpUtils(){}
		
	
	public static String createCallbackURL(HttpServletRequest request, String url) {
		String referer = request.getHeader("referer");
		if(referer.indexOf("?")>=0) {
		referer = referer.substring(0, referer.indexOf("?"));
		}
		String target = referer + url;
		
		return target;
	}
	

	public static String createLinkToSelf(HttpServletRequest request,
			Map<String, String[]> params) {
		
		StringBuffer url = new StringBuffer(SB_SIZE);
		String queryString = null;
		if(request!=null) {
		url.append(request.getRequestURL().toString());
		queryString = request.getQueryString();
		}
		if (queryString != null){
			url.append("?"+queryString);
		}
		URLBuilder urlBuilder = new URLBuilder(url.toString());

		urlBuilder.addParameterMap(params, true);
		return urlBuilder.toString();
	}
	

	public static String createLinkToSelf(HttpServletRequest request,
			String key, String value) {
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		String[] values = new String[2];
		values[0] = value;
		map.put(key, values);
		
		if (logger.isDebugEnabled())
			logger.debug("| HttpUtils.createLinkToSelf | TRACE --> key="+ key+ ", value="+ value);
		
		return createLinkToSelf(request, map);
	}
	

	public static String addParameterToURL(String url, String paramName,
			String paramValue, boolean replaceifExists) {
		
		URLBuilder urlBuilder = new URLBuilder(url);
		urlBuilder.addParam(paramName, paramValue, replaceifExists);
		return urlBuilder.toString();
	}
	
	/**
	 * Codifica la url a "ISO-8859-1"
	 * @param value
	 * @return
	 */
	public static String encodeUrl(String value) {
		try {
			return URLEncoder.encode(value, "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			
			if (logger.isDebugEnabled())
				logger.error("| HttpUtils.encodeUrl | UNSUPPORTED_ENCODING_EXCEPTION --> msg: "+e.getMessage());
			
			e.printStackTrace();				
		}
		return value;
	}
}
