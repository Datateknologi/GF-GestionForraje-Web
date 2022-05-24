package com.gestionforraje.web.Exeption;

public class CustomeFieldValidationException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4021570864226270321L;
	
	private String fieldName;
	
	public CustomeFieldValidationException(String message, String fieldName) {
		super(message);
		this.fieldName = fieldName;
		
	}
	
	
	public String getFieldName() {
		return this.fieldName;
	}

}
