package sec01;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalCulate")
public class CalCulate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final float USD_RATE = 1350;
	private static final float JPY_RATE = 9;
	private static final float WIAN_RATE = 190;



	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출");
	}
	
	private static String calculate(float won, String operator) {
		String result="";
		if (operator.equals("dollar")) {
		result =String.format("%.6f", won/USD_RATE);
		} else if (operator.equals("en")) {
		result=String.format("%.6f", won/JPY_RATE);
		} else if (operator.equals("wian")) {
		result=String.format("%.6f", won/WIAN_RATE);
		}
		return result;
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		String command = request.getParameter("command");
		
		if ( (command != null) && (command.equals("calculate") ) ) {
			String result = calculate(Float.parseFloat(won), operator);
			out.print("<html><font size=10>변환결과:</font><br>");
			out.print("<font size=10>" + result +"</font><br>");
			out.print("<a href='CalCulate'>다시 계산</a>");
			out.print("</html>");
			return;
		}
		
		out.print("<html><title>환율계산기</title>");
		out.print("<font size=5>환율계산기</font><br>");
		out.print("<form name='frmCal' method='doGet' action='/CalCulate' >");
		out.print("원화 <input type='text' name='won' size=10>");
		out.print("<select name='operator'>");
		out.print("<option value='dollar'>달러</option>");
		out.print("<option value='en'>엔</option>");
		out.print("<option value='wian'>위안</option>");
		out.print("</select>");
		out.print("<input type='hidden' name='command' value='calculate'>");
		out.print("<input type='submit' value='전송'>");
		out.print("</form>");
		out.print("</html>");
		out.close();
		
		
		
		
	}

	public void destroy() {
		System.out.println("destroy 호출");
	}







}
