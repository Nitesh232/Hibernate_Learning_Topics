package com.nitesh.hib.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity()
public class Games {
	@Id
	@GeneratedValue()
	private int Id;
	
	
	private String gameType;
	
	private String gameName;
	
	private int playerNo;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	public Games(int id, String gameType, String gameName, int playerNo) {
		this.Id = id;
		this.gameType = gameType;
		this.gameName = gameName;
		this.playerNo = playerNo;
	}

	public Games() {
	
	}
	
	

}
