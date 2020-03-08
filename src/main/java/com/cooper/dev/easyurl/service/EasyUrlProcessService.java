package com.cooper.dev.easyurl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooper.dev.easyurl.dao.EasyUrlDao;
import com.cooper.dev.easyurl.entity.EasyUrlEntity;
import com.cooper.dev.easyurl.model.EasyUrlModel;

@Service
public class EasyUrlProcessService {
	
	@Autowired
	EasyUrlDao easyUrlDao;
	
	public String shortenUrl(EasyUrlModel easyUrlModel) { 
		try {
			EasyUrlEntity easyUrlEntity = new EasyUrlEntity(); 
			easyUrlEntity.setUrl(easyUrlModel.getUrl());
			easyUrlEntity.setShortened_url_code(easyUrlModel.getUrl().toString().hashCode());
			easyUrlDao.save(easyUrlEntity);
			return "http://localhost:4200/"+Long.toString(easyUrlModel.getUrl().toString().hashCode());
		} catch (Exception e) {
			return "Error";
		}		
	}

	public String visitShortendUrl(EasyUrlModel easyUrlModel) {
		try {			
			System.out.println(easyUrlModel.getUrl().substring(easyUrlModel.getUrl().lastIndexOf("/") + 1));
			return easyUrlDao.findCorrectUrl(easyUrlModel.getUrl().substring(easyUrlModel.getUrl().lastIndexOf("/") + 1));
		} catch (Exception e) {
			return "Error";
		}
	}
}
