<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户注册</title>
	 <link href="../css/register.css" rel="stylesheet"/>	
	</head>
<body style="font-size: 30px;">
	<div class="register">
		<form id="registerForm">
			<table align="center" cellspacing="0">
				<tr>
					<td class="reg_0">username:</td>
					<td><input class="reg_1" type="text" id="username" name="username" onblur="compareUsername()"/></td>
				</tr>
				<tr>
					<td class="reg_0">password:</td>
					<td><input class="reg_1" type="password" id="password" name="password"/></td>
				</tr>
				<tr>
					<td class="reg_0">confirm password:</td>
					<td><input class="reg_1" type="password" id="confirmPassword"/></td>
				</tr>
				<tr>
					<td class="reg_0">phone:</td>
					<td><input class="reg_1" type="text" id="phone" name="phone"/></td>
				</tr>
				<tr>
					<td class="reg_0">email:</td>
					<td><input class="reg_1" type="text" id="email" name="email" onblur="compareEmail()"/></td>
				</tr>
				<tr>
					<td class="reg_0">gender:</td>
					<td><input type="radio" class="gender" name="gender">男</input>
							<input type="radio" class="gender" name="gender">女</input>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<input class="but" type="button" value="confirm" onclick="registerFun()" id="button"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<a class="but" href="${pageContext.request.contextPath}/user/showLogin.do">GO_LOGIN</a>
					</td>
				</tr>		
			</table>	
		</form>
		<span id="information"></span>
	</div>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function compareUsername(){
		if($("#username").val()==""){
			$("#information").html("");
			$("#information").html("用户名不能为空......");
			$("#information").css("color","red");
		}else{
			$.ajax({
				"url":"${pageContext.request.contextPath}/user/compareUsername.do",
				"data":"username="+$("#username").val(),
				"type":"post",
				"dataType":"json",
				"success":function(obj){
					if(obj.state==1){
						$("#information").html("该用户名已经存在");
						$("#information").css("color","red");
					}else{
						$("#information").html("该用户名可以使用");
						$("#information").css("color","#FF832C");
					}
				}
			});
		}
	}
	function compareEmail(){
		if($("#email").val()==""){
			$("#information").html("");
			$("#information").html("邮箱不能为空......");
			$("#information").css("color","red");
		}else{
			$.ajax({
				"url":"${pageContext.request.contextPath}/user/compareEmail.do",
				"data":"email="+$("#email").val(),
				"type":"post",
				"dataType":"json",
				"success":function(obj){
					if(obj.state==1){
						$("#information").html("该邮箱已经存在");
						$("#information").css("color","red");
					}else{
						$("#information").html("该邮箱可以使用");
						$("#information").css("color","#FF832C");
					}
				}
			});
		}	
	}
</script>
<script type="text/javascript">
	//可以使用onblur事件和onfocus事件来分别处理
	function registerFun(){
		if($("#username").val()!=""&&
			$("#password").val()!=""&&
			$("#confirmPassword").val()!=""&&
			$("#phone").val()!=""&&
			$("#email").val()!=""){
			//信息完善
			if($("#password").val()==$("#confirmPassword").val()){
				var phoneReg=/^1[3|4|5|8][0-9]\d{4,8}$/;
				if(phoneReg.test($("#phone").val())){
					if($("#username").val().length<=12){
						if($("#password").val().length>=6&&$("#password").val().length<=12){
							var emailReg=/^.*@.*$/;
							if(emailReg.test($("#email").val())){
								$.ajax({
									"url":"${pageContext.request.contextPath}/user/register.do",
									"data":$("#registerForm").serialize(),
									"type":"post",
									"dataType":"json",
									"success":function(obj){
										alert(obj.state+","+obj.message);
										$("#information").html("");
										window.location.href="${pageContext.request.contextPath}/user/showLogin.do";
									}
								});
							}else{
								//邮箱有误差
								$("#information").html("");
								$("#information").html("请输入正确的邮箱地址......");
								$("#information").css("color","red");
							}				
						}else{
							//用户密码有误差
							$("#information").html("");
							$("#information").html("输入的密码需要在6到12位字符之间......");
							$("#information").css("color","red");
						}					
					}else{
						//用户名输入有误差
						$("#information").html("");
						$("#information").html("输入的用户名需要小于12位字符......");
						$("#information").css("color","red");
					}					
				}else{
					//电话号码格式错误
					$("#information").html("");
					$("#information").html("电话号码格式错误......");
					$("#information").css("color","red");
				}
				
			}else{
				//两次密码输入不同
				$("#information").html("");
				$("#information").html("两次密码输入不正确......");
				$("#information").css("color","red");
			}	
		}else{
				//信息未完善
				$("#information").html("");	
				$("#information").html("请完善信息......");
				$("#information").css("color","red");
		}	
	}
</script>

</html>