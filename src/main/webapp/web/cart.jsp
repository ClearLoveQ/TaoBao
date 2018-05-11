<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>购物车页面</title>
	<link href="../css/cart.css" rel="stylesheet"/>
	</head>
<body style="font-size: 30px;">
<jsp:include page="header.jsp"></jsp:include>
	<div class="cart">
		<c:forEach items="${cartList}" var="cart">
			<form>
				<input type="hidden" value="${cart.goodsId}"/>
				PICTURE:<img src="${cart.image}" class="img">
				PRICE:<span class="span_0">${cart.price}</span>
				COUNT:<span class="span_0">${cart.count}</span>
				<input class="span_1"type="button" value="DELETE_IT">
				<input class="span_1"type="button" value="BUY_IT" onclick="buyFun(${cart.goodsId},${cart.count},${cart.price},'${cart.image}')"><br>
			</form>
		</c:forEach>
	</div>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function buyFun(goodsId,count,price,image){
		alert(image+","+count+","+price+","+goodsId);
		$.ajax({
			"url":"${pageContext.request.contextPath}/order/addOrder.do",
			"data":"goodsId="+goodsId+"&count="+count+"&price="+price+"&image="+image,
			"type":"POST",
			"dataType":"json",
			"success":function(obj){
				alert("正在生成订单");
				alert(obj.state+","+obj.message);
				window.location.href="${pageContext.request.contextPath}/order/showOrder.do";
			}
		});
	}
</script>
</html>