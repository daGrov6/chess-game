package com.cdp.chessGame.enums;

public enum PieceOwner {
	WHITE("W"), BLACK("B");
	
	private String strRep;
	
	private PieceOwner(String strRep) {
		this.strRep = strRep;
	}
	
	public String toString() {
		return strRep;
	}
	
}
