package com.firstadvertisement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Advertises")
public class Advertise {
	@GeneratedValue
	@Id
	@Column(name="Adv_Id")
	private long adv_id;
	
	@Column(name = "adv_name")
	private String name;
	
	@Column(name="Categories")
	private String category;
	
	@Column(name="Titles")
	private String title;
	
	@Column(name="Description")
	private String description;
	
	@ManyToOne
	private long id; 
	
	public Advertise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Advertise(long id, String category, String title, String description) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.description = description;
	}
	public Advertise(String category, String title, String description) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
