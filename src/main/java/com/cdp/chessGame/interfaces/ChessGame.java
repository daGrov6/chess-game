package com.cdp.chessGame.interfaces;

import com.cdp.chessGame.exceptions.IllegalMoveException;

public interface ChessGame {
	public int getGameId();
	public Player getWhite();
	public Player getBlack();
	public int getWhiteInitRating();
	public int getBlackInitRating();
	public Player getCurrentTurnPlayer();
	public String getCurrentBoardStrRep();
	
	public boolean isGameOver();
	public Player getWinner();
	
	public void makeMove(Move move) throws IllegalMoveException;
}
