package com.poscodx.mysite.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import com.poscodx.mysite.repository.GuestbookLogRepositoryWithJdbcContext;
import com.poscodx.mysite.repository.GuestbookRepository;
import com.poscodx.mysite.repository.GuestbookRepositoryWithJdbcContext;
import com.poscodx.mysite.repository.GuestbookRepositoryWithJdbcTemplate;
import com.poscodx.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@Autowired
	private GuestbookRepositoryWithJdbcContext guestbookRepositoryWithJdbcContext;
	
	@Autowired
	private GuestbookRepositoryWithJdbcTemplate guestbookRepositoryWithJdbcTemplate;
	
	@Autowired
	private GuestbookLogRepositoryWithJdbcContext logRepository;
	
	@Autowired
	public GuestbookService(GuestbookRepository guestbookRepository) {
		this.guestbookRepository = guestbookRepository;
	}
	
	public List<GuestbookVo> getContentsList(){
		return  guestbookRepositoryWithJdbcContext.findAll();
	}
	
	public void deleteContents(Long no, String password) {
		// TX:BEGIN ////////////
		TransactionStatus status = null;
		try {
			status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
			logRepository.update(no);
			guestbookRepositoryWithJdbcContext.deleteByNoAndPassword(no, password);
			
			// TX:END(SUCESS) ////////////
			transactionManager.commit(status);
		
		} catch(RuntimeException e) {
			// TX:END(FAIL) ////////////
			transactionManager.rollback(status);
			e.printStackTrace();
		}
		
		
	}
	
	public void addContents(GuestbookVo vo) {
		System.out.println("check this out");
		TransactionSynchronizationManager.initSynchronization();
		// DataSourceUtils는 트랜잭션이 활성화 되어 있으면 활성 트랜잭션을, 그렇지 않으면 일반 커넥션을 가져온다
		Connection conn = DataSourceUtils.getConnection(dataSource);
		
		/*
		 *  보일러 플레이트는 트랜잭션 매니저로 추상화된다
		 */
		try { 
		
			// TX BEGIN
			conn.setAutoCommit(false);
			int count = logRepository.update();
			if (count == 0) {
				logRepository.insert();
			}
			guestbookRepositoryWithJdbcContext.insert(vo);
			conn.commit();

		}catch(Throwable e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException ignore) {
				ignore.printStackTrace();
			}
		} finally {
			DataSourceUtils.releaseConnection(conn, dataSource);
		}
	}
		
	public List<GuestbookVo> findAll() {
		return  guestbookRepositoryWithJdbcContext.findAll();
	}
}
