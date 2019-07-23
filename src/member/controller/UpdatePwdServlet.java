package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/updatePwd.me")
public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatePwdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		String userPwd = request.getParameter("userPwd");
		String newPwd = request.getParameter("newPwd");
		
		int result = new MemberService().updatePwd(userId, userPwd, newPwd);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "비밀번호 변경에 성공하였습니다.");
			
			response.sendRedirect(request.getContextPath());
		}else {
			request.getSession().setAttribute("msg", "현재 비밀번호가 잘못되었습니다.");
			
			response.sendRedirect(request.getContextPath() + "/views/member/pwdupdateForm.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
