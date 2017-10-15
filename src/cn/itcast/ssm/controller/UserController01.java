package cn.itcast.ssm.controller;

import java.security.MessageDigest;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.BASE64Encoder;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.service.UserService;

@Controller
public class UserController01{
	private UserService userService;
	
	//用户注册时检查用户名是否存在
	public boolean findUserByUsername(User u) throws Exception{
		List<User> userList = userService.findUserByUsername(u);
		if(userList == null || userList.size()<=0)	//如果不存在，说明可以注册
			return true;
		return false;
	}
	
	//将新注册的用户添加到数据库中
	@RequestMapping("/insertUser.action")
	public ModelAndView insertUser(User u,String randomNum,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		if(u.getUsername().equals("") || u.getPassword().equals("")){//如果用户输入用户名或密码
			session.removeAttribute("randomNum");//及时移去session中的验证码信息
			modelAndView.addObject("warning","请输入用户名或密码");
			modelAndView.setViewName("/WEB-INF/jsp/register.jsp");
			return modelAndView;
		}
		boolean Register = this.findUserByUsername(u);
		if(Register == true){//表示可以注册
			if(randomNum.equals(session.getAttribute("randomNum"))){//验证码也输入正确
				session.removeAttribute("randomNum");//及时移去session中的验证码信息
				//将注册的密码转为MD5码存入数据库
				String password = u.getPassword();
				MessageDigest md = MessageDigest.getInstance("md5");	//也可以改为SHA算法
				byte [] md5 = md.digest(password.getBytes());
				BASE64Encoder encoder = new BASE64Encoder();
				password = encoder.encode(md5);
				System.out.println("转码后的密码是："+password);
				u.setPassword(password);
				userService.insertUser(u);	//将注册信息添加到数据库
				request.getRequestDispatcher("/index.jsp").forward(request, response);	//跳转到首页
			}else{	//用户名输入正确但验证码输入错误
				session.removeAttribute("randomNum");//及时移去session中的验证码信息
				request.setAttribute("warning","验证码输入错误");
				request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);	//跳转到注册页面页面重新注册
			}
		}else{	//表示不能注册,用户名已存在
			session.removeAttribute("randomNum");//及时移去session中的验证码信息
			modelAndView.addObject("warning","对不起，该用户名已存在");
			modelAndView.setViewName("/WEB-INF/jsp/register.jsp");	//跳转到注册页面页面重新注册
		}
		return modelAndView;
	}
	
	//用户登录时判断用户的用户名和密码是正确
	@RequestMapping("/findUsernameAndPassword.action")
	public String findUsernameAndPassword(User u,String randomNum,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		if(u.getUsername().equals("") || u.getPassword().equals("")){//如果用户输入用户名或密码
			session.removeAttribute("randomNum");//及时移去session中的验证码信息
			/*~~*/
			request.setAttribute("warning","请输入用户名或密码");			
			return "/WEB-INF/jsp/login.jsp";
		}
		//将用户的登陆信息转为MD5码后和数据库比对
		String password = u.getPassword();
		MessageDigest md = MessageDigest.getInstance("md5");	//也可以改为SHA算法
		byte [] md5 = md.digest(password.getBytes());
		BASE64Encoder encoder = new BASE64Encoder();
		password = encoder.encode(md5);
		u.setPassword(password);
		
		System.out.println("登陆的密码是："+u.getPassword());
		User user = userService.findUsernameAndPassword(u);	//从数据库里查到的用户名和密码
		System.out.println("从数据库里查到的密码是："+user.getPassword());
		
		
		if(user != null){	//
			if(user.getUsername() != null && user.getPassword()!=null){
				//用户名，密码正确
				if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())){
					if(randomNum.equals(session.getAttribute("randomNum"))){//输入的验证码正确
						session.removeAttribute("randomNum");//及时移去session中的验证码信息
						session.setAttribute("u",user);	//将登录信息存放到session域
						
						Cookie cookie = new Cookie("JSESSIONID",session.getId());
						cookie.setPath("/bookstore");
						cookie.setMaxAge(60*30);	//cookie的有效期是30min
						response.addCookie(cookie);
						/*~~*/
						response.sendRedirect("/bookstore/index.jsp");//登录成功,重定向到首页
					
						return null;
					}else{//用户名密码正确但验证码错误
						session.removeAttribute("randomNum");//及时移去session中的验证码信息
						
						/*~~*/
						request.setAttribute("warning","验证码错误");
						return "/WEB-INF/jsp/login.jsp";//验证码错误，跳转到登录页面重新登录
					}		
				}else{
					session.removeAttribute("randomNum");//及时移去session中的验证码信息
					
					/*~~*/
					request.setAttribute("warning","对不起，您的用户名或密码输入错误");
					return "/WEB-INF/jsp/login.jsp";//登录失败，跳转到登录页面重新登录
				}
			}	
		}
		/*~~*/
		request.setAttribute("warning","对不起，您的用户名或密码输入错误");
		return "/WEB-INF/jsp/login.jsp";//登录失败，跳转到登录失败页面重新登录
	}
	
	
	//跳转到用户登录
	@RequestMapping("/login.action")
	public ModelAndView login() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/login.jsp");
		return modelAndView;	
	}
	
	//注销用户
	@RequestMapping("/invalidate.action")
	public ModelAndView invalidate(HttpSession session) throws Exception{
		session.invalidate();//注销用户
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/index.jsp");//跳转到首页
		return modelAndView;
	}
	
	//跳转到用户注册
	@RequestMapping("/register.action")
	public ModelAndView register() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/register.jsp");
		return modelAndView;	
	}
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
