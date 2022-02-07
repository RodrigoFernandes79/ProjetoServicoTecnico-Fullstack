package com.servicoTecnico.os.exceptions;

public class ApiException {
	public String campo;
	public String message;
	
	
	
	public ApiException(String message) {

		this.message =message;
		
	}
	
	



	public ApiException(String campo, String message) {
		
		this.campo = campo;
		this.message = message;
	}










	public String getCampo() {
		return campo;
	}



	public String getMessage() {
		return message;
	}
	
	
	

}
