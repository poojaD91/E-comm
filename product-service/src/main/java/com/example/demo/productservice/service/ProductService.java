package com.example.demo.productservice.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.productservice.model.ProductFanGear;
import com.example.demo.productservice.model.ProductVideoGame;
import com.example.demo.productservice.repository.ProductFanGearRepo;
import com.example.demo.productservice.repository.ProductVideoGameRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductVideoGameRepo vgRepo;
	
	@Autowired
	private ProductFanGearRepo fgRepo;

	public ProductService(ProductVideoGameRepo vgRepo, ProductFanGearRepo fgRepo) {
		this.vgRepo = vgRepo;
		this.fgRepo = fgRepo;
	}
	
	public List<ProductVideoGame> getAllGames(){
		List<ProductVideoGame> list=this.vgRepo.findAll();
		for (ProductVideoGame item : list){   
			System.out.println(item.getGameName());
			
		}
		return this.vgRepo.findAll();	
	}
	
	public List<ProductFanGear> getAllGears(){
		
		return this.fgRepo.findAll();	
	}
	
	public ProductVideoGame saveGame(ProductVideoGame game){
		vgRepo.save(game);
		return game;
	}
	
	public ProductFanGear saveGear(ProductFanGear gear){
		fgRepo.save(gear);
		return gear;
	}
	
	public List<ProductFanGear> findByGameId(ProductVideoGame gameId){	
		return fgRepo.findByGameId(gameId);
	}

}
