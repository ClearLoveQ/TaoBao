<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>支付页面</title>
	<link href="../css/payment.css" rel="stylesheet"/>
	</head>
<body style="font-size: 30px;">
<jsp:include page="header.jsp"></jsp:include>
	<div class="pay">
		<div class="pay_1">
			<form>
				<input type="hidden" name="orderId" value="${orderId}"/>
				YOUR_BANK_PASSWORD:<input type="password" id="BankPwd" name="BankPwd"/><br>
				<input class="confirm" type="button" value="CONFIRM_PAY" onclick="payOverFun(${orderId})"/>
			</form>
		</div>
	</div>
	
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function payOverFun(orderId){
		var BankPwd=$("#BankPwd").val();
		$.ajax({
			"url":"${pageContext.request.contextPath}/order/payOver.do",
			"data":"BankPwd="+BankPwd+"&orderId="+orderId,
			"type":"post",
			"dataType":"json",
			"success":function(obj){
				alert(obj.message);
			}
		});
	}
</script>
</html>