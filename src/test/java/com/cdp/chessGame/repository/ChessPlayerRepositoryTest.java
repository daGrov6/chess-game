package com.cdp.chessGame.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hamcrest.Matchers;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cdp.chessGame.application.ChessGameConfiguration;
import com.cdp.chessGame.interfaces.Player;
import com.cdp.chessGame.player.ChessPlayer;
import com.cdp.chessGame.repo.ChessPlayerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ChessGameConfiguration.class)
@Transactional
public class ChessPlayerRepositoryTest 
{
	@Autowired
	private ChessPlayerRepository repository;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testInitialLoad()
	{
		List<ChessPlayer> players = repository.getPlayers();

		assertEquals(players.size(), 4);
		assertEquals(players.get(0).getName(), "magnus");
		assertEquals(players.get(1).getName(), "nakamura");
		assertEquals(players.get(2).getName(), "williams");
		assertEquals(players.get(3).getName(), "hansen");
	}
	
	@Test
	public void testAddPlayer()
	{
		int origCount = repository.getPlayers().size();
		
		Player createdPlayer = repository.createPlayer("cpotter");
		
		assertNotNull(createdPlayer);
		assertNotNull(createdPlayer.getId());
		
		Player dbPlayer = repository.getPlayerById(createdPlayer.getId());
		assertEquals(dbPlayer.getName(), "cpotter");
		assertEquals(repository.getPlayers().size(), origCount + 1);
	}
	
	@Test
	public void testDeletePlayer()
	{
		assertNotNull(repository.getPlayerById(1));
		
		repository.deletePlayer(1);
		
		assertNull(repository.getPlayerById(1));
	}
	
	@Test
	public void testUpdatePlayer()
	{  	
		String updatedUsername = "magnusUpd";
		
		repository.updatePlayer(new ChessPlayer(1, updatedUsername));
		
		assertEquals(repository.getPlayerById(1).getName(), updatedUsername);
	}
	
	@Test
	public void testNegativeDeleteNonexistingPlayer()
	{
		thrown.expect(IllegalArgumentException.class);
		repository.deletePlayer(-1);
	}
	
	@Test
	public void testNegativeAddExistingPlayer()
	{
		thrown.expect(PersistenceException.class);
		thrown.expectCause(Matchers.isA(ConstraintViolationException.class));
		repository.createPlayer("magnus");
	}

}
