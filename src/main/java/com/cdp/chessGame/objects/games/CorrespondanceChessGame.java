package com.cdp.chessGame.objects.games;

import com.cdp.chessGame.board.ChessBoardState;
import com.cdp.chessGame.exceptions.IllegalMoveException;
import com.cdp.chessGame.interfaces.ChessGame;
import com.cdp.chessGame.interfaces.Move;
import com.cdp.chessGame.interfaces.Player;

public class CorrespondanceChessGame extends AbstractChessGame implements ChessGame 
{	
	public CorrespondanceChessGame(Player white, Player black)
	{
		super(white, black);
		
		boardState = new ChessBoardState();
	}
	
	public CorrespondanceChessGame(int id, ChessBoardState state, Player white, Player black, int whiteInitRating, int blackInitRating) {
		super(id, state, white, black, whiteInitRating, blackInitRating);
	}

	@Override
	public String getCurrentBoardStrRep() {
		return boardState.getBoard().toDisplay();
	}

	@Override
	public void makeMove(Move move) throws IllegalMoveException {
		boardState.makeMove(move);
	}
}
