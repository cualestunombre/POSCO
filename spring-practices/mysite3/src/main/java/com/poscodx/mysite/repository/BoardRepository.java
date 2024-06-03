package com.poscodx.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.mysite.vo.GuestbookVo;

@Repository
public class BoardRepository {
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://192.168.64.8:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		
		return conn;
	}
	
	public void deleteByNo(Long no, Long userNo) {
		
		try (
			Connection conn = getConnection();	
			PreparedStatement pstmt = conn.prepareStatement("delete from board where no = ? and user_no = ?");
		){
			pstmt.setLong(1, no);
			pstmt.setLong(2, userNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		}
		

	}
	
	public Long getNextGNo() {
	    long nextGNo = 1;
	    
	    try (
	        Connection conn = getConnection();
	        PreparedStatement pstmt = conn.prepareStatement("select ifnull(max(g_no) + 1, 1) from board");
	    ) {
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            nextGNo = rs.getLong(1);
	        }
	        rs.close();
	    } catch (SQLException e) {
	        System.out.println("Error:" + e);
	    }
	    
	    return nextGNo;
	}
	
	public int getTotalBoardNo() {
	    int total = 0;
	    
	    try (
	        Connection conn = getConnection();
	        PreparedStatement pstmt = conn.prepareStatement("select count(*) from board");
	    ) {
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            total = rs.getInt(1);
	        }
	        rs.close();
	    } catch (SQLException e) {
	        System.out.println("Error:" + e);
	    }
	    
	    return total;
	}
	
	public List<BoardVo> findBoardsByPage(int page){
		List<BoardVo> result = new ArrayList<>();
		ResultSet rs = null;
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(
				"select b.no, b.title, b.contents, b.hit, date_format(b.reg_date, '%Y/%m/%d %H:%i:%s')," + 
				" b.g_no, b.o_no, b.depth, b.user_no, u.name" +
				"      from board b inner join user u on b.user_no = u.no" + 
				"  order by g_no desc, o_no asc limit ?, 5");
			
		) {
			pstmt.setInt(1, 5*(page-1));
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				int hit = rs.getInt(4);
				String regDate = rs.getNString(5);
				Long gno = rs.getLong(6);
				Long ono = rs.getLong(7);
				int depth = rs.getInt(8);
				Long userNo = rs.getLong(9);
				String name = rs.getString(10);
				
				
				BoardVo boardVo = new BoardVo();
				boardVo.setContents(contents);
				boardVo.setDepth(depth);
				boardVo.setGno(gno);
				boardVo.setHit(hit);
				boardVo.setName(name);
				boardVo.setNo(no);
				boardVo.setOno(ono);
				boardVo.setRegDate(regDate);
				boardVo.setTitle(title);
				boardVo.setUserNo(userNo);
				
				result.add(boardVo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			}catch(SQLException e) {
				System.out.println("Error:" + e);
			}
		}
		
		return result;
	}
	
	public List<BoardVo> findBoardsByPageAndKeyword(int page,String key){
		List<BoardVo> result = new ArrayList<>();
		ResultSet rs = null;
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(
				"select b.no, b.title, b.contents, b.hit, date_format(b.reg_date, '%Y/%m/%d %H:%i:%s')," + 
				" b.g_no, b.o_no, b.depth, b.user_no, u.name" +
				"      from board b inner join user u on b.user_no = u.no" + " where b.title like ?" +
				"  order by g_no desc, o_no asc limit ?, 5");
			
		) {
			pstmt.setInt(2, 5*(page-1));
			pstmt.setString(1, "%"+key+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				int hit = rs.getInt(4);
				String regDate = rs.getNString(5);
				Long gno = rs.getLong(6);
				Long ono = rs.getLong(7);
				int depth = rs.getInt(8);
				Long userNo = rs.getLong(9);
				String name = rs.getString(10);
				
				
				BoardVo boardVo = new BoardVo();
				boardVo.setContents(contents);
				boardVo.setDepth(depth);
				boardVo.setGno(gno);
				boardVo.setHit(hit);
				boardVo.setName(name);
				boardVo.setNo(no);
				boardVo.setOno(ono);
				boardVo.setRegDate(regDate);
				boardVo.setTitle(title);
				boardVo.setUserNo(userNo);
				
				result.add(boardVo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			}catch(SQLException e) {
				System.out.println("Error:" + e);
			}
		}
		
		return result;
	}
	
	public List<BoardVo> findBoardByNo(Long boardNo){
		List<BoardVo> result = new ArrayList<>();
		ResultSet rs = null;
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(
				"select b.no, b.title, b.contents, b.hit, date_format(b.reg_date, '%Y/%m/%d %H:%i:%s')," + 
				" b.g_no, b.o_no, b.depth, b.user_no, u.name" +
				"      from board b inner join user u on b.user_no = u.no" + 
				"  where b.no = ?");
			
		) {
			pstmt.setLong(1, boardNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				int hit = rs.getInt(4);
				String regDate = rs.getNString(5);
				Long gno = rs.getLong(6);
				Long ono = rs.getLong(7);
				int depth = rs.getInt(8);
				Long userNo = rs.getLong(9);
				String name = rs.getString(10);
				
				
				BoardVo boardVo = new BoardVo();
				boardVo.setContents(contents);
				boardVo.setDepth(depth);
				boardVo.setGno(gno);
				boardVo.setHit(hit);
				boardVo.setName(name);
				boardVo.setNo(no);
				boardVo.setOno(ono);
				boardVo.setRegDate(regDate);
				boardVo.setTitle(title);
				boardVo.setUserNo(userNo);
				
				result.add(boardVo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			}catch(SQLException e) {
				System.out.println("Error:" + e);
			}
		}
		
		return result;
	}
	
	
	
	
	public int insert(BoardVo vo) {
		int result = 0;
		
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt1 = conn.prepareStatement("insert into board values(null, ?, ?, ?, now(), ?,?,?,?)");
			PreparedStatement pstmt2 = conn.prepareStatement("select last_insert_id() from dual");
			) {
			
			pstmt1.setString(1, vo.getTitle());
			pstmt1.setString(2, vo.getContents());
			pstmt1.setInt(3, vo.getHit());
			pstmt1.setLong(4, vo.getGno());
			pstmt1.setLong(5, vo.getOno());
			pstmt1.setInt(6, vo.getDepth());
			pstmt1.setLong(7,vo.getUserNo());
			
			result = pstmt1.executeUpdate();

			ResultSet rs = pstmt2.executeQuery();
			vo.setNo(rs.next() ? rs.getLong(1) : null);
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		}
		
		return result;
	}

	public void update(Long boardNo, String title, String contents) {
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement("update board set title=?, contents=? where no=?");
			) {
		
					pstmt1.setString(1, title);
					pstmt1.setString(2, contents);
					pstmt1.setLong(3, boardNo);
					pstmt1.executeUpdate();
			
				
			} catch (SQLException e) {
				System.out.println("Error:" + e);
			}
			
		
	}

	public void updateForInsertReply(Long targetGno, Long targetOno) {
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement("update board set o_no=o_no+1 "
						+ " where g_no = ? and o_no  >= ?");
			) {
		
					pstmt1.setLong(1, targetGno);
					pstmt1.setLong(2, targetOno);
					pstmt1.executeUpdate();
			
				
			} catch (SQLException e) {
				System.out.println("Error:" + e);
			}
			
		
	}

	public void increaseHit(Long boardNo) {try (
			Connection conn = getConnection();
			PreparedStatement pstmt1 = conn.prepareStatement("update board set hit=hit+1 "
					+ " where no = ? ");
		) {
	
				pstmt1.setLong(1, boardNo);
				pstmt1.executeUpdate();
		
			
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		}
		
	}

	public int getTotalBoardAndKeywordNo(String key) {
		int total = 0;
	    
	    try (
	        Connection conn = getConnection();
	        PreparedStatement pstmt = conn.prepareStatement("select count(*) from board where title like ?");
	    ) {
	    	pstmt.setString(1, "%"+key+"%");
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            total = rs.getInt(1);
	        }
	        rs.close();
	    } catch (SQLException e) {
	        System.out.println("Error:" + e);
	    }
	    
	    return total;
		
	}
		
	

}
