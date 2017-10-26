package com.cdp.chessGame.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cdp.chessGame.enums.PieceOwner;
import com.cdp.chessGame.enums.PieceType;
import com.cdp.chessGame.exceptions.IllegalMoveException;
import com.cdp.chessGame.interfaces.Move;

public class StandardChessBoardTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private StandardChessBoard board;
	
	@Before
	public void setupBoard() {
		board = new StandardChessBoard();
	}
	
	@Test
	public void testNegativeGetRowBelow()
	{
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Illegal row or column! Row: -1 Column: 5");
		board.getPiece(-1, 5);
	}
	
	@Test
	public void testNegativeGetRowAbove()
	{
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Illegal row or column! Row: 8 Column: 5");
		board.getPiece(8, 5);
	}
	
	@Test
	public void testNegativeGetColBelow()
	{
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Illegal row or column! Row: 5 Column: -1");
		board.getPiece(5, -1);
	}

	@Test
	public void testNegativeGetColAbove()
	{
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Illegal row or column! Row: 5 Column: 8");
		board.getPiece(5, 8);
	}

	@Test
	public void testInitialBoardConfiguration() 
	{
		for (int c = 0; c < 8; c++) 
		{
			assertEquals(board.getPiece(0, c), new Piece(StandardChessBoard.STARTING_BACK_RANK[c], PieceOwner.WHITE));
			assertEquals(board.getPiece(7, c), new Piece(StandardChessBoard.STARTING_BACK_RANK[c], PieceOwner.BLACK));
			assertEquals(board.getPiece(1, c), new Piece(PieceType.PAWN, PieceOwner.WHITE));
			assertEquals(board.getPiece(6, c), new Piece(PieceType.PAWN, PieceOwner.BLACK));

			for (int r = 2; r < 6; r++) 
			{
				assertNull(board.getPiece(r, c));
			}
		}
	}
	
	@Test
	public void testFirstMove() throws IllegalMoveException
	{
		BoardLocation from = new BoardLocation(1, 3);
		BoardLocation to = new BoardLocation(3, 5);
		Move move = new ChessMove(PieceOwner.WHITE, PieceType.PAWN, from, to);
		
		board.makeMove(move);
		
		assertNull(board.getPiece(from));
		assertEquals(board.getPiece(to), new Piece(PieceType.PAWN, PieceOwner.WHITE));
	}
}
