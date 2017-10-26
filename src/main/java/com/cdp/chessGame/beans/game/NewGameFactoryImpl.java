package com.cdp.chessGame.beans.game;

import org.springframework.stereotype.Component;

import com.cdp.chessGame.enums.GameType;
import com.cdp.chessGame.interfaces.ChessGame;
import com.cdp.chessGame.interfaces.NewGameFactory;
import com.cdp.chessGame.interfaces.Player;
import com.cdp.chessGame.objects.games.CorrespondanceChessGame;

@Component("NewGameFactory")
public class NewGameFactoryImpl implements NewGameFactory {

	@Override
	public ChessGame createGame(Player player1, Player player2, GameType type) throws IllegalArgumentException {
		switch (type){
			case CORRESPONDANCE:
				return new CorrespondanceChessGame(player1, player2);
				
			default:
				throw new IllegalArgumentException("Unknown game type");
		}
//		if (GameType.CORRESPONDANCE.equals(type)) {
//			return new CorrespondanceGame(player1, player2);
//		}
//		
//		throw new IllegalArgumentException("Unknown game type");
	}

}
