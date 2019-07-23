package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;
public class MemberService {
	
	public MemberService() {} // 기본생성자
	
	public Member loginMember(Member member) {
		Connection conn = getConnection();
		
		Member loginUser = new MemberDao().loginMember(conn, member);
		
		
		
		return loginUser;
	}

	
	public int insertMember(Member member) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
			
		return result;
	}

	public int idCheck(String userId) {
		Connection conn = getConnection();
		
		int result = new MemberDao().idCheck(conn, userId);
		
		return result;
	}

	public Member selectMember(String userId) {
		Connection conn = getConnection();
		
		Member member = new MemberDao().selectMember(conn, userId);
		
		return member;
	}

	public int updateMember(Member member) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}

	public int updatePwd(String userId, String userPwd, String newPwd) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updatePwd(conn, userId, userPwd, newPwd);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
}
