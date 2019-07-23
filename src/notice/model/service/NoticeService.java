package notice.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

/**
 * @author user1
 *
 */
/**
 * @author user1
 *
 */
public class NoticeService {

	/**
	 * 1. 공지사항 목록 조회용 Service
	 * @return list:ArrayList
	 */
	public ArrayList<Notice> selectList() {
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectList(conn);
		
		return list;
	}

	public int insertNotice(Notice notice) {
	
		Connection conn = getConnection();
		
		int result = new NoticeDao().insertNotice(conn, notice);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	
	/** 공지사항 상세 조회용
	 * 
	 * @param nno
	 * @return 
	 */
	public Notice selectNotice(int nno) {

		Connection conn = getConnection();
		
		Notice notice = new NoticeDao().selectNotice(conn, nno);
		
		return notice;
	}
	
	/**
	 * 4. 조회수 증가용 Service
	 * @param nno
	 * @return result
	 */
	public int increaseCount(int nno) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().increaseCount(conn, nno);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	
}



















