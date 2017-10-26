package com.cdp.chessGame.interfaces;

import com.cdp.chessGame.enums.GameType;

public interface NewGameFactory {
	public ChessGame createGame(Player player1, Player player2, GameType type);
}
