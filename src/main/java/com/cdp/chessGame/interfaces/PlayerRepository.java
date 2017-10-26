package com.cdp.chessGame.interfaces;

import java.util.List;

import com.cdp.chessGame.player.ChessPlayer;

public interface PlayerRepository {
	public List<ChessPlayer> getPlayers();
	public Player getPlayerById(int id);
	public Player createPlayer(String username);
	public int deletePlayer(int id);
	public void updatePlayer(Player player);
}
