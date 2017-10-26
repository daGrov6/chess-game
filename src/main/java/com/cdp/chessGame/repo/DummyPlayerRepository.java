package com.cdp.chessGame.repo;

import java.util.List;

import com.cdp.chessGame.interfaces.Player;
import com.cdp.chessGame.interfaces.PlayerRepository;
import com.cdp.chessGame.player.ChessPlayer;


public class DummyPlayerRepository implements PlayerRepository {
	public Player getPlayer(String username) {
		return new ChessPlayer(username);
	}

	@Override
	public Player getPlayerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player createPlayer(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletePlayer(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updatePlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ChessPlayer> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}
}
