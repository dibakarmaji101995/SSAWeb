package com.usa.gov.ssa.service;

import java.util.List;

import org.springframework.ui.Model;

import com.usa.gov.ssa.entity.StateMasterEntity;
import com.usa.gov.ssa.model.Person;

public interface SSAdminService {
     public Person generateSSN(Person personModel);
     public Person verifySSN(long ssn);
     
     public List<StateMasterEntity> findAllStates();
}
