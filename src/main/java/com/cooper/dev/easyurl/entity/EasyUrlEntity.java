package com.cooper.dev.easyurl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="url_details")
public class EasyUrlEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	private String url;
	private int shortened_url_code;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getShortened_url_code() {
		return shortened_url_code;
	}
	public void setShortened_url_code(int shortened_url_code) {
		this.shortened_url_code = shortened_url_code;
	}
	
}
