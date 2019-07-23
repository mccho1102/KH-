package notice.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

@WebServlet("/insert.no")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 문자 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Notice notice = new Notice(title, writer, content);
		
		int result = new NoticeService().insertNotice(notice);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "공지사항이 성공적으로 등록되었습니다.");
			response.sendRedirect(request.getContextPath()+"/list.no");
		}else {
			request.setAttribute("msg", "공지사항 등록 실패");
			RequestDispatcher view = request.getRequestDispatcher(
					"/views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
