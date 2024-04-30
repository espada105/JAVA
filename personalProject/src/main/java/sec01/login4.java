package sec01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login4")
public class login4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("doHandle에게 전달");
		doHandle(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doHandle에게 전달");
	
	}
	
	private void doHandle(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String method = request.getParameter("method");
		
		if (method.equals("GET")) {
			System.out.println("get 메소드를 전달받았음");
		} else if(method.equals("POST") ){
			System.out.println("POST메소드를 전달받았음");
		} 
			System.out.println("아이디:"+id+"비밀번호:"+pw);
	}

}
