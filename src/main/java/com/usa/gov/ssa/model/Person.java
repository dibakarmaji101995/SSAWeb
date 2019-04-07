package com.usa.gov.ssa.model;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

	private long ssn;

	private String firstName;

	private String lastName;

	private String fatherName;

	private String motherName;

	private String dob;

	private String gender;

	private String state;

}// class
