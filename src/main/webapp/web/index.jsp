<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>主页面</title>
	<link href="../css/main.css" rel="stylesheet"/>
	</head>
<body style="font-size: 30px;">
<jsp:include page="header.jsp"></jsp:include>
	<div id="index" onclick="showCategoryFun()">
			<div id="start">在书海中遨游</div>
	</div>
</body>
<script type="text/javascript">
	function showCategoryFun(){
		window.location.href="../category/showCategory.do";
	}
</script>
</html>