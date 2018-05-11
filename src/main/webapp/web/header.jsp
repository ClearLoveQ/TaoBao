<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>头模块,顶端信息</title>
	<link href="../css/header.css" rel="stylesheet"/>	
	</head>
<div style="font-size: 30px;">
	<div class="header0" onclick="showIndexFun()">
			<div class="header1">HOST</div>
	</div>
	<div class="header01" onclick="showPersonInfoFun()">
			<div class="header2">${user.username}</div>
	</div>
	<div class="header02" onclick="showCartFun()">
			<div class="header3">YOUR_CART</div>
	</div>
	<div class="header03" onclick="showAddressFun()">
			<div class="header4">ADDRESS</div>
	</div>
	<div class="header04" onclick="showOrderFun()">
			<div class="header5">ORDER</div>
	</div>
</div>
<script type="text/javascript">
	function showIndexFun(){
		window.location.href="${pageContext.request.contextPath}/main/showIndex.do";
	}
	function showPersonInfoFun(){
		window.location.href="${pageContext.request.contextPath}/user/showPersonInfo.do";
	}
	function showCartFun(){
		window.location.href="${pageContext.request.contextPath}/cart/showCart.do";
	}
	function showAddressFun(){
		window.location.href="${pageContext.request.contextPath}/address/showAddress.do";
	}
	function showOrderFun(){
		window.location.href="${pageContext.request.contextPath}/order/showOrder.do";
	}
</script>
</html>