package com.example.demo.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.productservice.model.ProductVideoGame;

@Repository
public interface ProductVideoGameRepo extends JpaRepository<ProductVideoGame, Integer> {

}
