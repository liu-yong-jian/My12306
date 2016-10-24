!function(){
				laydate.skin("molv");
				laydate({elem:'#demo'});
			}();
			
			var start = {
				elem:'#start',
				format:'YYYY-MM-DD',
				min:laydate.now(),
				max:'2099-9-09',
				istime:true,
				istoday:false,
				choose:function(datas){
					end.min = datas;
					end.start = datas
				}
			};
			var end = {
			elem:'#end',
				format:'YYYY-MM-DD',
				min:laydate.now(),
				max:'2099-9-09',
				istime:true,
				istoday:false,
				choose:function(datas){
					start.max = datas;
				}
				
			};
			laydate(start);
			laydate(end);
			laydate({
				elem:'#test1',
				format:'YYYY年-MM月-DD日',
				festival:true,
				choose:function(datas){
					alert('得到:'+datas);
				}
			});
			
			laydate({
				elem:'#hello3',
				min:laydate.now(-1),
				max:laydate.now(+1)
			});