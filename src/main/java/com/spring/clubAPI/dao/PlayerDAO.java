package com.spring.clubAPI.dao;

import java.util.List;

import com.spring.clubAPI.model.Player;



public interface PlayerDAO {
	

	public List<Player> getAllPlayers();
	public void addPlayer(Player player);
	public Player getPlayer(int id);
	public void deletePlayer(Player player);
}
