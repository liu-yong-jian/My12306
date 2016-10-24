package at.danicoz.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import at.danicoz.user.po.User;
import at.danicoz.user.service.UserService;
import at.danicoz.util.MD5Utils;
import at.danicoz.util.TextUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String action = request.getParameter("action");
		//System.out.println("action="+action);
		if(action == null || "login".equals(action)){
			doLogin(request,response);
		}else if("autoLogin".equals(action)){
			doAutoLogin(request,response);
		}
	}

	//判断 URL 带的参数区分是点击登录还是自动登录
	private void doAutoLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
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
		
		
		
		if(TextUtils.isEmpty(username) || TextUtils.isEmpty(autoLogin)){
			response.sendRedirect(request.getContextPath()+"/Login.jsp");
		}else{
			UserService userService = UserService.getInstance();
			User one = new User();
			one.setUsername(username);
			
			User dbUser = userService.findUser(one);
			if(autoLogin.equals(MD5Utils.md5(username+","+dbUser.getPassword()))){
				//更新 IP
				User user = new User();
				populate(request, user);
				
				one = new User();
				one.setId(dbUser.getId());
				one.setLoginIp(user.getLoginIp());
				userService.updateUser(one);
				
				dbUser.setLoginIp(user.getLoginIp());
				
				HttpSession session = request.getSession();
				session.setAttribute("user", dbUser);
				
				//System.out.println(username+autoLogin);
				response.sendRedirect(request.getContextPath()+"/User/Index.jsp");
			}else{
				Cookie c = new Cookie("username","");
				c.setMaxAge(0);
				c.setPath("/");
				response.addCookie(c);
				
				Cookie c1 = new Cookie("autoLogin","");
				c1.setMaxAge(0);
				c1.setPath("/");
				response.addCookie(c1);
				
				response.sendRedirect(request.getContextPath()+"/Login.jsp");
				
			}
		}
	}

	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
		//创建 Session 对象，用于保存数据
		//System.out.println("doLogin....");
		HttpSession session = request.getSession();
		
		//获取请求参数
		User user = new User();
		//System.out.println("---pass001---");
		
		populate(request,user);
		//System.out.println("---pass002---");
		
		//服务器验证
		String msg = validate(user);
		//System.out.println("---pass003---"+msg);
	
		if(TextUtils.isEmpty(msg)){
			String code = (String) session.getAttribute("code");
		//System.out.println("code="+code);
			//验证码比较
			if(!user.getCode().equalsIgnoreCase(code)){
				//System.out.println("Code...");
				msg = "验证码错误";
				request.setAttribute("msg", msg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				//调用Service 方法
				UserService userService = UserService.getInstance();
				
				//检查用户是否存在
				User dbUser = userService.login(user.getUsername(),user.getPassword());
				if(dbUser == null){
					msg = "用户名或密码错误";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else{
					User one = new User();
					one.setId(dbUser.getId());
					one.setLoginIp(user.getLoginIp());
					userService.updateUser(one);
					
					dbUser.setLoginIp(user.getLoginIp());
					session.setAttribute("user", dbUser);
					//response.sendRedirect(request.getContextPath()+"/main.jsp");
					
					//保存上次登录的用户名
					Cookie c =new Cookie("username",dbUser.getUsername());
					c.setMaxAge(365*24*60);
					c.setPath("/");//作用域
					response.addCookie(c);
					
					//自动登陆 判断
					if(user.isAutoLogin()){
						Cookie cLogin = new Cookie("autoLogin",MD5Utils.md5(dbUser.getUsername()+","+dbUser.getPassword()));
						cLogin.setMaxAge(365*24*60);
						cLogin.setPath("/");//作用域
						response.addCookie(cLogin);
					}
					else{
						Cookie cLogin = new Cookie("autoLogin","");
						cLogin.setMaxAge(0);
						cLogin.setPath("/");//作用域
						response.addCookie(cLogin);
					}
					response.sendRedirect(request.getContextPath()+"/User/Index.jsp");
				}
			}
		}
		else{
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
		
	}
	
	//验证
	private String validate(User user) {
		String errorMsg = null;
		
		if(TextUtils.isEmpty(user.getUsername())){
			errorMsg = "请输入用户名";
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
		//验证码
				else if(TextUtils.isEmpty(user.getCode())){
					errorMsg = "请输入验证码";
				}
		return errorMsg;
	}

	//获取请求参数，并封装对象
	private void populate(HttpServletRequest request, User user) {
		// TODO Auto-generated method stub
		//获取客户端的 IP
		String loginIP = request.getRemoteAddr();
		//获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String autoLogin = request.getParameter("autoLogin");
		String code = request.getParameter("code");
		
		//System.out.println(username+"   "+password+"  "+autoLogin+"  "+code);
		
		user.setLoginIp(loginIP);
		user.setUsername(username);
		
		//安全需加密
		if(password!=null){
			user.setPassword(MD5Utils.md5(password));
		}
		
		if(TextUtils.isEmpty(autoLogin)){
			user.setAutoLogin(false);
		}else{
			user.setAutoLogin(true);
		}
		
		user.setCode(code);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
