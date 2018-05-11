	window.onload=function(){
			document.getElementById('img_right').src='../images/books/book1.jpg'
			window.setInterval(func,2000);
			var arr=["1","2","3","4","5","6","7","8","9","10","11"];
			var i=0;
			function func(){
				//如果小于11则执行eval函数
				if(i<arr.length){
					eval(
							"var b=document.getElementById('img_right');" +  
							 "b.src='../images/books/book"+arr[i]+".jpg'"    
					);
					i++;
				}else{
					i=0;
				}	
			};
	}