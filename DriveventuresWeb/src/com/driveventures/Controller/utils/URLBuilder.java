package com.driveventures.Controller.utils;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class URLBuilder {

	
	
	private static final Logger logger = LogManager.getLogger(HttpUtils.class);
	
	
	public static final String URL_PARAMBEGIN_MARK = "?";
	
	public static final String URL_KEYVALUE_SEPARATOR = "=";
	
	public static final String URL_PARAM_SEPARATOR = "&"; 
	
	private String paramBeginMark = URL_PARAMBEGIN_MARK;
	private String keyValueSeparator = URL_KEYVALUE_SEPARATOR;
	private String paramSeparator = URL_PARAM_SEPARATOR;
	
	private StringBuffer urlsb = null;
			
	
	public URLBuilder() {
		reset("");
	}
	
	
	public URLBuilder(String url) {		
		reset(url);		
	}
	

	public URLBuilder(String url, Map<String, String[]> params) {
		reset(url, params);
	}
	

	public URLBuilder(String url, Map<String, String[]> params, 
			String paramBeginMark, String keyValueSepator, 
			String paramSeparator) {
		
		this(url, params);
		this.paramBeginMark = paramBeginMark;
		this.keyValueSeparator = keyValueSepator;
		this.paramSeparator = paramSeparator;
	}	
	
	
	public void reset(String newUrl) {
		urlsb = new StringBuffer(newUrl);
	}
	
	
	public void reset(String newUrl, Map<String, String[]> newParameterMap) {
		reset(newUrl);
		addParameterMap(newParameterMap, false);
	}	

	
	private void appendParam(String key, String value, boolean isFirst) {
		
		urlsb.append(isFirst ? this.paramBeginMark : this.paramSeparator);
		addParam(key, value);
	}
	
	
	private void addParam(String key, String value) {
		this.urlsb.append(key).append(this.keyValueSeparator).append(value);		
	}
	

	
	public void addParameterMap(Map<String, String[]> parameterMap, boolean replaceIfExists) {
		addParameterMap(parameterMap, replaceIfExists, false);
	}
	

	
	public void addParameterMap(Map<String, String[]> parameterMap, boolean replaceIfExists, boolean encode) {
		
		if (parameterMap != null) {
			
			for (String key: parameterMap.keySet()) {
	
				
				String[] values = parameterMap.get(key);
				if (values!=null) {					
					addParam(key, values[0], replaceIfExists, encode);
				} else {
					addParam(key, null);
				}
			}
			
		}
	}	
	
	

	public void addParam(String key, String value, boolean replaceIfExists) {

		addParam(key, value, replaceIfExists, false);
	}
	
	
	public void addParam(String key, String value, boolean replaceIfExists, boolean encode) {
		
		int indexOfParamSeparator = urlsb.indexOf(this.paramBeginMark);
		String url = new String(value);
		
		
		if (encode) {
			url = HttpUtils.encodeUrl(value);
		}
		
		if (indexOfParamSeparator >= 0) {

			int paramIndex = urlsb.indexOf(key+keyValueSeparator);			
			boolean existsParam = paramIndex > 0 
				&& paramIndex > indexOfParamSeparator;
						
			if (existsParam && replaceIfExists) {
				replaceParam(key, value);
			} else if (indexOfParamSeparator < urlsb.length()-1) {
				appendParam(key, url, false);
			} else {
				addParam(key, url);
			}
		} else {
			appendParam(key, url, true);
		}		
		
	}
	
	
	
	public void deleteParam(String key) {
		replaceParamBlock(key, "");
	}
	
	
	public void replaceParam(String key, String newValue) {
		
		replaceParamBlock(key, 
				new StringBuffer(key).append(this.keyValueSeparator).
					append(newValue).toString());
	}	
	
	
	private void replaceParamBlock(String key, String replaceStr) {
			
		int keyIndex = urlsb.indexOf(key);
		if (keyIndex >= 0) {
			int nextParamIndex = urlsb.indexOf(this.paramSeparator, keyIndex);
			if (nextParamIndex < 0) {
				nextParamIndex = urlsb.length();
			}
			
			urlsb.replace(keyIndex, nextParamIndex, replaceStr); 
		}
	}

	
	public String toString() {
		
		return urlsb.toString();		
	}

	public String getKeyValueSeparator() {
		return keyValueSeparator;
	}

	public void setKeyValueSeparator(String keyValueSeparator) {
		this.keyValueSeparator = keyValueSeparator;
	}

	public String getParamSeparator() {
		return paramSeparator;
	}

	public void setParamSeparator(String paramSeparator) {
		this.paramSeparator = paramSeparator;
	}

	public String getParamBeginMark() {
		return paramBeginMark;
	}

	public void setParamBeginMark(String paramBeginMark) {
		this.paramBeginMark = paramBeginMark;
	}
	
}
