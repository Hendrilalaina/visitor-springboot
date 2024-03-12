package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int numberOfDay;
    private double price;
    public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getNumberOfDay() {
		return numberOfDay;
	}
	public double getPrice() {
		return price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNumberOfDay(int numberOfDay) {
		this.numberOfDay = numberOfDay;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
