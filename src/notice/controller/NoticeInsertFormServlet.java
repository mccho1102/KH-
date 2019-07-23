package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertForm.no")
public class NoticeInsertFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeInsertFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 화면 전환 시 파일경로로 표시되는 url을 servlet을 매핑 url로 표시하는 servlet
		
		RequestDispatcher view = request.getRequestDispatcher(
				"views/notice/noticeInsertForm.jsp");
		
	view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
