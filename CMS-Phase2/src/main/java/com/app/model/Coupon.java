package com.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Coupons")
@Getter
@Setter
@AllArgsConstructor
public class Coupon {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name = "CompanyId",referencedColumnName = "id")
	private Company company;

	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name = "CatagoryId", referencedColumnName = "id")
	private Category categoryID;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "startDate")
	private String startDate;
	
	@Column(name = "endDate")
	private String endDate;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "image")
	private String image;

}
