package com.spring.clubAPI.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.clubAPI.model.Player;


@Repository
public class PlayerDaoImpl implements PlayerDAO {

	
	@Autowired
	private SessionFactory factory ;
	
	@Override
	public List<Player> getAllPlayers() {
		System.out.println("from DAO : ");
		Session session = factory.getCurrentSession();
		Query<Player> query= session.createQuery("from Player",Player.class);
		System.out.println("from DAO : "+query.getResultList().get(0).getPlayerName());
		return query.getResultList();
	}

	@Override
	public void addPlayer(Player player) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(player);
		
	}

	@Override
	public Player getPlayer(int id) {
		Session session = factory.getCurrentSession();
		return session.get(Player.class, id);
	}

	@Override
	public void deletePlayer(Player player) {
		Session session = factory.getCurrentSession();
		session.delete(player);
	}
	
}