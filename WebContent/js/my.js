
//定义一个一维数组
			var pros = new Array();
			pros[0] = "辽宁省";
			pros[1] = "吉林省";
			pros[2] = "江苏省";
			//定义一个二维数组:
			var citys = new Array();
			citys[0] = new Array();
			citys[1] = new Array();
			citys[2] = new Array();
			citys[0][0] = "沈阳市";
			citys[0][1] = "大连市";
			citys[1][0] = "长春市";
			citys[1][1] = "吉林市";
			citys[2][0] = "南京市";
			citys[2][1] = "无锡市";
			
function changeCity(){
				var city = document.getElementById("city");
				var province = document.getElementById("province");
				city.options.length = 0;//清空长度
				//获取选择的省份的value
				var pvalue = province.options[province.selectedIndex].value;
				//从citys的二维数组中遍历构建option选项
				for(var i=0; i<citys[pvalue].length; i++){
					var text = citys[pvalue][i];
					var value = i;
					city.options[city.options.length] = new Option(text,value);
				}
}