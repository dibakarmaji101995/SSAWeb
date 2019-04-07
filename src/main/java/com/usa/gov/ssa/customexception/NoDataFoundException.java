package com.usa.gov.ssa.customexception;

public class NoDataFoundException extends RuntimeException {
     public NoDataFoundException() {
		System.out.println("NoDataFoundExcetion.NoDataFoundExcetion()");
	}
     public NoDataFoundException(String msg) {
    	 super(msg);
     }
}
