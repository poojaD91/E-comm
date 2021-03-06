package com.example.demo.productservice.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="game_details")
public class ProductVideoGame {

	@Id
	@GeneratedValue
	private int gameId;
	private String gameName;
	private String developer;
	private String platform;
	private int quantity;
	private float price;
	
	
	
	/*public ProductVideoGame(int gameId, String gameName, String developer, String platform, int quantity,
			Set<ProductFanGear> prodFG) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.developer = developer;
		this.platform = platform;
		this.quantity = quantity;
		this.prodFG = prodFG;
	}*/
	
	
	
	
	public ProductVideoGame(int gameId, String gameName, String developer, String platform, int quantity,float price) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.developer = developer;
		this.platform = platform;
		this.quantity = quantity;
		this.price = price;
		
	}


	public ProductVideoGame() {}

	

	public int getgameId() {
		return gameId;
	}

	public void setgameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	
}
