<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>管理员页面</title>
	<link href="../css/manager.css" rel="stylesheet"/>
	</head>
<body style="font-size: 30px;">
	<div class="left" onclick="getAllUsers()">ALL_USERS</div>
	<div class="left" id="left_1">ALL_ORDERS</div>
	<div class="left" id="left_2">ADD_BOOKS</div>
	<div id="user_list">
		<c:forEach items="${userList}" var="u">
			<span onclick="getOrders(${u.id})">${u.username}</span><br>
		</c:forEach>
	</div>
	<div id="order_list">
		<c:forEach items="${orderList}" var="o">
			${o.id};${o.price};{o.sumPirce};${o.image};${o.paymentStatus};<br>
		</c:forEach>
	</div>
	<div id="add_books">
		
	</div>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function getAllUsers(){
		window.location.href="../manager/getAllUsers.do";
	}
	function getOrders(uid){
		window.location.href="../manager/getOrders.do";
	}
</script>
</html>