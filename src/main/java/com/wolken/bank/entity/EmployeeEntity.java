package com.wolken.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class EmployeeEntity {
	@Id
	@GenericGenerator(name = "Madhushree", strategy = "increment")
	@GeneratedValue(generator="Madhushree")
private int id;
private String name;
private String designation;
private String email;
private float salary;
private long contactNumber;


}
