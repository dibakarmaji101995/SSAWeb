package com.usa.gov.ssa.excetionMapper;

import javax.xml.ws.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.usa.gov.ssa.customexception.NoDataFoundException;

@RestController
@ControllerAdvice
public class CustomExceptionMapper extends ResponseEntityExceptionHandler {
 
	public CustomExceptionMapper() {
		System.out.println("CustomExceptionMapper.CustomExceptionMapper()");
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(NoDataFoundException ndfe, WebRequest request) {
		//create ErrorResponse object
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setStatusCode(400);
		errorResponse.setReason(ndfe.getMessage());
		errorResponse.setMessage("You sending bad request that is not proceding");
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}
}
