package cn.itcast.ssm.controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

//登录或注册时需要输入验证码
@Controller
public class GetRandomNum{
	public int width = 120;	//图片宽度
	public int height = 40;	//图片高度
	@RequestMapping("/getImg.action")
	public void testImg(HttpServletResponse response,HttpSession session) throws Exception{
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) image.getGraphics();

		//1、设置背景色
		setBackGround(g);
		//2、设置边框
		setBorder(g);
		//3、画干扰线
		drawRandomLine(g);
		//4、写随机数,并返回产生的随机数
		String str= drawRandomNum(g);
		session.setAttribute("randomNum",str);//将产生的随机数放在Session域，在登录或注册的Controller中取值验证
		//设置浏览器以图片的方式打开
		response.setContentType("image/jpeg");
		//告诉浏览器不要缓存
		response.setHeader("expries","-1");
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		//5、写给浏览器
		ImageIO.write(image,"jpg",response.getOutputStream());
		//不要有返回
	}
	
	//设置背景颜色
	private void setBackGround(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
	}
	//设置边框
	private void setBorder(Graphics g){
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, width-2, height-2);
	}
	//画干扰线
	private void drawRandomLine(Graphics g){
		g.setColor(Color.GREEN);
		for(int i = 0;i<5;i++){
			int x1 = new Random().nextInt(width);
			int y1 = new Random().nextInt(height);
			int x2 = new Random().nextInt(width);
			int y2 = new Random().nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
	}
	//产生随机数
	private String drawRandomNum(Graphics2D g){
		String str = "";
		//设置字体颜色
		g.setColor(Color.RED);
		g.setFont(new Font("宋体",Font.BOLD,20));
		String base = "abcdefghijklmnopqrstuvwxyz123456789";
		int x = 5;//字体的位置
		for(int i = 0;i<4;i++){
			int degree = new Random().nextInt()%30;//旋转角度
			int index = new Random().nextInt(base.length());
			
			String ch = base.charAt(index)+"";
			str += ch;	//将产生的随机数拼接起来返回，后台验证
			g.rotate(degree*Math.PI/180, x,height);
			g.drawString(ch, x, 20);
			g.rotate(-degree*Math.PI/180, x, height);
			x+= 30;
		}
		return str;
	}
}
