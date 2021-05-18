package com.example.demo.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.productservice.model.ProductFanGear;
import com.example.demo.productservice.model.ProductVideoGame;

@Repository
public interface ProductFanGearRepo extends JpaRepository<ProductFanGear, ProductVideoGame> {
	
	

	@Query("select s from ProductFanGear s where s.prodVG = :gameId")
	@Transactional
	List<ProductFanGear> findByGameId(@Param("gameId") ProductVideoGame gameId);
	
}
