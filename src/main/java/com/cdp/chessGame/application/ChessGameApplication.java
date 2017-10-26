package com.cdp.chessGame.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cdp.chessGame.interfaces.PlayerRepository;

@SpringBootApplication
public class ChessGameApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ChessGameConfiguration.class);
		
		PlayerRepository repo = context.getBean(PlayerRepository.class);
		
		System.out.println(repo.getPlayers());
//		Player player1 = repo.getPlayerById(1);
//		System.out.println("Got player 1 with username " + player1.getName());
//		Player player2 = repo.getPlayerById(2);
//		System.out.println("Got player 2 with username " + player2.getName());
		
//		NewGameFactory gameFactory = context.getBean(NewGameFactory.class);
//		ChessGame game = gameFactory.createGame(player1, player2, GameType.CORRESPONDANCE);
//		
//		System.out.println(game.getCurrentBoardStrRep());
//		
//		BoardLocation from = new BoardLocation(1, 3);
//		BoardLocation to = new BoardLocation(3, 3);
//		Move move = new ChessMove(PieceOwner.WHITE, PieceType.PAWN, from, to);
//		
//		try {
//			game.makeMove(move);
//		}
//		catch (IllegalMoveException e) {
//			
//		}
//		
//		System.out.println(game.getCurrentBoardStrRep());
				
		context.close();
	}
}
