<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
Hey Company please Enter your Password
<br /> PASSWORD <input type="password" name="PASSWORD" /><br/>
<%String password = null;
password = request.getParameter(password);
if(password == "1234"){
	 response.sendRedirect("/project/ViewTable");
}else{
	out.println("Wrong Password");
}%>
</body>
</html>