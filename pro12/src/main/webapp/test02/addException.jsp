<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
</head>
<body>
========toString()========<br>
<h1><%=exception.toString()%></h1>
========getMessage()========<br>
<h1><%=exception.getMessage()%></h1>
========printStackTrace();========<br>
<%
    // StringWriter와 PrintWriter를 사용하여 스택 트레이스를 문자열로 변환
    java.io.StringWriter sw = new java.io.StringWriter();
    java.io.PrintWriter pw = new java.io.PrintWriter(sw);
    exception.printStackTrace(pw);
    // 변환된 스택 트레이스를 출력
    out.print("<pre>" + sw.toString() + "</pre>");
%>

<h3>
숫자만 입력가능, 다시시도
<a href="add.html">다시하기</a>
</h3>
</body>
</html>
