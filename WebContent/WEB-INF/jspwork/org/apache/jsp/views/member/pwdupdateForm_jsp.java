/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-07-22 06:53:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;

public final class pwdupdateForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/member/../common/menubar.jsp", Long.valueOf(1563767294897L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<style>\r\n");
      out.write("\t.outer{\r\n");
      out.write("\t\twidth:600px;\r\n");
      out.write("\t\theight:500px;\r\n");
      out.write("\t\tbackground:black;\r\n");
      out.write("\t\tcolor:white;\r\n");
      out.write("\t\tmargin-left:auto;\r\n");
      out.write("\t\tmargin-right:auto;\r\n");
      out.write("\t\tmargin-top:50px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.outer label, .outer td{\r\n");
      out.write("\t\tcolor:white;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tinput{\r\n");
      out.write("\t\tmargin-top:2px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#updatePwdBtn, #cancelBtn {\r\n");
      out.write("\t\tbackground:orangered;\r\n");
      out.write("\t\tborder-radius:5px;\r\n");
      out.write("\t\twidth:auto;\r\n");
      out.write("\t\theight:25px;\r\n");
      out.write("\t\tpadding:0px 5px;\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#updatePwdBtn:hover, #cancelBtn:hover{\r\n");
      out.write("\t\tcursor:pointer;\r\n");
      out.write("\t}\r\n");
      out.write("\ttd {\r\n");
      out.write("\t\ttext-align:right;\r\n");
      out.write("\t}\r\n");
      out.write("\t#updatePwdBtn{\r\n");
      out.write("\t\tbackground:yellowgreen;\r\n");
      out.write("\t}\r\n");
      out.write("\t#updatePwdBtn, #cancelBtn {\r\n");
      out.write("\t\tdisplay:inline-block;\r\n");
      out.write("\t}\r\n");
      out.write("</style>s\r\n");
      out.write("<title>비밀번호 변경</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");


	// session 객체에 담겨진 loginUser 정보를 저장해두기
	Member loginUser = (Member)session.getAttribute("loginUser");
	System.out.println(loginUser);

	// 회원가입 성공 시 메세지 출력	
	String msg = (String)session.getAttribute("msg");
	

	/********** 3. 아이디 저장 처리 (Cookie) ************/
	
	// 세션은 서버가 생성 및 관리
	// 쿠키는 서버가 생성하고 / 브라우저가 관리
	
	// 쿠키는 최대 4KB 
	
	/*
		순서
		1) 로그인 시 아이디 저장 saveId 체크박스의
			체크 여부에 따라 서버에서 쿠키 생성
			쿠키 key=saveid , value=userid
		
		2) response 객체에 setCookie 메소드를 이용하여 
			쿠키 객체 전달(브라우저가 해당 쿠키 관리)
			
		3) 다음 요청 때 이 쿠키를 함께 서버로 전송함.
		4) 서버가 로그인 페이지를 생성할 때 전송된 쿠키 배열객체에서
			saveId 라는 쿠키가 있다면 그 value를 id 입력상자에 입력
			아이디 저장 체크박스를 check함
		5) 
	*/
	
	// 아이디 저장 체크박스 값을 수정하기 위한 변수
	boolean saveId = false; 

	// 쿠키에 저장된 아이디를 저장할 변수
	String userIdSaved = "";
	
	Cookie[] cookies = request.getCookies();
	
	// 아이디 저장 체크박스
	// 아이디 저장을 체크하지 않으면 서버 첫 시작 시 request.getCookies() 값이 null 이므로
	// 조건없이 바로 접근하면 NullPointerException이 발생한다.
	// -> if문으로 null여부 체크
	if(cookies != null){
		for(Cookie ck : cookies){
			if(ck.getName().equals("saveId")){
				userIdSaved = ck.getValue();
				saveId = true;
			}
		}
	}
	

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("\tbody{\r\n");
      out.write("\t\tbackground:url('");
      out.print(request.getContextPath() );
      out.write("/images/a1.jpg') no-repeat;\r\n");
      out.write("\t\tcolor : white;\r\n");
      out.write("\t\tbackground-size : 100%;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t#loginBtn input, #memberJoinBtn, #logoutBtn, #myPage{\r\n");
      out.write("\t\tdisplay:inline-block;\r\n");
      out.write("\t\tverticla-align:middle;\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t\tbackground:orangered;\r\n");
      out.write("\t\tcolor:white;\r\n");
      out.write("\t\theight:25px;\r\n");
      out.write("\t\twidth:100px;\r\n");
      out.write("\t\tborder-radius:5px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#memberJoinBtn {\r\n");
      out.write("\t\tbackground:yellowgreen;\r\n");
      out.write("\t}\r\n");
      out.write("\t#loginBtn:hover, #changeInfo:hover, #logoutBtn:hover, #memberJoinBtn:hover, #myPage:hover{\r\n");
      out.write("\t\tcursor:pointer;\r\n");
      out.write("\t}\r\n");
      out.write("\t.loginArea > form, #userInfo {\r\n");
      out.write("\t\tfloat:right;\r\n");
      out.write("\t}\r\n");
      out.write("\t#logout, #myPage {\r\n");
      out.write("\t\tbackground:orangered;\r\n");
      out.write("\t\tcolor:white;\r\n");
      out.write("\t\ttext-decoration:none;\r\n");
      out.write("\t\tborder-radius:5px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#myPage {\r\n");
      out.write("\t\tbackground:yellowgreen;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.wrap {\r\n");
      out.write("\t\tbackground:black;\r\n");
      out.write("\t\twidth:100%;\r\n");
      out.write("\t\theight:50px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.menu {\r\n");
      out.write("\t\tbackground:black;\r\n");
      out.write("\t\tcolor:white;\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t\tvertical-align:middle;\r\n");
      out.write("\t\twidth:150px;\r\n");
      out.write("\t\theight:50px;\r\n");
      out.write("\t\tdisplay:table-cell;\r\n");
      out.write("\t}\r\n");
      out.write("\t.nav {\r\n");
      out.write("\t\twidth:600px;\r\n");
      out.write("\t\tmargin-left:auto;\r\n");
      out.write("\t\tmargin-right:auto;\r\n");
      out.write("\t}\r\n");
      out.write("\t.menu:hover {\r\n");
      out.write("\t\tbackground:darkgray;\r\n");
      out.write("\t\tcolor:orangered;\r\n");
      out.write("\t\tfont-weight:bold;\r\n");
      out.write("\t\tcursor:pointer;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("\t\r\n");
      out.write("\t// 회원가입 성공시 alert 출력\r\n");
      out.write("\tvar msg = \"");
      out.print( msg );
      out.write("\";\r\n");
      out.write("\t\r\n");
      out.write("\t\tif(msg != \"null\"){ // msg 값이 있을 경우\r\n");
      out.write("\t\t\talert(msg);\r\n");
      out.write("\t\t");
 session.removeAttribute("msg"); 
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1 align=\"center\">KH정보교육원 조신진님의 교육</h1>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- -------------------1. 회원 관련 서비스------------------------ --> >\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"loginArea\">\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 2. 로그인 여부에 따라 화면 변경 -->\r\n");
      out.write("\t<!-- 2.1 로그인이 되어있는 경우 / 안되어있는 경우에 따라 화면이 달라야 하기 때문에\r\n");
      out.write("\t\tif문을 이용하여 session의 값을 검사 -> session 값 유무에 따라 화면 변경\r\n");
      out.write("\t\t->> 페이지 제일 상단에 session값을 저장해놓을 변수 선언.\r\n");
      out.write("\t -->\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 2.2  로그인이 되어있지 않은 경우 -->\r\n");
      out.write("\t");
 if(loginUser == null){ 
      out.write("\r\n");
      out.write("\t\t<!-- 1.1 로그인 관련 폼 만들기 -->\r\n");
      out.write("\t\t<form id=\"loginForm\" method=\"POST\" \r\n");
      out.write("\t\taction=\"");
      out.print( request.getContextPath() );
      out.write("/login.me\"\r\n");
      out.write("\t\tonsubmit=\"return validate();\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>ID : </td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"userId\" id=\"userId\" value=\"");
      out.print( saveId ? userIdSaved : "" );
      out.write("\">\r\n");
      out.write("\t\t\t\t</td>\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>PW : </td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" name=\"userPwd\" id=\"userPwd\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"2\"><input type=\"checkbox\" name=\"saveId\" id=\"saveId\" ");
      out.print( saveId ? "checked" : "" );
      out.write(">&nbsp;\r\n");
      out.write("\t\t\t\t\t<label for=\"saveId\">아이디 저장</label></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<div class=\"btns\" align=\"center\">\r\n");
      out.write("\t\t\t<div id=\"memberJoinBtn\" onclick=\"memberJoin();\">회원가입</div>\r\n");
      out.write("\t\t\t<div id=\"loginBtn\"><input type=\"submit\" value=\"로그인\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t<div id=\"userInfo\">\r\n");
      out.write("\t\t\t<label>");
      out.print( loginUser.getUserName() );
      out.write("님 로그인되셨습니다.</label>\r\n");
      out.write("\t\t\t<div class=\"btns\" align=\"right\">\r\n");
      out.write("\t\t\t\t<div id=\"myPage\" onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/myPage.me'\">\r\n");
      out.write("\t\t\t\t정보수정</div>\r\n");
      out.write("\t\t\t\t<div id=\"logoutBtn\" onclick=\"logout();\">로그아웃</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t// 1.2 로그인 유효성 검사\r\n");
      out.write("\t\tfunction validate(){\r\n");
      out.write("\t\t\tif($(\"#userId\").val().trim().length == 0){\r\n");
      out.write("\t\t\t\talert(\"아이디를 입력하세요\");\r\n");
      out.write("\t\t\t\t$(\"#userId\").focus();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif($(\"#userPwd\").val().trim().length == 0){\r\n");
      out.write("\t\t\t\talert(\"비밀번호를 입력해주세요\");\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#userPwd\").focus();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t\t// LoginServlet 생성하기\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 2.3 로그아웃\r\n");
      out.write("\t\tfunction logout(){\r\n");
      out.write("\t\t\t// 로그아웃 버튼 클릭 시\r\n");
      out.write("\t\t\t// LogoutServlet 으로 이동하여\r\n");
      out.write("\t\t\t// session에 저장된 값을 삭제\r\n");
      out.write("\t\t\tlocation.href = \"");
      out.print( request.getContextPath() );
      out.write("/logout.me\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 4. 회원 가입 버튼 클릭 시 회원 가입 페이지로 이동\r\n");
      out.write("\t\tfunction memberJoin(){\r\n");
      out.write("\t\t\tlocation.href = \"");
      out.print( request.getContextPath() );
      out.write("/views/member/memberJoinForm.jsp\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"outer\">\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<h2 align=\"center\">비밀번호 변경</h2>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- 비밀번호 변경 폼 -->\r\n");
      out.write("\t\t<form id=\"updatePwdForm\" name=\"updatePwdForm\" method=\"post\"\r\n");
      out.write("\t\t\taction=\"");
      out.print(request.getContextPath());
      out.write("/updatePwd.me\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<table align=\"center\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>현재 비밀번호</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"userPwd\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>새로운 비밀번호</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"newPwd\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>새로운 비밀번호 확인</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"newPwd2\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<br><br>\r\n");
      out.write("\t\t\t<div class=\"btns\" align=\"center\">\r\n");
      out.write("\t\t\t\t<div id=\"updatePwdBtn\" onclick=\"checkPwd()\">변경하기</div>\r\n");
      out.write("\t\t\t\t<div id=\"cancleBtn\" \r\n");
      out.write("\t\t\t\tonclick=\"location.href='javascript:history.back()';\">취소</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction checkPwd(){\r\n");
      out.write("\t\t\t// 새로운 비밀번호\r\n");
      out.write("\t\t\tvar value = $(\"input[name=newPwd]\").val().trim();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 숫자, 문자 포함 형태\r\n");
      out.write("\t\t\t// 6~12자리 이내\r\n");
      out.write("\t\t\tvar regExp = /^[A-Za-z0-9]{6,12}$/; \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(!regExp.test(value)){\r\n");
      out.write("\t\t\t\talert(\"비밀번호는 숫자와 문자 포함 6~12자리 이내로 작성하세요.\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 새로운 비밀번호 확인\r\n");
      out.write("\t\t\tvar value2 = $(\"input[name=newPwd2]\").val().trim();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(value != value2){\r\n");
      out.write("\t\t\t\talert(\"비밀번호가 일치하지 않습니다.\");\r\n");
      out.write("\t\t\t\t$(\"input [name=newPwd2]\").focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\"#updatePwdForm\").submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
