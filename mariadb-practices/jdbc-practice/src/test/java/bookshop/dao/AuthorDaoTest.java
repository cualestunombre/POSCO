package bookshop.dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import bookshop.vo.AuthorVo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorDaoTest {
	
	private static AuthorDao authorDao = new AuthorDao();
	private static int count = 0;
	private static AuthorVo mockAuthorVo = new AuthorVo();
	
	
	@BeforeAll
	public static void setUp() {
		count = authorDao.findAll().size();
	
	}
	
	@Test
	@Order(1)
	public void testInsert() {
		mockAuthorVo.setName("칼세이건");
		long result = authorDao.insert(mockAuthorVo);
	
		
		// 직전 insert 삽입쿼리에 대해서 id를 찾아내야 한다
		assertNotNull(mockAuthorVo.getNo());
	}	
	
	@Test
	@Order(2)
	public void testFindAll() {
		assertEquals(count +1,authorDao.findAll().size());
	}
		
	
	@AfterAll
	public static void cleanUp() {
		authorDao.deleteByNo(mockAuthorVo.getNo());
		
	}

}
