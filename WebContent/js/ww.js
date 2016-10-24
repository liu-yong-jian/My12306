
(function(){
    
	$(document).ready(function() {
	   if($('#submitOrder_id')[0]){
	      $('#submitOrder_id').attr('style','display:none');
	   }
	   var targetdivNode = document.getElementById(targetdiv[0]);
		//引入对应的JS
		var gs = document.createElement("script");
		gs.type = "text/javascript";
		gs.charset = "utf-8";
		gs.async = true;
		gs.src = ctx+"resources/js/oldpasscode/passcode.js";
		
		
		for (var i = 0; i<targetelement.length;i++){
		    var code_type = $("#"+targetdiv[i]).data("code_type");
		   var html =  "<li><span class=\"label\">验证码：</span><div class=\"yzm\" style=\"padding: 0px\"><input type=\"text\" name=\"randCode\" data-targetdiv=\""+targetdiv[i]+ "\" tabindex=\"3\" id=\"randCode\" maxlength=\"4\" class=\"inptxt w100\"><input type=\"hidden\" id=\"randCode_validate\" name=\"randCode_validate\"/><span class=\"code\" id=\"img-check\"><img style=\"width: 100%;height: 100%\" src=\"../passcodeNew/getPassCodeNew?module=login&rand=sjrand&\" title=\"单击刷新验证码\"onclick=\"refreshImg('login','sjrand')\" id=\"img_rand_code\"></span><span class=\"i-re\" onclick=\"refreshImg('login','sjrand')\" title=\"单击刷新验证码\"></span></div><div class=\"\"><span class=\"tip i-ok i-ok"+targetdiv[i]+"\" id=\"i-ok"+targetdiv[i]+"\" style=\"display: none;\"></span></div></li><li id=\"error_msg"+targetdiv[i]+"\"  style=\"display: none;margin-left: 70px ;margin-top: 5px;padding-left:20px;\"class=\"error error_msg_li error_msg"+targetdiv[i]+"\"></li>";
		    if (typeof code_type !== "undefined" && code_type !== null) {
			if("" == targetelement[i]){
			   if(code_type == "regist"){
			       html="<li><div class=\"label\"><span class=\"required\">*</span>验证码：</div><div class=\"yzm\" style=\"padding: 0px\"><input type=\"text\" name=\"randCode\" data-targetdiv=\""+targetdiv[i]+"\" id=\"randCode\" maxlength=\"4\" class=\"inptxt w100\"><input type=\"hidden\" id=\"randCode_validate\" name=\"randCode_validate\"/><span class=\"img\" id=\"img-check\"><img style=\"width: 100%;height: 100%\" src=\"../passcodeNew/getPassCodeNew?module=regist&rand=sjrand&\" title=\"单击刷新验证码\"onclick=\"refreshImg('regist','sjrand')\" id=\"img_rand_code\"></span><span class=\"i-re\" onclick=\"refreshImg('regist','sjrand')\" title=\"单击刷新验证码\"></span></div><div class=\"tips\"><span class=\"icon i-ok i-ok"+targetdiv[i]+"\" id=\"i-ok"+targetdiv[i]+"\" style=\"display: none;\"></span></div></li><label id=\"error_msg"+targetdiv[i]+"\"  style=\"display: none;\"class=\"error error_msg"+targetdiv[i]+"\"></label>";
			    }else if(code_type == "findpassword"){
				  html="<li><div class=\"label\"><span class=\"required\">*</span>验证码：</div><div class=\"yzm\" style=\"padding: 0px\"><input type=\"text\" name=\"randCode\" data-targetdiv=\""+targetdiv[i]+ "\" id=\"randCode\" maxlength=\"4\" class=\"inptxt w100\"><input type=\"hidden\" id=\"randCode_validate\" name=\"randCode_validate\"/><span class=\"img\" id=\"img-check\"><img style=\"width: 100%;height: 100%\" src=\"../passcodeNew/getPassCodeNew?module=findpassword&rand=sjrand&\" title=\"单击刷新验证码\"onclick=\"refreshImg('findpassword','sjrand')\" id=\"img_rand_code\"></span><span class=\"i-re\" onclick=\"refreshImg('findpassword','sjrand')\" title=\"单击刷新验证码\"></span></div><div class=\"tips\"><span class=\"icon i-ok i-ok"+targetdiv[i]+"\" id=\"i-ok"+targetdiv[i]+"\" style=\"display: none;\"></span></div></li><label id=\"error_msg"+targetdiv[i]+"\"  style=\"display: none;padding-top:3px;margin-top:10px;\"class=\"error error_msg"+targetdiv[i]+"\"></label>";
			    }else if(code_type == "passenger"){
				 html="<li id=\"code_rand\"><span class=\"label\"  th:text=\"#{randCode}\">验证码：</span><input id=\"randCode\" tabindex=\"3\"  name=\"randCode\" data-targetdiv=\""+targetdiv[i]+ "\" type=\"text\" maxlength=\"4\" class=\"inptxt w100\" />	<span class=\"code\" id=\"img-check\"><img style=\"width: 120px;height:40px;margin-top:-20px;position: relative;top: 13px;\" src=\"../passcodeNew/getPassCodeNew?module=passenger&rand=randp&\"  onclick=\"refreshImg('passenger','randp')\""+"title=\"单击刷新验证码\" id=\"img_rand_code\"/></span>	<span class=\"i-re\" onclick=\"refreshImg('passenger','randp')\" title=\"单击刷新验证码\"></span>	<span class=\"tip i-ok i-ok"+targetdiv[i]+"\" id=\"i-ok"+targetdiv[i]+"\" style=\"display:none;margin-left:10px;margin-bottom:-4px;\"></span> </li><li class=\"error error_msg"+targetdiv[i]+"\" id=\"error_msg"+targetdiv[i]+"\" style=\"display: none; margin-top:-2px;margin-left:10px;padding-top:8px\"></li><input type=\"hidden\" id=\"randCode_validate\" name=\"randCode_validate\"/>";
			    }
		      }else{
		         if(code_type == "regist"){
				 html="<li><div class=\"label\"><span class=\"required\">*</span>验证码：</div><div class=\"yzm\" style=\"padding: 0px\"><input type=\"text\" name=\"randCode\" data-targetdiv=\""+targetdiv[i]+ "\" id=\"randCode\" maxlength=\"4\" class=\"inptxt w100\"><input type=\"hidden\" id=\"randCode_validate\" name=\"randCode_validate\"/><span class=\"img\" id=\"img-check\"><img style=\"width: 100%;height: 100%\" src=\"../passcodeNew/getPassCodeNew?module=regist&rand=sjrand&\" title=\"单击刷新验证码\"onclick=\"refreshImg('regist','sjrand')\" id=\"img_rand_code\"></span><span class=\"i-re\" onclick=\"refreshImg('regist','sjrand')\" title=\"单击刷新验证码\"></span></div><div class=\"tips\"><span class=\"icon i-ok"+targetdiv[i]+"\" id=\"i-ok"+targetdiv[i]+"\" style=\"display: none;\"></span></div></li><label id=\"error_msg"+targetdiv[i]+"\"  style=\"display: none;\"class=\"error\"></label>";
			    }else if(code_type == "findpassword"){
				 html="<li><div class=\"label\"><span class=\"required\">*</span>验证码：</div><div class=\"yzm\" style=\"padding: 0px\"><input type=\"text\" name=\"randCode\" data-targetdiv=\""+targetdiv[i]+"\" id=\"randCode_"+targetelement[i]+"\" maxlength=\"4\" class=\"inptxt w100\"><input type=\"hidden\" id=\"randCode_validate\" name=\"randCode_validate\"/><span class=\"img\" id=\"img-check_"+targetelement[i]+"\"><img style=\"width: 100%;height: 100%\" src=\"../passcodeNew/getPassCodeNew?module=findpassword&rand=sjrand&\" title=\"单击刷新验证码\"onclick=\"refreshImg('findpassword','sjrand','"+targetelement[i]+"')\" id=\"img_rand_code_"+targetelement[i]+"\"></span><span class=\"i-re\" onclick=\"refreshImg('findpassword','sjrand','"+targetelement[i]+"')\" title=\"单击刷新验证码\"></span></div><div class=\"tips\"><span class=\"icon i-ok i-ok"+targetdiv[i]+"\" id=\"i-ok"+targetdiv[i]+"\" style=\"display: none;\"></span></div></li><label id=\"error_msg"+targetdiv[i]+"\"  style=\"display: none;\"class=\"error error_msg"+targetdiv[i]+"\"></label>";
			    }else if(code_type == "passenger"){
				 html="<li id=\"code_rand\"><span class=\"label\"  th:text=\"#{randCode}\">验证码：</span><input id=\"randCode\" data-targetdiv=\""+targetdiv[i]+ "\" tabindex=\"3\"  name=\"randCode\" type=\"text\" maxlength=\"4\" class=\"inptxt w100\" />	<span class=\"code\" id=\"img-check\"><img style=\"width: 120px;height: 40\" src=\"../passcodeNew/getPassCodeNew?module=passenger&rand=randp&\"  onclick=\"refreshImg('passenger','randp')\""+"title=\"单击刷新验证码\" id=\"img_rand_code\"/></span>	<span class=\"i-re\" onclick=\"refreshImg('passenger','randp')\" title=\"单击刷新验证码\"></span>	<span class=\"tip i-ok i-ok"+targetdiv[i]+"\" id=\"i-ok"+targetdiv[i]+"\" style=\"display:none\"></span> </li><li id=\"error_msg"+targetdiv[i]+"\" class=\"error error_msg"+targetdiv[i]+"\" style=\"display: none; margin-top:-2px;margin-left:10px;padding-top:8px\"></li><input type=\"hidden\" id=\"randCode_validate\" name=\"randCode_validate\"/>";
			    }else if(code_type == "login"){
		         html =  "<li><div class=\"yzm\" style=\"padding: 0px\"><span class=\"label\">验证码：</span><input type=\"text\" name=\"randCode2\" data-targetdiv=\""+targetdiv[i]+ "\" tabindex=\"3\" id=\"randCode_"+targetelement[i]+"\" maxlength=\"4\" class=\"inptxt w100\"><input type=\"hidden\" id=\"randCode_validate\" name=\"randCode_validate\"/><span class=\"code\" id=\"img-check_"+targetelement[i]+"\"><img style=\"width: 100%;height: 100%\" src=\"../passcodeNew/getPassCodeNew?module=login&rand=sjrand&\" title=\"单击刷新验证码\"onclick=\"refreshImg('login','sjrand','"+targetelement[i]+"')\" id=\"img_rand_code_"+targetelement[i]+"\"></span><span class=\"i-re\" onclick=\"refreshImg('login','sjrand','"+targetelement[i]+"')\" title=\"单击刷新验证码\"></span></div><div class=\"\"><span class=\"tip i-ok i-ok"+targetdiv[i]+"\"  id=\"i-ok"+targetdiv[i]+"\" style=\"display: none;margin-top:5px;\"></span></div></li><li id=\"error_msg"+targetdiv[i]+"\"  style=\"display: none;margin-left: 285px ;margin-top: -19px;\"class=\"error error_msg"+targetdiv[i]+"\"></li>";
			    }
		      }
			 
			$(html).insertAfter($('#'+targetdiv[i]));
				//targetdivNode = document.getElementById(targetdiv[i]);
			    //targetdivNode.insertAdjacentHTML("afterEnd",html);
		    }
		}

		targetdivNode = document.getElementById(targetdiv[0]);
		targetdivNode.insertBefore(gs, null);
	});
})();

jQuery.cookie = function (name, value, options)
{
    if (typeof value != 'undefined')
    { // name and value given, set cookie
        options = options || {};
        if (value === null)
        {
            value = '';
            options.expires = -1;
        }
        var expires = '';
        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString))
        {
            var date;
            if (typeof options.expires == 'number')
            {
                date = new Date();
                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
            } else
            {
                date = options.expires;
            }
            expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
        }
        var path = options.path ? '; path=' + options.path : '';
        var domain = options.domain ? '; domain=' + options.domain : '';
        var secure = options.secure ? '; secure' : '';
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else
    { // only name given, get cookie
        var cookieValue = null;
        if (document.cookie && document.cookie != '')
        {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++)
            {
                var cookie = jQuery.trim(cookies[i]);
                // Does this cookie string begin with the name we want?
                if (cookie.substring(0, name.length + 1) == (name + '='))
                {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
};