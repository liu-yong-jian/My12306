package at.danicoz.user.servlet;

import java.awt.TexturePaint;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.danicoz.user.po.CertType;
import at.danicoz.user.po.City;
import at.danicoz.user.po.User;
import at.danicoz.user.po.UserType;
import at.danicoz.user.service.UserService;
import at.danicoz.util.MD5Utils;
import at.danicoz.util.TextUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取请求参数
		User user = new User();
		populate(request,user);
		
		user.setRule("2");
		user.setStatus("1");
		//System.out.println("cityId="+user.getCity().getId());
		
		String msg = validate(user);
		if(TextUtils.isEmpty(msg)){
			UserService userService = UserService.getInstance();
			
			//用户名是否重复
			User tmp = new User();
			tmp.setUsername(user.getUsername());
			User dbUser = userService.findUser(tmp);
			if(dbUser == null){
				user.setPassword(MD5Utils.md5(user.getPassword()));
				userService.addUser(user);
				msg = "注册成功";
			}
			else{
				msg = "用户名重复";
			}
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>注册信息</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>"+msg+"</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
	
	private String validate(User user) {
		// TODO Auto-generated method stub
		String errorMsg = null;
		
		//用户名判断
		if(TextUtils.isEmpty(user.getUsername())){
			errorMsg = "请输入用户名！";
		}else if(user.getUsername().length()<6
				|| user.getUsername().length()>30){
			errorMsg = "用户名长度在6~30位之间";
		}else if(!user.getUsername().matches("[a-zA-Z0-9_]{6,30}")){
			errorMsg = "用户名只能由字母，数字或 “_”";
		}
		
		//密码判断
		else if(TextUtils.isEmpty(user.getPassword())){
			errorMsg = "请输入密码";
		}
		else if(!user.getPassword().equals(user.getPassword2())){
			errorMsg = "两次密码不相等";
		}
		
		//判断真实姓名
		else if(TextUtils.isEmpty(user.getRealname())){
			errorMsg = "请输入真实姓名";
		}
		
		//判断城市
		else if(user.getCity().getId() == null){
			errorMsg = "请选择所在的城市";
		}
		
		//判断证件号码
		else if(TextUtils.isEmpty(user.getCert())){
			errorMsg = "请输入证件号码";
		}
		
		//判断出生日期
		else if(user.getBirthday() == null){
			errorMsg = "请输入出生日期";
		}
		
		return errorMsg;
	}

	private void populate(HttpServletRequest request, User user) {
		// TODO Auto-generated method stub
		//获取客户端的 IP
		String loginIP = request.getRemoteAddr();
		//获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		
		//需要修改的前台代码
		String cityId = request.getParameter("city");
		String certTypeId = request.getParameter("certType");
		String cert = request.getParameter("cert");
		
		String birthday = request.getParameter("birthday");
		String userTypeId = request.getParameter("userType");
		String content = request.getParameter("content");
		
		user.setLoginIp(loginIP);
		user.setUsername(username);
		user.setPassword(password);
		user.setPassword2(password2);
		user.setRealname(realname);
		user.setSex(sex);
		
		//City
		//System.out.println("cityId="+cityId);
		City city = new City();
		city.setId(Integer.parseInt(cityId));
		user.setCity(city);
		
		
		//CertType
		CertType certType = new CertType();
		certType.setId(Integer.parseInt(certTypeId));
		user.setCertType(certType);
		
		//cert
		user.setCert(cert);
		
		//birthday
		if(!TextUtils.isEmpty(birthday)){
			user.setBirthday(Date.valueOf(birthday));
		}
		
		//UserType
		UserType userType = new UserType();
		userType.setId(Integer.parseInt(userTypeId));
		user.setUserType(userType);
		
		//content
		user.setContent(content);
		
		
	}	
}
