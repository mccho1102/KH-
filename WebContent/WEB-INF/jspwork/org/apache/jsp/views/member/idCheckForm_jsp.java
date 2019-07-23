/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-07-19 08:06:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class idCheckForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("<title>아이디 중복 체크</title>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t// 중복 체크창 아이디 입력 부분에 초기값 설정\r\n");
      out.write("\t// + 확인버튼 활성, 비활성화 설정\r\n");
      out.write("\tfunction idValue(){\r\n");
      out.write("\t\tvar userId;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 중복 체크 창이 처음 열렸을때\r\n");
      out.write("\t\tif('");
      out.print( request.getAttribute("result") );
      out.write("' == \"null\"){\r\n");
      out.write("\t\t\tuserId = opener.document.joinForm.userId.value;\r\n");
      out.write("\t\t\t// -> 부모창에 입력된 아이디 값을 가져와라\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t// 중복 체크 동작 후\r\n");
      out.write("\t\t\t// 체크에 사용된 아이디를 다시 입력창에 입력하기\r\n");
      out.write("\t\t\tuserId = \"");
      out.print( request.getAttribute("userId"));
      out.write("\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 사용 가능한 아이디인 경우\r\n");
      out.write("\t\t\tif(");
      out.print( request.getAttribute("result"));
      out.write(" == 0){\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"usedId\").removeAttribute(\"disabled\");\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"usedId\").setAttribute(\"disabled\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"userId\").value = userId;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t// 중복체크한 아이디를 사용 -> 회원가입 창에 입력\r\n");
      out.write("\tfunction usedId(){\r\n");
      out.write("\t\tif(");
      out.print( request.getAttribute("result"));
      out.write(" == 0){\r\n");
      out.write("\t\t\topener.document.joinForm.userId.value\r\n");
      out.write("\t\t\t\t= document.getElementById(\"userId\").value;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\topener.document.joinForm.userId.setAttribute(\"disabled\", \"disabled\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(opener != null){ // 중복체크 창 닫기\r\n");
      out.write("\t\t\topener.checkForm = null;\r\n");
      out.write("\t\t\tself.close();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"idValue();\">\r\n");
      out.write("\t<form action=\"");
      out.print( request.getContextPath() );
      out.write("/idCheck.me\"\r\n");
      out.write("\t\t\tid=\"idCheckForm\" method=\"post\">\r\n");
      out.write("\t\t\t<input type=\"text\" id=\"userId\" name=\"userId\">\r\n");
      out.write("\t\t\t<input type=\"submit\" value= 중복확인>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t\t");

					if(request.getAttribute("result") != null){
						int result = (int)request.getAttribute("result");
						
						if(result > 0){
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t이미 사용중인 아이디 입니다.\r\n");
      out.write("\t\t\t\t\t");
 
						}else{ 
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t사용 가능한 아이디 입니다.\r\n");
      out.write("\t\t\t\t\t");

						}
					}
				
      out.write("\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<input type=\"button\" id=\"cancel\" value=\"취소\" onclick=\"window.close();\">\r\n");
      out.write("\t\t\t<input type=\"button\" id=\"usedId\" value=\"확인\" onclick=\"usedId();\" disabled>\r\n");
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
