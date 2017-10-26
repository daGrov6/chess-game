package com.cdp.chessGame.board;

public class BoardLocation {
	private int row;
	private int col;
	
	public BoardLocation(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
	public int getCol() {
		return col;
	}
	
	public int getRow() {
		return row;
	}
	
	
}
