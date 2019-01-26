<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>calculatrice</title>
</head>
<body>
<%
    String res = (String) request.getAttribute("res");
    out.println(res);
%>
<%@ include file="operation.jsp" %>
</body>
</html>
