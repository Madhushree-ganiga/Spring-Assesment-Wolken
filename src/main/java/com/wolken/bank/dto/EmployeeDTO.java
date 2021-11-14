package com.wolken.bank.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeDTO {
	private int id;
	private String name;
	private String designation;
	private String email;
	private float salary;
	private long contactNumber;

}
