package com.spring.clubAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.clubAPI.exception.PlayerException;
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
		return playerService.AllPlayers();
	}

	// http://localhost:8080/clubAPI/api/player?id=
	@GetMapping("/player")
	public Player player(@RequestParam int id) {
		Player player = playerService.getPlayer(id);
		if (player == null) {
			throw new PlayerException("id : " + id + " not founded!");
		}
		return player;
	}

	// http://localhost:8080/clubAPI/api/add-player
	@PostMapping("/add-player")
	public void addPlayer(@RequestBody Player player) {
		playerService.savePlayer(player);
	}

	// http://localhost:8080/clubAPI/api/add-player
	@PutMapping("/add-player") 
	public void updatePlayer(@RequestBody Player player) {
		playerService.savePlayer(player);
	}
//
//	@RequestMapping("/addNewPlayer")
//	public String signupNewUser(@Valid @ModelAttribute("playerData") Player player, BindingResult bindingResult,
//			Model model) {
//		System.out.println(bindingResult);
//		playerService.savePlayer(player);
//		// redirect to player list = calling addPlayer method
//		return "redirect:players-list";
//
//	}
//
//	@RequestMapping("/updatePlayer")
//	public String updatePlayer(Model model, @RequestParam("playerID") int id) {
//		Player player = playerService.getPlayer(id);
//		model.addAttribute("playerData", player);
//		return "add-player";
//	}
//
//	@RequestMapping("/deletePlayer")
//	public String deletePlayer(@RequestParam("playerID") int id) {
//		Player player = new Player();
//		player.setPlayerID(id);
//		playerService.deletePlayer(player);
//		return "redirect:players-list";
//	}
}
