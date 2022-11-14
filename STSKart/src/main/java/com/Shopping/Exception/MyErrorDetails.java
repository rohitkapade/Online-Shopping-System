package com.Shopping.Exception;

import java.time.LocalDateTime;

public class MyErrorDetails {

	private LocalDateTime ldt;
	private String Message;
	private String Description;
	
	public MyErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	public MyErrorDetails(LocalDateTime ldt, String message, String description) {
		super();
		this.ldt = ldt;
		Message = message;
		Description = description;
	}

	public LocalDateTime getLdt() {
		return ldt;
	}

	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "MyErrorDetails [ldt=" + ldt + ", Message=" + Message + ", Description=" + Description + "]";
	}
	
	
	
}
