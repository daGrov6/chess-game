package com.cdp.chessGame.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Players")
public class ChessPlayer implements com.cdp.chessGame.interfaces.Player
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String userName;
//	private int rating;
	
	public ChessPlayer()
	{
		
	}
	
	public ChessPlayer(String name)
	{
		this.userName = name;
		
	}
	
	public ChessPlayer(int id, String name)
	{
		this.id = id;
		this.userName = name;
	}
	
//	public ChessPlayer(String name, int rating)
//	{
//		this.userName = name;
//		this.rating = rating;
//	}
	
	@Override
	public String getName() {
		return userName;
	}

//	@Override
//	public int getRating() {
//		return rating;
//	}
	
	@Override
	public int getId()
	{
		return id;
	}
	
	public String toString()
	{
		return "Player[" + id + "," + userName + "]";
	}
}
