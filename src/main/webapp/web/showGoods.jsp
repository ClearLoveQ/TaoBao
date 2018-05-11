<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>商品展示页面</title>
	<link href="../css/showGoods.css" rel="stylesheet"/>
	</head>
<body style="font-size: 30px;">
<jsp:include page="header.jsp"></jsp:include>
	<div id="ware_0">
			<c:forEach items="${nowNovelList}" var="novel">
				<form action="${pageContext.request.contextPath}/main/goodInfo.do">
					<input type="hidden" name="goodsId" value="${novel.id}"/>
					<div class="row_0">
						<span class="span_0">TRADE_NAME:${novel.title}</span>
						<span class="span_0"><img src="${pageContext.request.contextPath}${novel.image}"/></span>
						<span class="span_0">PRICE:${novel.price}</span>
						<input class="sub" type="submit" value="FOR_MORE_INFORMATION"/>
					</div>	
				</form>	
			</c:forEach>
	</div>
		
	
</body>
</html>