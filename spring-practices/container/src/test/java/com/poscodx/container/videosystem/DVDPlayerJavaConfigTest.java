package com.poscodx.container.videosystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.poscodx.container.config.videosystem.DVDPlayerConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {DVDPlayerConfig.class})
public class DVDPlayerJavaConfigTest {
	
	// 같은 타입의 빈이 두개 이상 있는 경우
	// 설정 클래스의 빈생성 메소드의 @Bean의 name을 qualifier로 넣어줘야 한다
	@Autowired
	@Qualifier("dvdPlayer2")
	private DVDPlayer player02;
	
	@Autowired
	@Qualifier("dvdPlayer1")
	private DVDPlayer player01;
	
	@Autowired
	@Qualifier("dvdPlayer3")
	private DVDPlayer player03;
	
	@Test
	public void testDVDPlay01NotNull() {
		assertNotNull(player01);
	}
	
	@Test
	public void testDVDPlay02NotNull() {
		assertNotNull(player02);
	}
	
	@Test
	public void testDVDPlay03NotNull() {
		assertNotNull(player03);
	}
	
	@Test
	public void testPlay01() {
		// Playing Movie " + studio + "'s " + title
		assertEquals("Playing Movie Marvel's Avengers", player01.play());
	}
	
	@Test
	public void testPlay02() {
		// Playing Movie " + studio + "'s " + title
		assertEquals("Playing Movie Marvel's Avengers", player02.play());
	}
	
	@Test
	public void testPlay03() {
		// Playing Movie " + studio + "'s " + title
		assertEquals("Playing Movie Marvel's Avengers", player03.play());
	}
}
