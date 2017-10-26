package com.cdp.chessGame.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.cdp.chessGame.interfaces.Player;
import com.cdp.chessGame.interfaces.PlayerRepository;
import com.cdp.chessGame.player.ChessPlayer;

@Component
public class ChessPlayerRepository implements PlayerRepository 
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public Player getPlayerById(int id)
	{
		return entityManager.find(ChessPlayer.class, id);
	}

	@Override
	public Player createPlayer(String username) 
	{
		ChessPlayer player = new ChessPlayer(username);
		entityManager.persist(player);
		return player;
	}

	@Override
	public int deletePlayer(int id) 
	{
		entityManager.remove(getPlayerById(id));
		return 1;
	}

	@Override
	public void updatePlayer(Player player) 
	{
		if (player instanceof ChessPlayer)
		{
			entityManager.merge((ChessPlayer) player);
		}
	}

	@Override
	public List<ChessPlayer> getPlayers() {
		return entityManager.createQuery("select p from ChessPlayer p", ChessPlayer.class).getResultList();
	}

}
