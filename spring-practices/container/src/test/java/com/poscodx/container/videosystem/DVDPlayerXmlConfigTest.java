package com.poscodx.container.videosystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"classpath:com/poscodx/container/config/videosystem/applicationContext.xml"})
public class DVDPlayerXmlConfigTest {

	
	@Autowired
	@Qualifier("player")
	private DVDPlayer player;
	

	
	@Test
	public void testDVDPlayNotNull() {
		assertNotNull(player);
	}

	
	@Test
	public void testPlay() {
		// Playing Movie " + studio + "'s " + title
		assertEquals("Playing Movie Marvel's Avengers", player.play());
	}

}
