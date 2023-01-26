package com.app.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Catagories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private int id;
	
	@Id
	@Column(name = "name",length = 25)
	private String name;
	
	@OneToOne(mappedBy = "category")
    private  Coupon coupon;
}
