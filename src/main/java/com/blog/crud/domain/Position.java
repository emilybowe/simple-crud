package com.blog.crud.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "position")
public class Position implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    @NotBlank
    @Column(length=50)
	private String title;
    
	public @NotBlank String getTitle() {
		return title;
	}
	public void setTitle(@NotBlank String title) {
		this.title = title;
	}
    
    @Column(length=50)
	private String level;	

	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	private int salary;
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Position(Long id, String title, String level, int salary) {
		this.setId(id);
		this.setTitle(title);
		this.setLevel(level);
		this.setSalary(salary);
	}

	public Position() {
		
	}
}
