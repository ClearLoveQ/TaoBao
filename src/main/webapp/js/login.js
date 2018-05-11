window.onload=function(){
		document.getElementById('mes_0').innerHTML='业精于勤，荒于嬉；行成于思，毁于随——韩愈 ';
		window.setInterval(func,5000);
		var arr=["学而不思则罔，思而不学则殆——孔子 ",
			"敏而好学，不耻下问——孔子 ",
			"知之者不如好之者，好之者不如乐之者——孔子 ",
			"一日无书，百事荒芜。——陈寿",
			"读书有三到：谓心到、眼到、口到——朱熹",
			"己所不欲，勿施于人——孔子",
			"读书破万卷，下笔如有神——杜甫 ",
			"立身以立学为先，立学以读书为本——欧阳修 ",
			"黑发不知勤学早，白首方悔读书迟——颜真卿",
			"读万卷书，行万里路——刘彝 ",
			"书卷多情似故人，晨昏忧乐每相亲——于谦 "];
		var i=0;
		function func(){
				//如果小于11则执行eval函数
				if(i<arr.length){
					eval(
							"var b=document.getElementById('mes_0');" +  
							 "b.innerHTML="+"'"+arr[i]+"'"+";"    
					);
					i++;
				}else{
					i=0;
				}	
			
		};
}