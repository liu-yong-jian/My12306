package at.danicoz.user.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateCodeServlet
 */
@WebServlet("/ValidateCodeServlet")
public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private char code[] = {'a','b','c','d','e','f','g','h','i','f',
			'k','p','q','w','v','m','n','z','x','y','t','u','3','2','4','5','6','7','8','9','A','B','C','D','E','F','G','H','F','I'};
	
	//定义验证码图片的宽度和高度
	private static final int WIDTH = 50;
	private static final int HEIGHT = 20;
	
	//定义验证码的位数
	private static final int LENGTH = 4;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateCodeServlet() {
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
		//设置响应头信息
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		//设置相应的 MIME 类型
		response.setContentType("image/jpeg");
		
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		//设置字体
		Font font = new Font("Arial", Font.TRUETYPE_FONT, 18);
		
		
		//创建 Graphics 对象，用于实现对图片背景颜色，边框等设置，BufferedImage 没有这功能
		Graphics g = image.getGraphics();
		
		//产生随机数
		Random rd = new Random();
		
		//设置背景颜色
		g.setColor(new Color(rd.nextInt(55)+200,rd.nextInt(55)+200,rd.nextInt(55)+200));
		//填充
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//设置字体
		g.setFont(font);
		
		
		//画边框
		g.setColor(Color.black);
		g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
		
		//随机产生的验证码
		String result = "";
		for(int i=0;i<LENGTH;i++){
			result+= code[rd.nextInt(code.length)];
		}
		//System.out.println(result);
		
		HttpSession session = request.getSession();
		session.setAttribute("code", result);
		
		//画验证码
		for(int i =0;i<result.length();i++){
			g.setColor(new Color(rd.nextInt(200),rd.nextInt(200),rd.nextInt(200)));
			g.drawString(result.charAt(i)+"", 12*i+1, 16);
		}
		
		//干扰线
		for(int i =0;i<2;i++){
			g.setColor(new Color(rd.nextInt(200),rd.nextInt(200),rd.nextInt(200)));
			 int x1 = rd.nextInt(WIDTH);
			 int x2 = rd.nextInt(WIDTH);
			 int y1 = rd.nextInt(HEIGHT);
			 int y2 = rd.nextInt(HEIGHT);
			 
			 g.drawLine(x1, y1, x2, y2);
		}
		
		//释放图片资源
		g.dispose();
		try{
			OutputStream os = response.getOutputStream();
			
			//输出图片资源
			ImageIO.write(image, "JPEG", os);
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	

}
