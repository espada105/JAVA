package sec01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
       
        MemberDAO dao = new MemberDAO();        // MemberDAO 객체 생성
        
       
        List<MemberVO> memberList = dao.listMember();			 // 회원 목록 조회
        
        // 결과 출력
        out.println("<html>");
        out.println("<head><title>회원 목록</title></head>");
        out.println("<body>");
        out.println("<h1>회원 목록</h1>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Password</th>");
        out.println("<th>Name</th>");
        out.println("<th>Email</th>");
        out.println("<th>Join Date</th>");
        out.println("</tr>");
        
        
        for (MemberVO member : memberList) {
            out.println("<tr>");
            out.println("<td>" + member.getId() + "</td>");
            out.println("<td>" + member.getPassword() + "</td>");
            out.println("<td>" + member.getName() + "</td>");
            out.println("<td>" + member.getEmail() + "</td>");
            out.println("<td>" + member.getJoinDate() + "</td>");
            out.println("</tr>");
        }
        
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
