<%@page import="at.danicoz.util.TextUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%-- 自动登录 --%>
    <%
	String username = "";
	String autoLogin = "";
	
	Cookie cookies[] = request.getCookies();
	if(cookies != null && cookies.length>0){
		for(Cookie c : cookies){
			if("username".equals(c.getName())){
				username = c.getValue();
			}else if("autoLogin".equals(c.getName())){
				autoLogin = c.getValue();
			}
		}
	}
	String action = request.getParameter("action");
	//退出不自动登录
	if(!"logout".equals(action)){
		if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(autoLogin)){
			response.sendRedirect(request.getContextPath()+"/LoginServlet?action=autoLogin");
		}
	}
    
    %>
    
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
		
		<script type="text/javascript">
		function reLoadCode(){
			document.getElementById("codeimg").src="ValidateCodeServlet?"+new Date();
		}
		</script>
		
		
		
	</head>
	<body>
		<form action = "LoginServlet?action=login" method="post" onsubmit="return f_validateInfo(this)">
	<table background="images/bg_img1.jpg" width="930" height="450">
		<tr height="100">
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
			&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码&nbsp;:
			<input type = "password" name = "password" id = "password"/>
			</td>
			<td></td>
				<td></td>
			</tr>
             
             <tr>
             	<td>&nbsp;验&nbsp;证&nbsp;码:
             	<input type = "text" name = "code" onblur="testBlur()"/>
             	</td> 
             	<td>
             		<img id = "codeimg" src = "ValidateCodeServlet" alt="点击换一张"  onclick="reLoadCode()" height=20/>
             		</td>
             		<td>
                     <input type = "button" value = "刷新" onclick="reLoadCode()"/>
             	</td>
             </tr>
             
             <tr>
             	<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type = "checkbox" name = "autoLogin"/>自动登录
             	</td>
             </tr>
             	
		<tr align="center">
	<td colspan="3">
		<input type = "submit" value = "登录" />
			<a href = "UserRegistration.html"><input type="button" value="注 册"></a>
	</td>
</tr>

		</table>
		<% 
             String msg = (String)request.getAttribute("msg");
             if(!TextUtils.isEmpty(msg)){
             %>
             <%= msg %>
             
             <% } %>
		</td>	
		</tr>
	</table>
	   
	</form>
	</body>
</html>
