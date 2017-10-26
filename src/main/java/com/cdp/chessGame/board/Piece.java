package com.cdp.chessGame.board;

import com.cdp.chessGame.enums.PieceOwner;
import com.cdp.chessGame.enums.PieceType;

public class Piece {
	private PieceType pieceType;
	private PieceOwner owner;
	
	public Piece(PieceType pieceType, PieceOwner owner) {
		super();
		this.pieceType = pieceType;
		this.owner = owner;
	}
	
	public PieceType getPieceType() {
		return pieceType;
	}
	
	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}
	
	public PieceOwner getOwner() {
		return owner;
	}
	
	public void setOwner(PieceOwner owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((pieceType == null) ? 0 : pieceType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (owner != other.owner)
			return false;
		if (pieceType != other.pieceType)
			return false;
		return true;
	}
}
