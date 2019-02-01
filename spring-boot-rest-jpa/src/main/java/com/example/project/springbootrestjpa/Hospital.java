package com.example.project.springbootrestjpa;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hospital {
	
	  @Id
	  private Long id;
	  private String name;
	  private String city;
	  private double rating;

	  public Hospital() {
		  
	  }
	  
	  public Hospital(Long id, String name, String city, double rating) {
		  this.id= id;
		  this.name= name;
		  this.city= city;
		  this.rating=rating;
	  }

	  public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	

	}