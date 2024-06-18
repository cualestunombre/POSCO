package com.poscodx.container.videosystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DVDPlayer {
	

	@Autowired
	public DVDPlayer(@Qualifier("ironMan") DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
	
	public DVDPlayer() {
		
	}
	public void setDisc(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
	
	private DigitalVideoDisc dvd;
	
	public String play() {
		return dvd.play();
	}
}
 