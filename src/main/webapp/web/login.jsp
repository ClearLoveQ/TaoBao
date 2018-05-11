<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登陆页面</title>
	<link href="../css/login.css" rel="stylesheet"/>
	<script type="text/javascript" src="../js/login.js"></script>
	</head>
<body style="font-size: 30px;">
	<div id="mes_0">
		<!-- 动态输出字符串格言 -->
	</div>
	<div class="login">
			<a class="register" href="${pageContext.request.contextPath}/user/showRegister.do">REGISTE_NEW</a>
		<div id="login_0">
			<form>
				USERNAME:<input class="login_1" type="text" name="username" id="username"></input></br>
				PASSWORD:<input class="login_1" type="password" name="password" id="password"></input></br>
				<input id="but" type="button" value ="CONFIRM" onclick="loginFun()"/>
			</form>
			<span id="information"></span>
		</div>		
	</div>
	
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
    //判断登陆
	function loginFun(){
		if($("#username").val()==""||$("#password").val()==""){
			$("#information").html("USERNAME OR PASSWORD IS NOT NULL......");
			$("#information").css("color","#FF832C");
		}else{
			$.ajax({
				"url":"${pageContext.request.contextPath}/user/login.do",
				"data":"username="+$("#username").val()+"&password="+$("#password").val(),
				"type":"post",
				"dataType":"json",
				"success":function(obj){
					alert(obj.state+","+obj.message);
					if(obj.state==1){
						//登陆成功
						window.location.href='${pageContext.request.contextPath}/main/showIndex.do';
					}else{
						$("#information").html("USERNAME OR PASSWORD IS ERROR");
					}		
				}
			});
		}
	
	}
</script>
</html>