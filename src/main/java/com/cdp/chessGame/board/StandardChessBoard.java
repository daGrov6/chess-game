package com.cdp.chessGame.board;

import com.cdp.chessGame.enums.IllegalMoveReason;
import com.cdp.chessGame.enums.PieceOwner;
import com.cdp.chessGame.enums.PieceType;
import com.cdp.chessGame.exceptions.IllegalMoveException;
import com.cdp.chessGame.interfaces.Move;

public class StandardChessBoard
{
	private Piece[][] squares; 
	public static PieceType[] STARTING_BACK_RANK = new PieceType[] { PieceType.ROOK, PieceType.KNIGHT, 
			PieceType.BISHOP, PieceType.QUEEN, PieceType.KING, PieceType.BISHOP, PieceType.KNIGHT, PieceType.ROOK }; 
	private static final String LINE_SEPARATOR = "-------------------------";

	// Board for starting a new game
	public StandardChessBoard()
	{
		squares = new Piece[8][8];

		for (int i = 0; i < 8; i++) {
			squares[0][i] = new Piece(STARTING_BACK_RANK[i], PieceOwner.WHITE);
			squares[7][i] = new Piece(STARTING_BACK_RANK[i], PieceOwner.BLACK);
		}
		
		for (int i = 0; i < 8; i++)
		{
			squares[1][i] =  new Piece(PieceType.PAWN, PieceOwner.WHITE);
			squares[6][i] = new Piece(PieceType.PAWN, PieceOwner.BLACK);
		}
		
		for (int i = 2; i < 6; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				squares[i][j] = null;
			}
		}
	}
	
	public String toDisplay() {
		StringBuilder sb = new StringBuilder();
		sb.append(LINE_SEPARATOR).append("\n");
		for (int i = 7; i >= 0; i--) 
		{
			sb.append("|");
			for (int j = 7; j >= 0; j--) 
			{
				Piece piece = squares[i][j];
				if (piece == null)
				{
					sb.append("--");
				}
				
				else
				{
					sb.append(piece.getOwner().toString()).append(piece.getPieceType().toString());
				}
				sb.append("|");
			}
			sb.append("\n").append(LINE_SEPARATOR).append("\n");
		}
		
		return sb.toString();
		
	}
	
	// TODO should probably remove this with introduction of BoardLocation
	public Piece getPiece(int row, int col) throws IllegalArgumentException {
		if (row < 0 || row > 7 || col < 0 || col > 7)
		{
			throw new IllegalArgumentException("Illegal row or column! Row: " + row + " Column: " + col);
		}
		return squares[row][col];
	}
	
	public Piece getPiece(BoardLocation location)
	{
		return getPiece(location.getRow(), location.getCol());
	}
	
	public String toString() {
		return squares.toString();
	}
	
	public void makeMove(Move move) throws IllegalMoveException
	{
		Piece movedPiece = getPiece(move.getFrom());
		
		if (movedPiece == null)
		{
			throw new IllegalMoveException(move, IllegalMoveReason.PIECE_NOT_IN_LOCATION);
		}
		
		if (!movedPiece.getOwner().equals(move.getPieceOwner()))
		{
			throw new IllegalMoveException(move, IllegalMoveReason.NOT_PIECE_OWNER);
		}
		
		squares[move.getTo().getRow()][move.getTo().getCol()] = movedPiece;
		squares[move.getFrom().getRow()][move.getFrom().getCol()] = null;
	}
}
