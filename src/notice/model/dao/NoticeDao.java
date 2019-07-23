package notice.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import static common.JDBCTemplate.*;
import notice.model.vo.Notice;

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
	
}
