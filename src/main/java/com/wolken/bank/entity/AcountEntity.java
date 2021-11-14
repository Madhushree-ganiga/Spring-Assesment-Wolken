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
public class AcountEntity {
	@Id
	@GenericGenerator(name = "Madhushree", strategy = "increment")
	@GeneratedValue(generator="Madhushree")
	private int id;
	private long accountNo;
	private String holderName;
	private long contactNumber;
	private String email;
	private String address;
	private String branchName;
	private String typeOfAccount;
	private float amount;
	private String status;
	private String nominee;
	private String gender;
	private String dob;

}
