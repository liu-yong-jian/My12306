<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录界面</title>
		<script type = "text/javascript">
			function f_validateInfo(obj){
		var nameReg = /^\w{6,30}$/;
		var pwReg = /^\w{6,}$/;
		if(!username.value.match(nameReg)){
			alert("用户名格式不正确！");
			return false;
		}
			if(!password.value.match(pwReg)){
			alert("密码格式不正确！");
			return false;
		}
			return true;
			}
			
		</script>
		
	</head>
	<body>
		<form action = "LoginSuccess.html" method="post" onsubmit="return f_validateInfo(this)">
	<table background="../img/bg_img1.jpg" width="930" height="450">
		<tr height="130">
			<td width="580"></td>
			<td>&nbsp;</td>
		</tr>
		
		<tr>
			<td>&nbsp;</td>
			<td>
		<table>
			<tr>
			<td>用户登录:
				<input type = "text" name = "username" id = "username"/>
			</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>
				
             </td>
             <td></td>
				<td></td>
			</tr>
				<tr>
			<td>
			&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码&nbsp;:
			<input type = "password" name = "password" id = "password"/>
			</td>
			<td></td>
				<td></td>
			</tr>
			
			<tr>
				<td >
				
             </td>
             <td></td>
				<td></td>
			</tr>
             
             <tr>
             	<td>&nbsp;验&nbsp;证&nbsp;码:
             	<input type = "text" name = "checkCode" onblur="testBlur()"/>
             	</td> 
             	<td></td>
             </tr>
             
             <tr>
             	<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type = "checkbox" />自动登录
             		<img src = "../img/bg_img2.gif"/>
                     <input type = "button" value = "刷新"/>
             	</td>
             </tr>	
		<tr align="center">
	<td colspan="3">
		<input type = "submit" value = "登录" />
			<a href = "LoginSuccess.html"><input type="button" value="注册"></a>
	</td>
</tr>
		</table>
		</td>	
		</tr>
	</table>
	</form>
	</body>
</html>
