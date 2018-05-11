<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>收货人地址管理页面</title>
	<link href="../css/address.css" rel="stylesheet"/>
	</head>
<body style="font-size: 30px;">
<jsp:include page="header.jsp"></jsp:include>
	
	<div class="address_0">
		<form id="form">
			<div class="address_1">
				PROVINCE:<select class="pcc" id="receiverState" name="receiverState" onchange="getCities(this.value,-1,-1)"></select>
				CITY:<select class="pcc" id="receiverCity" name="receiverCity" onchange="getAreas(this.value,-1)"></select>
				COUNTY:<select class="pcc" id="receiverArea" name="receiverArea"></select>
			</div>
			<div class="address_2">
				<span class="recv_3">RECEIVER_NAME:</span>
					<input class="recv" type="text" name="receiverName" id="receiverName"/><br>
				<span class="recv_3">ADDRESS:</span>
					<input class="recv" type="text" name="receiverDistrict" id="receiverDistrict"/><br>
				<span class="recv_3">RECEIVER_TEL:</span>
					<input class="recv" type="text" name="receiverPhone" id="receiverPhone"/><br>
				<input  class="but" class="recv" type="button" value="CONFIRM" onclick="addAddressFun()"/>
			</div>
			
		</form>	
	</div>
	<!-- ***********回显所有收货人地址************** -->
	<div class="address_3">
		<span class="all_address0">YOUR_ALL_ADDRESS:</span>
		<input class="but" type="button" onclick="getAllAddress()" value="GET_MINE_ALL_ADDRESS"/>
		<div id="all_address">
			
		</div>
	</div>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(function(){ 
	getProvinces(-1,-1,-1);
})
</script>
<script type="text/javascript">
//显示省列表信息
function getProvinces(provinceCode,cityCode,areaCode){
	$.ajax({
		"url":"${pageContext.request.contextPath}/dict/getProvinces.do",
		"data":"",
		"type":"post",
		"dataType":"json",
		"success":function(obj){
			$("#receiverState").html("<option>---------SELECT---------</option>");
			$("#receiverCity").html("<option>---------SELECT---------</option>");
			$("#receiverArea").html("<option>---------SELECT---------</option>");
			for(i=0;i<obj.data.length;i++){
				$("#receiverState").append("<option value="+obj.data[i].provinceCode+">"+obj.data[i].provinceName+"</option>");			
			}
			//回显:显示省份的信息
			if(provinceCode!=-1){
				$("#receiverState").val(provinceCode);
			}
		}
	});
}
//根据省的编号返回对应的市
function getCities(provinceCode,cityCode,areaCode){
	$.ajax({
		"url":"${pageContext.request.contextPath}/dict/getCities.do",
		"data":"provinceCode="+provinceCode,
		"type":"post",
		"dataType":"json",
		"success":function(obj){
			$("#receiverCity").html("<option>---------SELECT---------</option>");
			$("#receiverArea").val("---------SELECT---------");
			for(i=0;i<obj.data.length;i++){
				$("#receiverCity").append("<option value="+obj.data[i].cityCode+">"+obj.data[i].cityName+"</option>");			
			}
			//回显:显示市的信息
			if(cityCode!=-1){
				$("#receiverCity").val(cityCode);
			}
		}
	});
}
//根据市的编号返回对应的区
function getAreas(cityCode,areaCode){
	$.ajax({
		"url":"${pageContext.request.contextPath}/dict/getAreas.do",
		"data":"cityCode="+cityCode,
		"type":"post",
		"dataType":"json",
		"success":function(obj){
			$("#receiverArea").html("<option>---------SELECT---------</option>");
			for(i=0;i<obj.data.length;i++){
				$("#receiverArea").append("<option value="+obj.data[i].areaCode+">"+obj.data[i].areaName+"</option>");			
			}
			//回显:显示市的信息
			if(areaCode!=-1){
				$("#receiverArea").val(areaCode);
			}
		}
	});
}
</script>
<!-- -------------------------------------------------------------------------------------------------------------------------------------------- -->
<!-- 地址管理:添加新地址 -->
<script type="text/javascript">
function addAddressFun(){
	$.ajax({
		"url":"${pageContext.request.contextPath}/address/addAddress.do",
		"data":$("#form").serialize(),
		"type":"post",
		"dataType":"json",
		"success":function(obj){
			alert("添加成功")
		}
	});
}
//获取登陆用户的收货地址
function getAllAddress(){
	$.ajax({
		"url":"${pageContext.request.contextPath}/address/getAddressByUid.do",
		"data":"",
		"type":"POST",
		"dataType":"json",
		"success":function(obj){
			var headerVal='<div id="all_adddress">'+
				            '<span class="in_0">address</span><span class="in_0">receiverName</span><span class="in_0">detailAddress</span><span class="in_0">TEL</span><span class="in_0">OPTION</span>'+
				            '</div>';
			$("#all_address").html(headerVal);
			for(i=0;i<obj.data.length;i++){
					var str1='<div>'+
								'<span class="in_0">'+obj.data[i].recvAddress+'</span>'+
                  '<span class="in_0">'+obj.data[i].recvName+'</span>'+
                  '<span class="in_0">'+obj.data[i].recvDistrict+'</span>'+
                  '<span class="in_0">'+obj.data[i].recvPhone+'</span>'+
                  '<span class="in_0">'+
                  '<span onclick="goUpdate('+obj.data[i].id+')">REVISE</span>|<span onclick="goDelete('+obj.data[i].id+')">DROP</span>'+
                  '</span>'+
                  '<span id="'+obj.data[i].id+'"></span>'+
                  '</div>';
         $("#all_address").append(str1);
			}
		}
	});
}
</script>
</html>