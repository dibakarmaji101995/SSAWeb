package com.usa.gov.ssa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usa.gov.ssa.entity.StateMasterEntity;

public interface StateMasterRepository extends JpaRepository<StateMasterEntity,Serializable>{
	@Query("select stateName from StateMasterEntity")
	public List<StateMasterEntity> getAllStates();

}
