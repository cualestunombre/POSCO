package emaillist.dao;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmailistDaoTest {
	
	private static int count = 0;
	
	@BeforeAll
	public static void setUp() {
		System.out.println("test has just started...");
		List<EmaillistVo> list = new EmaillistDao().findAll();
		count = list.size();
		
	}
	
	@AfterAll
	public static void clear() {
		System.out.println("test has just ended...");
	}
	
	@Test
	@Order(1)
	public void testInsert() {
		EmaillistVo vo = new EmaillistVo("둘","리","1dilumn0@gmail.com");
		boolean result = new EmaillistDao().insert(vo);
		assertTrue(result);
		
	}
	
	@Test
	@Order(2)
	public void testFindAll() {
		List<EmaillistVo> list = new EmaillistDao().findAll();
		assertEquals(count + 1,list.size());
	}
	
	@Test
	@Order(3)
	public void testDeleteByEmail() {
		String email = "1dilumn0@gmail.com";
		boolean result = new EmaillistDao().delete(email);
		assertTrue(result);
	}
	
	
}
