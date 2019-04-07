package com.usa.gov.ssa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usa.gov.ssa.entity.SSAMasterEntity;

@Repository(value="personRepository")
public interface SSAMasterRepository extends JpaRepository<SSAMasterEntity,Serializable>{
     
}
