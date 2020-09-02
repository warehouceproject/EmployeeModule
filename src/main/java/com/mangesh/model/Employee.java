package com.mangesh.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="EMPLOYEETAB")
public class Employee {
	
	@Id
	@GeneratedValue
	private Integer empId;
	private String empName;
	private String  empGender;
	private String empEmail;
	private String empAddress;
	private String empLocation;
	@ElementCollection
	@CollectionTable(name = "PROJECT",joinColumns = @JoinColumn(name="empId"))
	@Column(name="project")
	private Set<String> empProject;
	@ElementCollection
	@CollectionTable(name = "SLOT",joinColumns = @JoinColumn(name="empId"))
	@Column(name="slot")
	private Set<String> empSlot;
	
}
