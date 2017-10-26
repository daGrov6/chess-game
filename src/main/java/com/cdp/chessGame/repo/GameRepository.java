package com.cdp.chessGame.repo;

import org.springframework.stereotype.Component;

import com.cdp.chessGame.interfaces.ChessGame;
import com.cdp.chessGame.interfaces.Player;
import com.cdp.chessGame.objects.games.CorrespondanceChessGame;
import com.cdp.chessGame.player.ChessPlayer;

@Component
public class GameRepository {
	public ChessGame getGame(int gameId)
	{
		Player player1 = new ChessPlayer("Bob");
		Player player2 = new ChessPlayer("Chuck");
		return new CorrespondanceChessGame(gameId, null, player1, player2, 1500, 1500);
	}
}
