package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

}
