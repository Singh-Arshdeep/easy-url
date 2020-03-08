package com.cooper.dev.easyurl.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cooper.dev.easyurl.entity.EasyUrlEntity;
import com.cooper.dev.easyurl.model.EasyUrlModel;

public interface EasyUrlDao extends CrudRepository<EasyUrlEntity,Long>{
	
	@Query(value="select url from url_details where shortened_url_code =?1 limit 1",nativeQuery=true)
	String findCorrectUrl(String easyUrlModel);
} 
