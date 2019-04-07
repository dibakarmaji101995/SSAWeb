package com.usa.gov.ssa.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.usa.gov.ssa.customexception.NoDataFoundException;
import com.usa.gov.ssa.excetionMapper.ErrorResponse;
import com.usa.gov.ssa.model.Person;
import com.usa.gov.ssa.service.SSAdminService;

@RestController
public class SSNResource {
	public SSNResource() {
		System.out.println("SSNResource.SSNResource()");
	}
	@Autowired
	private SSAdminService service;
	
	/*@GetMapping(path="/validateSSN/{ssn}",produces= {"application/json","application/xml"})
	public ResponseEntity<Object> validateSSN(@PathVariable long ssn) {
		//call service class validateSSN() method
		Person person=service.verifySSN(ssn);
		if(null!=person) {
			return ResponseEntity.ok(person);
		}
		ErrorResponse exception = new ErrorResponse();
		exception.setStatusCode(400);
		exception.setReason("Wrong SSN");
		exception.setMessage("Invalid SSN,Please Provide Valid SSN");
		return ResponseEntity.badRequest().body(exception);
	}*/
	@GetMapping(path="/validateSSN/{ssn}",produces= {"application/json","application/xml"})
	public ResponseEntity<Object> validateSSN(@PathVariable long ssn) {
		//call service class validateSSN() method
		Person person=service.verifySSN(ssn);
		if(null!=person) {
			return ResponseEntity.ok(person);
		}
	    throw new NoDataFoundException("Invalid SSN");	
	}
}//class
