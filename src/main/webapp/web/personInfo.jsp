<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户信息页面</title>
	<link href="../css/personInfo.css" rel="stylesheet"/>
	</head>
<body style="font-size: 30px;">
<jsp:include page="header.jsp"></jsp:include>
	<div id="information">
		<form action="">
			<table>
				<tr>
					<td>
						<span>USERNAME:</span>
					</td>
					<td>
						<input type="text" name="username" id="username"/>
					</td>
				</tr>
				<tr>
					<td>
						<span>PASSWORD:</span>
					</td>
					<td>
						<input type="password" name="password0" id="password0">
					</td>
				</tr>
				<tr>
					<td>
						<span>CONFIRM_PASSWORD:</span>
					</td>
					<td>
						<input type="password" name="password" id="password"/>
					</td>
				</tr>
				<tr>
					<td>
						<span>EAMIL:</span>
					</td>
					<td>
						<input type="text" name="email" id="email"/>
					</td>
				</tr>
			</table>	
			<input type="submit" id="subUpdate" value="UPDATE"/>
		</form>	
	</div>
	<div id="advert">
			
	</div>
</body>
</html>