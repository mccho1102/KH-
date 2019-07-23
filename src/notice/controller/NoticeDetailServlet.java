package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

@WebServlet("/detail.no")
public class NoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿼리스트링으로 전달된 글번호 저장
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		// NoticeService를 여러번 사용하기 위하여 미리 객체 생성
		NoticeService nService = new NoticeService();
		
		Notice notice = nService.selectNotice(nno);
		
		RequestDispatcher view = null;
		String page = "";
		// 조회 성공 시 조회 수를 증가 시키고 
		// view 연결 처리 
		
		if(notice != null) { // 해당 글이 존재하는 경우
			
			if(nService.increaseCount(nno) > 0) {
				page = "views/notice/noticeDetailView.jsp";
				request.setAttribute("notice", notice);
			}else { // 조회수 증가 실패시
				page = "views/common/errorPage.jsp";
				request.setAttribute("msg", "조회수 증가 중 에러 발생");
			}
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 상세조회중 에러발생");
		}
		
		view = request.getRequestDispatcher(page);
		view.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
