package com.cdp.chessGame.objects.games;

import com.cdp.chessGame.board.ChessBoardState;
import com.cdp.chessGame.enums.PieceOwner;
import com.cdp.chessGame.interfaces.ChessGame;
import com.cdp.chessGame.interfaces.Player;

//@Entity
//@Table(name = "CHESS_GAMES")
public abstract class AbstractChessGame implements ChessGame {
	private int id;
//	private int whiteId;
//	private int blackId;
	private Player white;
	private Player black;
	private int whiteInitRating;
	private int blackInitRating;
	protected ChessBoardState boardState;
	
	// Constructor for creating a brand new game
	public AbstractChessGame(Player white, Player black)
	{
		this.white = white;
		this.black = black;
//		this.whiteId = white.getId();
//		this.blackId = black.getId();
		
//		whiteInitRating = white.getRating();
//		blackInitRating = black.getRating();
	}
	
	public AbstractChessGame(int gameId, ChessBoardState state, Player white, Player black, int whiteInitRating, int blackInitRating)
	{
		boardState = state;
		this.white = white;
		this.black = black;
		this.whiteInitRating = whiteInitRating;
		this.blackInitRating = blackInitRating;
	}
	
	@Override
	public Player getWhite() {
		return white;
	}

	@Override
	public Player getBlack() {
		return black;
	}

	@Override
	public int getWhiteInitRating() {
		return whiteInitRating;
	}

	@Override
	public int getBlackInitRating() {
		return blackInitRating;
	}

	@Override
	public Player getCurrentTurnPlayer() {
		return boardState.getCurrentPlayersMove() == PieceOwner.WHITE ? white : black;
	}

	@Override
	public boolean isGameOver() {
		return boardState.isGameOver();
	}

	@Override
	public Player getWinner() {
		if (!isGameOver())
			return null;
		
		return Math.random() > 0.5 ? white : black;
	}

	public int getGameId() {
		return id;
	}

	public void setGameId(int id) {
		this.id = id;
	}

//	public int getWhiteId() {
//		return whiteId;
//	}
//
//	public void setWhiteId(int whiteId) {
//		this.whiteId = whiteId;
//	}
//
//	public int getBlackId() {
//		return blackId;
//	}
//
//	public void setBlackId(int blackId) {
//		this.blackId = blackId;
//	}
	
}
