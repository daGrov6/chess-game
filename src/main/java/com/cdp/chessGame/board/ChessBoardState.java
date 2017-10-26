package com.cdp.chessGame.board;

import java.util.ArrayList;
import java.util.List;

import com.cdp.chessGame.enums.IllegalMoveReason;
import com.cdp.chessGame.enums.PieceOwner;
import com.cdp.chessGame.enums.PieceType;
import com.cdp.chessGame.exceptions.IllegalMoveException;
import com.cdp.chessGame.interfaces.Move;

public class ChessBoardState
{
	private PieceOwner currentPlayersMove;
	private StandardChessBoard board;
	private List<Move> moves;
	
	public ChessBoardState()
	{
		board = new StandardChessBoard();
		currentPlayersMove = PieceOwner.WHITE;
	}
	
	public PieceOwner getCurrentPlayersMove() 
	{
		return currentPlayersMove;
	}

	public void makeMove(Move move) throws IllegalMoveException 
	{
		// Validate move is allowed
		if (!currentPlayersMove.equals(move.getPieceOwner()))
		{
			throw new IllegalMoveException(move, IllegalMoveReason.WRONG_PLAYER);
		}
		
		checkMoveAllowed(move);
		
		// Update board
		board.makeMove(move);
		
		moves.add(move);
		
		// Update to be next player's move
		currentPlayersMove = currentPlayersMove == PieceOwner.WHITE ? PieceOwner.BLACK : PieceOwner.WHITE;
	}

	private void checkMoveAllowed(Move move) throws IllegalMoveException 
	{
		Piece piece = getBoard().getPiece(move.getFrom());
		if (piece == null || piece.getOwner() != move.getPieceOwner() 
				|| piece.getPieceType() != move.getPieceType())
		{
			throw new IllegalMoveException(move, IllegalMoveReason.PIECE_NOT_IN_LOCATION);
		}
		
		// Is the destination valid for this piece type
		checkDestination(move);
		
		// Can't make a move that ends with you in check
		if (isInCheck(currentPlayersMove))
		{
			throw new IllegalMoveException(move, IllegalMoveReason.MOVING_INTO_CHECK);
		}
	}

	private boolean isInCheck(PieceOwner player) 
	{
		return false;
	}

	private void checkDestination(Move move) 
	{
		if (!getCandidateDestinations(move.getPieceType(), move.getPieceOwner(), move.getFrom()).contains(move.getTo()))
		{
			
		}
	}
	
	private List<BoardLocation> getCandidateDestinations(PieceType piece, PieceOwner owner,
			BoardLocation from)
	{
		List<BoardLocation> locations = new ArrayList<BoardLocation>();
		switch (piece)
		{
		case PAWN:
			int direction = owner.equals(PieceOwner.WHITE) ? 1 : -1;
			BoardLocation oneInFront = new BoardLocation(from.getRow() + (direction),
					from.getCol());
			if (getBoard().getPiece(oneInFront) == null)
			{
				locations.add(oneInFront);
				
				// Only want to check for possibility of two square move if square in front is empty
				// Can only move two if pawn hasn't moved yet
				if (from.getRow() == (owner.equals(PieceOwner.WHITE) ? 1 : 6))
				{
					BoardLocation twoInFront = new BoardLocation(from.getRow() + (2 * direction),
							from.getCol());
					if (getBoard().getPiece(twoInFront) == null)
					{
						locations.add(twoInFront);
					}
				}
			}
			break;
		case BISHOP:
			break;
		case KING:
			break;
		case KNIGHT:
			break;
		case QUEEN:
			break;
		case ROOK:
			break;
		default:
			break;
			 
		}
		
		return locations;
	}

	public StandardChessBoard getBoard() 
	{
		return board;
	}

	public boolean isGameOver() {
		return false;
	}
}
