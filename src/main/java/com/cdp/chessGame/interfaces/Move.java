package com.cdp.chessGame.interfaces;

import com.cdp.chessGame.board.BoardLocation;
import com.cdp.chessGame.enums.PieceOwner;
import com.cdp.chessGame.enums.PieceType;

public interface Move {
	public PieceOwner getPieceOwner();
	public PieceType getPieceType();
	public BoardLocation getFrom();
	public BoardLocation getTo();
}
