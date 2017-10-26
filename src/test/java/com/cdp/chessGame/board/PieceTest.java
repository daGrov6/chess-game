package com.cdp.chessGame.board;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cdp.chessGame.enums.PieceOwner;
import com.cdp.chessGame.enums.PieceType;

public class PieceTest {
	@Test
	public void testGettersAfterConstruct()
	{
		Piece piece = new Piece(PieceType.BISHOP, PieceOwner.BLACK);
		assertEquals(piece.getPieceType(), PieceType.BISHOP);
		assertEquals(piece.getOwner(), PieceOwner.BLACK);
	}
	
	@Test
	public void testSetters()
	{
		Piece piece = new Piece(PieceType.BISHOP, PieceOwner.BLACK);
		piece.setPieceType(PieceType.PAWN);
		piece.setOwner(PieceOwner.WHITE);
		assertEquals(piece.getPieceType(), PieceType.PAWN);
		assertEquals(piece.getOwner(), PieceOwner.WHITE);
	}
}
