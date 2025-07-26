package com.example.Mappings.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "tutorials")
@NoArgsConstructor @Getter @Setter @ToString
public class Tutorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	
	private String description;
	
	private boolean published;

	public Tutorial(String title, String description, boolean published) {
		super();
		this.title = title;
		this.description = description;
		this.published = published;
	}
	
	
	
	

}
