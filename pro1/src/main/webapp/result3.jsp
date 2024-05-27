<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%request.setCharacterEncoding("utf-8");
    String user_id = request.getParameter("user_id");
    String user_pw = request.getParameter("user_pw");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>resultPrint</title>
</head>
<body>
<%
if(user_id==null||user_id.length()==0{
%>
<h1>관리자로 로그인했습니</h1>
<form>
	<input type = button value = "회원정보 삭제하기" />
	<input type = button value = "회원정보 수정하기" />
</form>
<%
}else{ 
%>

<h1> welcome <%=user_id %></h1>

<%
	}
}
%>

</body>
</html>