package com.cg.customerinfo.exceptions;

import java.util.List;

public class ExceptionResponse {

	private String message;
	private List<String> details;
	private String uriDescription;

	public ExceptionResponse(String message, List<String> details, String uriDescription) {
		super();
		this.message = message;
		this.details = details;
		this.uriDescription = uriDescription;
	}

	public String getUriDescription() {
		return uriDescription;
	}

	public void setUriDescription(String uriDescription) {
		this.uriDescription = uriDescription;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

}
