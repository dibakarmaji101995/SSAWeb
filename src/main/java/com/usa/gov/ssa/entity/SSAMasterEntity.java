package com.usa.gov.ssa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="SSA_MASTER")
public class SSAMasterEntity {
	@Id

    @SequenceGenerator(name="ssn_seq", initialValue=123456789, allocationSize=1)

    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ssn_seq")
	
	@Column(name="SSN",length=9)
     private long ssn;
	
	@Column(name="FName",length=40)
     private String firstName;
	
	@Column(name="LNAME",length=40)
     private String lastName;
	 
	@Column(name="FATHERNAME",length=40)
    private String fatherName;
	
	@Column(name="MOTHERNAME",length=40)
    private String motherName;
	 
	
	@Column(name="DOB")
     private String dob;

	
	@Column(name="GENDER",length=10)
     private String gender;
	
	@Column(name="STATE",length=40)
	private String state;
}//class
