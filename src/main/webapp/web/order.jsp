<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登陆用户的订单管理页面</title>
	<link href="../css/order.css" rel="stylesheet"/>
	</head>
<body style="font-size: 30px;">
<jsp:include page="header.jsp"></jsp:include>
	<div class="order">
		<c:forEach items="${orderList}" var="orderItem">
			<form method="post" action="payment.do">
			<input type="hidden" name=id value="${orderItem.id}">
				ORDER_ID:<span class="span_0">${orderItem.id}</span>
				SUM_PRICE:<span class="span_0">${orderItem.sumPrice}</span>
				<span><img src="${orderItem.image}" class="img"/></span>
				<span class="but_sub">
					<input class="span_1" type="button" value="DELETE" onclick="delOrderFun()"/>
					<input class="span_1" type="submit" value="CONFIRM" /><br>
				</span>
			</form>
		</c:forEach>	
	</div>
	
</body>
</html>