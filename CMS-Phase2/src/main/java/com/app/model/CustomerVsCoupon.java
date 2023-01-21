package com.app.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;


//@Entity
public class CustomerVsCoupon {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn(name = "CustomerId", referencedColumnName = "id")
//	private List<Customer> customerID;
//	
//
//	@OneToMany(cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn(name = "CouponId", referencedColumnName = "id")
//	private List<Coupon> couponID;
}
