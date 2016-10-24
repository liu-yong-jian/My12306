<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看个人信息</title>
<link href="../css/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
	function UpdateInfo(){
	window.navigate("UserManageInfo_Edit.html");
	}
</script>
</head>
<body class="write_bg">
<form name="form1" method="post" action="">
  <table width="100%" border="0" cellspacing="0">
    <tr>
      <td height="30">&nbsp;</td>
    </tr>
  </table>
  <table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20" colspan="2" align="center" ></td>
  </tr>
  <tr>
    <td width="64" align="center" ></td>
    <td width="771" height="30" align="left" valign="top" ><span class="text_blod_title">查看个人信息</span></td>
  </tr>
  <tr>
    <td height="15" colspan="2" ><img src="../images/line1.jpg" width="835" height="6"></td>
  </tr>
  <tr>
    <td colspan="2" valign="top"  ><table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="20" colspan="4"  ></td>
          </tr>
          <tr>
            <td height="15" colspan="4" align="left" class="text_title">个人详细信息</td>
          </tr>
          <tr>
            <td height="10" colspan="4" ></td>
          </tr>
          
          <tr>
            <td width="20" height="40" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">登录名：</td>
            <td width="350" align="left" class="text_cray">用户1</td>
            <td width="230" rowspan="5" align="center" background="../images/bg_point_write.gif" class="text_cray"><img src="../images/photo.jpg" width="139" height="139"></td>
          </tr>
          <tr>
            <td width="20" height="40" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">真实姓名：</td>
            <td align="left" class="text_cray">王小明</td>
          </tr>
          <tr>
            <td width="20" height="40" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">性 别：</td>
            <td align="left" class="text_cray">男</td>
          </tr>
          <tr>
            <td width="20" height="40" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">省份：</td>
            <td align="left" class="text_cray">辽宁</td>
          </tr>
          <tr>
            <td width="20" height="40" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">城市：</td>
            <td align="left" class="text_cray">沈阳</td>
          </tr>
          <tr>
            <td width="20" height="40" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">证件类型：</td>
            <td colspan="2" align="left" class="text_cray">二代身份证</td>
          </tr>
          <tr>
            <td width="20" height="40" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">证件号码：</td>
            <td colspan="2" align="left" class="text_cray">220221199802051028</td>
          </tr>
          <tr>
            <td width="20" height="40" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">出生日期：</td>
            <td colspan="2" align="left" class="text_cray">1998-2-5</td>
          </tr>
          <tr>
            <td width="20" height="40" ></td>
            <td width="100" height="40" align="left" class="text_cray1">旅客类型：</td>
            <td colspan="3" align="left" class="text_cray">学生</td>
          </tr>
          <tr>
            <td width="20" height="40"></td>
            <td width="100" height="40" align="left" class="text_cray1">备注：</td>
            <td height="40" colspan="2" align="left" class="text_cray">无</td>
          </tr>
        </table><br>
      <table width="100%" border="0" cellspacing="0">
        <tr>
          <td></td>
        </tr>
      </table>
      <table width="263" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="30" align="center"><input name="button" type="button" class="butxg" id="button"value="" onClick="UpdateInfo()"></td>
          </tr>
      </table>
    </table>
  <table width="100%" border="0" cellspacing="0">
    <tr>
      <td height="20"></td>
    </tr>
  </table>  
  <table width="100%" border="0" cellspacing="0">
    <tr>
      <td height="2" background="../images/bottom_point.gif"></td>
    </tr>
    <tr>
      <td height="25" align="center" background="../images/bottom_ny_bg.gif" class="text_cray">copyright@12306 购票网</td>
    </tr>
  </table>
  </td>
  </tr>
</table>
</form>
</body>
</html>
