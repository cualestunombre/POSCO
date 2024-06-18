package com.poscodx.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poscodx.container.videosystem.Avengers;
import com.poscodx.container.videosystem.DVDPlayer;
import com.poscodx.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {
	
	@Bean
	public DigitalVideoDisc avengers() {
		return new Avengers();
	}
	
	// 주입 1.
	@Bean
	public DVDPlayer dvdPlayer1() {
		return new DVDPlayer(avengers());
	}
	
	// 주입 2.
	@Bean
	public DVDPlayer dvdPlayer2(DigitalVideoDisc disc) {
		return new DVDPlayer(disc);
	}
	
	// 주입 3.
	@Bean
	public DVDPlayer dvdPlayer3(DigitalVideoDisc disc) {
		DVDPlayer player = new DVDPlayer();
		player.setDisc(disc);
		return player;
		
	}
}
