	function f_validate(obj){
			with(obj){
			var nameReg = /^[a-zA-Z]\w{4,19}$/;
			var idReg = /^\d{15}$|^\d{18}$|^\d{17}[xX]$/;
			var pwReg = /^\w{6,}$/;
			if(username.value.length == 0){
				alert("用户名不能为空！");
				return false;
			}
			else if(!username.value.match(nameReg))
			{
				alert("用户名不正确！");
				return false;
			}
			
			else if(!password.value.match(pwReg)){
				alert("密码不正确！")
				return false;
			}

			else if(!cert.value.match(idReg)){
				alert("证件号码不正确！")
				return false;
			}
			return true;
		}
			}