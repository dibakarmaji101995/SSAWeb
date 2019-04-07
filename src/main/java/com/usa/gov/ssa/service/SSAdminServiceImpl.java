package com.usa.gov.ssa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.gov.ssa.entity.SSAMasterEntity;
import com.usa.gov.ssa.entity.StateMasterEntity;
import com.usa.gov.ssa.model.Person;
import com.usa.gov.ssa.repository.SSAMasterRepository;
import com.usa.gov.ssa.repository.StateMasterRepository;

@Service(value = "adminService")
public class SSAdminServiceImpl implements SSAdminService {
	@Autowired
	private SSAMasterRepository repository;
	
	@Autowired
	private StateMasterRepository stateMasterRepository;

	@Override
	public Person generateSSN(Person personModel) {
		SSAMasterEntity entity = null;
		// create entity class object
		entity = new SSAMasterEntity();
		// convert personModel to entity
		BeanUtils.copyProperties(personModel, entity);
		// save the entity
		entity = (SSAMasterEntity) repository.save(entity);
		// convert entity to personModel
		BeanUtils.copyProperties(entity, personModel);
		return personModel;
	}// method

	public Person verifySSN(long ssn) {
		Optional<SSAMasterEntity> opEntity = null;
		SSAMasterEntity entity = null;
		Person personModel = null;
		// invoke the repository method
		opEntity = repository.findById(ssn);
		if (opEntity.isPresent()) {
			// get entity object
			entity = opEntity.get();
			if (entity != null) {
				// convert entity to personModel object
				personModel = new Person();
				BeanUtils.copyProperties(entity, personModel);
				// return personModel object
				return personModel;
			}
		}
		return null;
	}// method
	/**
	 * 
	 * @return
	 */
	public List<StateMasterEntity> findAllStates() {
		List<StateMasterEntity> listEntity=null;
		//invoke StateMsterRepository method
//		listEntity=stateMasterRepository.getAllStates();
		listEntity=stateMasterRepository.findAll();
		//return entity object
		return listEntity;
	}//method
}