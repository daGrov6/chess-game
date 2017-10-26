package com.cdp.chessGame.enums;

public enum PieceType {
		PAWN("P"),
		ROOK("R"),
		KNIGHT("N"),
		BISHOP("B"),
		KING("K"),
		QUEEN("Q");
	
	String strRep;
	
	private PieceType(String strRep) {
		this.strRep = strRep;
	}
	
	public String toString()
	{
		return strRep;
	}
}
