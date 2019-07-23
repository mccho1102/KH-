package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/insert.me")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 한글이 있을 경우 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		// 2. 전달된 값을 꺼내서 변수에 저장
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] irr = request.getParameterValues("interest");
		String interest = String.join(", ", irr);
		
		// 3. 저장한 값을 가지고 Member 객체 생성
		Member member = new Member(userId, userPwd, userName, phone, email,
										address, interest);
		
		// 4. 비즈니스 로직을 수행할 Service의 메소드를 호출하고 결과 값 반환 받기
		int result = new MemberService().insertMember(member);
		
		//5. 결과값에 따라 view 연결 처리
		if(result > 0) {
			request.getSession().setAttribute("msg", userName + "님 환영합니다.");
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("msg", "회원 가입 실패");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
