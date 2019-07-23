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

@WebServlet("/update.me")
public class UpdateMemberservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMemberservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식 전송 -> 문자 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		String[] irr = request.getParameterValues("interest");
		
		String interest = ""; 
		
		if(irr != null) { // 관심분야에 checked된 값이 있을 경우
			interest = String.join(", ", irr);  
		}
		
		Member member = new Member(userId, userName, phone, email, address, interest);
		
		// DB로 수정을 위한 회원 정보 전달 후 결과값 반환 받기
		int result = new MemberService().updateMember(member);
		
		// DB 수행 결과에 따라 view 연결 처리
		if(result > 0) { // 회원 정보 수정 성공인 경우
			request.getSession().setAttribute("msg", "성공적으로 회원 정보를 수정하였습니다.");
			response.sendRedirect(request.getContextPath());
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			
			request.setAttribute("msg", "회원 정보수정에 실패했습니다.");
			view.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
