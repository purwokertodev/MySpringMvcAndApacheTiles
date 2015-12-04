package com.vq.webmon.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
	private Integer id;
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;
	@Column(name = "SALARY")
	private Double salary;
	@Column(name = "AGE")
	private Integer age;
	
	public Employee(){
		
	}
	

	public Employee(Integer id, String employeeName, Double salary, Integer age) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.salary = salary;
		this.age = age;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName
				+ ", salary=" + salary + ", age=" + age + "]";
	}
	
	
}
