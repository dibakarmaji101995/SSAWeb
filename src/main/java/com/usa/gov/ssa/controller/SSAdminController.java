package com.usa.gov.ssa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usa.gov.ssa.entity.StateMasterEntity;
import com.usa.gov.ssa.model.Person;
import com.usa.gov.ssa.service.SSAdminService;

@Controller
public class SSAdminController {
	@Autowired
	private SSAdminService service;
	
	@RequestMapping(value="/ssnGen")
     public String ssaGenform(Model model) {
		//create empty model object
		Person person =new Person();
		model.addAttribute("personModel",person);
		initForm(model);
    	 return "ssnGen";
     }
	
	@RequestMapping(value = "/ssnGen", method = RequestMethod.POST)
	public String ssaGenerator(@ModelAttribute("personModel") Person personModel, Model model) {
             
			// call Service layer method
			personModel= service.generateSSN(personModel);
			if (personModel.getSsn()!=0) {
				//format ssn
				String ssn=Long.toString(personModel.getSsn());
				StringBuilder sb=new StringBuilder(ssn);
				sb.insert(3,"-");
				sb.insert(6,"-");
				ssn=sb.toString();
				// Display success message
				model.addAttribute("success",personModel.getFirstName()+" "+personModel.getLastName()+" your SSN is generated and your SSN is "+ssn);
			} else {
				// Display failure message
				model.addAttribute("failure","your SSN number is not generated");
			}
			initForm(model);
			//return lvn
		return "ssnGen";
	}
	/**
	 * 
	 * @param model
	 */
	public void initForm(Model model) {
		List<StateMasterEntity> listEntity=null;
		List<String> statesList=new ArrayList<String>();
		//invoke the service class method
		listEntity=service.findAllStates();
		listEntity.forEach(entity->{
			statesList.add(entity.getStateName());
		});
		model.addAttribute("stateList",statesList);
	}

}
