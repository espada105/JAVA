package sec01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guguTest")

public class guguTest extends HttpServlet{
	public void init(){
		System.out.println("init Start");
	}


	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int dan = Integer.parseInt(request.getParameter("dan")); //졸라 중요
		
		out.println("<table>");
		for (int i =0;  i<9; i++) {
			out.print("<tr>");
			out.print("<td>");
			out.println(dan+"*"+i+"="+dan*i);
			out.print("</td>");
			out.print("</tr>");
		}
		out.println("</table>");
		
		
		
		
		
		
		
	}
}