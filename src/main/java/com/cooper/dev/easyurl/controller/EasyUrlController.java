package com.cooper.dev.easyurl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.dev.easyurl.model.EasyUrlModel;
import com.cooper.dev.easyurl.service.EasyUrlProcessService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EasyUrlController {
	
	@Autowired
	EasyUrlProcessService easyUrlProcessService;	
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	@PostMapping("/procesUrl")
	public String processUrl(@RequestBody EasyUrlModel easyUrlModel) {

		log.info("Url to be processed is : " + easyUrlModel.getUrl());
		return easyUrlProcessService.shortenUrl(easyUrlModel);

	}
	
	@PostMapping("/visitShortendUrl")
	public String visitShortendUrl(@RequestBody EasyUrlModel easyUrlModel) {

		log.info("Url is : " + easyUrlModel.getUrl());
		return easyUrlProcessService.visitShortendUrl(easyUrlModel);

	}
}
 