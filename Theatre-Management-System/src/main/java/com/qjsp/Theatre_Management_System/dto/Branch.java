package com.qjsp.Theatre_Management_System.dto;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	private String branchName;
	private String branchGst;
	private String branchEmail;
	private long branchPhone;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Manager manager;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Address address;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Staff> staff;
	
	@OneToMany
	@Cascade (CascadeType.ALL)
	private List<Screen> screen;
	
}
