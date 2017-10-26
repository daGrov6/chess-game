package com.cdp.chessGame.board;

import com.cdp.chessGame.enums.PieceOwner;
import com.cdp.chessGame.enums.PieceType;

public class ChessMove implements com.cdp.chessGame.interfaces.Move 
{
	private PieceOwner owner;
	private PieceType type;
	private BoardLocation fromLocation;
	private BoardLocation toLocation;
	
	public ChessMove(PieceOwner owner, PieceType type, BoardLocation fromLocation, BoardLocation toLocation)
	{
		this.owner = owner;
		this.type = type;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
	}
	
	@Override
	public PieceOwner getPieceOwner() {
		return owner;
	}

	@Override
	public PieceType getPieceType() {
		return type;
	}

	@Override
	public BoardLocation getFrom() {
		return fromLocation;
	}

	@Override
	public BoardLocation getTo() {
		return toLocation;
	}


}
