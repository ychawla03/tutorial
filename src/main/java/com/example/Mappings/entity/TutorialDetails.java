package com.example.Mappings.entity;

import java.util.Date;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tutorial_details")
@NoArgsConstructor @Getter @Setter @AllArgsConstructor @ToString
public class TutorialDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Date createdOn;
	
	@Column
	private String createdBy;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "tutorial_id")
	private Tutorial tutorial;

	public TutorialDetails(Date createdOn, String createdBy) {
		super();
		this.createdOn = new Date();
		this.createdBy = createdBy;
	}
}
