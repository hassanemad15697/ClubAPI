package com.spring.clubAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.clubAPI.model.Player;
import com.spring.clubAPI.service.PlayerService;

@RestController
@RequestMapping("/api")
public class PlayerController {
	@Autowired
	private PlayerService playerService;

	@GetMapping("/data")
	// http://localhost:8080/clubAPI/api/data
	public String getData() {
		return "mydata";
	}

	// http://localhost:8080/clubAPI/api/players
	@GetMapping("/players")
	public List<Player> players() {
		System.out.println("in contrller at /players :: ");
		List<Player> players = playerService.AllPlayers();
		return players;
	}
}
