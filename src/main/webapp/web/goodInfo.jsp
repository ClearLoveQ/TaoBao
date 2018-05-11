<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>商品详情</title>
	<link href="../css/goodsInfo.css" rel="stylesheet"/>
	</head>
<body style="font-size: 30px;">
<jsp:include page="header.jsp"></jsp:include>
	<div id="ware_info">
		<form id="addCartForm">
			<input type="hidden" id="goodsId" name="goodsId" value="${goods.id}"/>
			<span class="span_0">WARE_NAME:${goods.title}</span><br>
			<span class="span_0">PRICE:
				<span id="price">${goods.price}</span>
			</span><br>
			<span class="span_0"><img id="img" src="${pageContext.request.contextPath}${goods.image}"></span><br>
			<span class="span_0">SCALAR:<input type="text" id="count" name="count"/></span><br>
			<input type="button" value="ADD_TO_MYCART" onclick="addCartFun(${goods.id})" id="but"/>
		</form>
	</div>
	<div id="technology">
		
	</div>
	
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function addCartFun(goodsId){
		var count=$("#count").val();
		var price=$("#price").text();
		var image=$("#img").attr("src");
		$.ajax({
			"url":"${pageContext.request.contextPath}/cart/addCart.do",
			"data":"goodsId="+goodsId+"&count="+count+"&price="+price+"&image="+image,
			"type":"post",
			"dataType":"json",
			"success":function(obj){
				alert(obj.message);
			},
			"error":function(){
				alert("加入购物车失败......");
			}
		});		
	}	
</script>
</html>