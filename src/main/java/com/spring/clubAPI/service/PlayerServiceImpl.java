package com.spring.clubAPI.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.clubAPI.dao.PlayerDAO;
import com.spring.clubAPI.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDAO playerDAO;

	@Override
	@Transactional
	public List<Player> AllPlayers() {
		System.out.println("PlayerServiceImpl");
		return playerDAO.getAllPlayers();
	}

	@Override
	@Transactional
	public void savePlayer(Player player) {
		playerDAO.addPlayer(player);
	}

	@Override
	@Transactional
	public Player getPlayer(int id) {
		return playerDAO.getPlayer(id);
	}

	@Override
	@Transactional
	public void deletePlayer(Player player) {
		playerDAO.deletePlayer(player);
	}


}
