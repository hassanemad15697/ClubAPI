package com.spring.clubAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	// http://localhost:8080/clubAPI/api/player
	@PostMapping("/player")
	public String addPlayer(@RequestBody Player player) {
		playerService.savePlayer(player);
		return "Added Successfuly";
	}

	// http://localhost:8080/clubAPI/api/player
	@PutMapping("/player")
	public String updatePlayer(@RequestBody Player player) {
		System.out.println(player.getPlayerID());
		if (playerService.getPlayer(player.getPlayerID()) == null) {
			throw new PlayerException("id : " + player.getPlayerID() + " not founded!");
		}
		playerService.savePlayer(player);
		return "Updated Successfuly";
	}

	// http://localhost:8080/clubAPI/api/player
	@DeleteMapping("/player")
	public String deletePlayer(@RequestBody Player player) {
		System.out.println(player.getPlayerID());
		if (playerService.getPlayer(player.getPlayerID()) == null) {
			throw new PlayerException("id : " + player.getPlayerID() + " not founded!");
		}
		playerService.deletePlayer(player);
		return "Deleted Successfuly";
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
