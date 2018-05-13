<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>分类菜单页面</title>
	<script type="text/javascript" src="../js/category.js"></script>
	<link href="../css/category.css" rel="stylesheet"/>
	</head>
<body style="font-size: 30px;">
<jsp:include page="header.jsp"></jsp:include>
	<div id="cate">
		<c:forEach items="${cateFirstList}" var="cate1" begin="1" end="5" varStatus="status">
			<div class="ca1">
				<div id="cateName">${cate1.name}</div>	
				<c:forEach items="${cateSecondList}" var="cate2">
					<div class="ca2">
						<form method="post" action="${pageContext.request.contextPath}/main/showGoods.do">
							<input type="hidden" name="categoryId" value="${cate2.id}"/>
							<input type="submit" value="${cate2.name}" id="sub"/>
					  </form>
					</div>		
				</c:forEach>
				<div class="pic">
					<img class="img_book" src="${pageContext.request.contextPath}/images/books/book${status.index}.jpg"/>
				</div>	
			</div>
		</c:forEach>
	</div>
	<div id="technology">
		<img id="img_right">
	</div>
	<div id="maxim">
		知识像烛光，能照亮一个人，也能照亮无数的人  培根 
	</div>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
window.onload=function(){
	document.getElementById('img_right').src='../images/books/book1.jpg';
	window.setInterval(func,2000);
	var arr=["1","2","3","4","5","6","7","8","9","10","11"];
	var i=0;
	function func(){
		//如果小于11则执行eval函数
		if(i<arr.length){
			eval(
					"var b=document.getElementById('img_right');" +  
					 "b.src='../images/books/book"+arr[i]+".jpg';"    
			);
			i++;
		}else{
			i=0;
		}	
	};
}
</script>
</html>