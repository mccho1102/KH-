package notice.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import static common.JDBCTemplate.*;
import notice.model.vo.Notice;

/**
 * @author user1
 *
 */
public class NoticeDao {
	
	private Properties prop = new Properties();
	
	public NoticeDao() {
		
		String fileName = Notice.class.getResource(
				"/sql/notice/notice-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
		/**
		 * 1. 공지사항 목록 조회용 DAO
		 * @param conn
		 * @return list
		 */
		public ArrayList<Notice> selectList(Connection conn){
			Statement stmt = null;
			ResultSet rset = null;
			ArrayList<Notice> list = null;
			
			String query = prop.getProperty("selectList");
			
			try {
				stmt = conn.createStatement();
				
				rset = stmt.executeQuery(query);
				
				list = new ArrayList<Notice>();
				
				while(rset.next()) {
					Notice no = new Notice(rset.getInt("NNO"), rset.getString("NTITLE"), 
							rset.getString("NCONTENT"), rset.getString("NWRITER"), 
							rset.getInt("NCOUNT"), rset.getDate("NDATE"));
					list.add(no);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(stmt);
			}
		
		return list;
	}


		public int insertNotice(Connection conn, Notice notice) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			String query = prop.getProperty("insertNotice");
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, notice.getnTitle());
				pstmt.setString(2, notice.getnContent());
				pstmt.setString(3, notice.getnWriter());
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}


		/**
		 * 3. 공지사항 상세 조회용 DAO
		 * @param conn
		 * @param nno
		 * @return notice
		 */
		public Notice selectNotice(Connection conn, int nno) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			Notice notice = null;
			
			String query = prop.getProperty("selectNotice");
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, nno);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					notice = new Notice(rset.getInt("NNO"),
										rset.getString("NTITLE"),
										rset.getString("NCONTENT"),
										rset.getString("NWRITER"),
										rset.getInt("NCOUNT"),
										rset.getDate("NDATE")
										);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return notice;
		}


		/**
		 * 4. 조회 수 증가용 DAO
		 * @param conn
		 * @param nno
		 * @return
		 */
		public int increaseCount(Connection conn, int nno) {
			PreparedStatement pstmt = null;
			
			int result = 0;
			
			String query = prop.getProperty("increaseCount");
			
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1, nno);
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			
			return result;
		}


		
	
	
}
