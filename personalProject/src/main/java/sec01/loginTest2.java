package sec01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginTest2") // adminLogin

public class loginTest2 extends HttpServlet {
	public void init() {
		System.out.println("init start");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		
		if ((id != null)&&(id.length()!=0)&&(pw !=null)&&(pw.length()!=0)) {
			if (id.equals("admin")) {
				out.println("<html>");
				out.println("<body>");
				out.println("Admin 으로 Login 했습니다");
				out.println("<input type='button' value='회원정보 수정하기'>");
				out.println("<input type='button' value='회원정보 삭제하기'>");
				out.println("</body>");
				out.println("</html>");
			} else {
				out.println(id+"님으로 접속했습니다");
			}
		} else {
			out.println("<html>");
			out.println("<body>");
			out.println("id와 비밀번호를 입력해주세요");
			out.println("<a href='http://localhost:8090/personalProject/loginTest2.html'>");
			out.println("</a>");
			out.println("</body>");
			out.println("</html>");
		}
				
	}
}