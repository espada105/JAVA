package sec03.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginTest  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        
        String user_name = request.getParameter("user_name");
        String user_pw = request.getParameter("user_pw");
        out.println("<html><body>");
        out.println("이름은 "+ user_name+"<br>");
        out.println("pw "+ user_pw+"<br>");
        out.println("</body></html>");
        		
    }
}
