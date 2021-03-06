package com.example.demo.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.productservice.model.ProductFanGear;
import com.example.demo.productservice.model.ProductVideoGame;
import com.example.demo.productservice.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1")
public class ProductController {
	
	@Autowired
	private ProductService prodService;

	public ProductController(ProductService prodService) {
		this.prodService = prodService;
	}
	
	@GetMapping(path="/games")
	public List<ProductVideoGame> findAllGames(){
		return this.prodService.getAllGames();
	}
	
	@GetMapping(path="/gears")
	public List<ProductFanGear> findAllGears(){
		return this.prodService.getAllGears();
	}
	
	@GetMapping(path="/gears/{gameId}")
	public List<ProductFanGear> findGears(@PathVariable("gameId") ProductVideoGame gameId){
		System.out.println("inside gears"+gameId);
		return this.prodService.findByGameId(gameId);
	}
	
	@PostMapping(path="/games")
	public ResponseEntity<ProductVideoGame> customerCreated(@RequestBody ProductVideoGame game){
		ProductVideoGame gameSaved=prodService.saveGame(game);
		return new ResponseEntity<ProductVideoGame>(gameSaved,HttpStatus.CREATED);
	}
	
	@PostMapping(path="/gears")
	public ResponseEntity<ProductFanGear> customerCreated(@RequestBody ProductFanGear gear){
		ProductFanGear gearSaved=prodService.saveGear(gear);
		return new ResponseEntity<ProductFanGear>(gearSaved,HttpStatus.CREATED);
	}
}
