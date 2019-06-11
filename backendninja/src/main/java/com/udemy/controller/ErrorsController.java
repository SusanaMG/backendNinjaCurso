package com.udemy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Este controlados se va a usar para controlar excepciones
@ControllerAdvice
public class ErrorsController {

	public static final String ISE_VIEW = "error/500";	//error: nombre de la carpeta
	
	@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		return ISE_VIEW;
	}
}
