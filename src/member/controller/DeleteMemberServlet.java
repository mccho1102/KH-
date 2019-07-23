package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;

@WebServlet("/delete.me")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteMemberServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int result = 0;
		
		if(result > 0) {
			//현재 session 객체를 받아옴
			// 매개 변수가 false인 경우 :
			// HttpSession이 존재하면 현재 HttpSessoin을 반환하고
			// 존재하지 않으면 새로이 생성하지 않고 그냥 null 반환
			
			// 매개변수가 true인 경우 :
			// HttpSession이 존재하면 현재 HttpSession을 반환하고 
			// 존재하지 않은 새로운 HttpSession을 생성하여 반환
			
			HttpSession session = request.getSession(false);
			
			if(session != null) {
				// 1) 로그인 세션 정보 삭제
				session.removeAttribute("loginUser");
				// 2) 세션 만료(무효화)
				// session.invalidate();
			}
			
			Cookie c = new Cookie("saveId", "");
			c.setMaxAge(0);	// 쿠키 만료(쿠키 생성 후 바로 삭제)
			c.setPath("/");
			response.addCookie(c);
			
			//page = "/index.jsp";
			session.setAttribute("msg", "회원탈퇴가 완료되었습니다.");
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("msg", "회원탈퇴에 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("view/common/errorpage.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
