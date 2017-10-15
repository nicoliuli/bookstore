package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.pojo.User;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//需要拦截的是加入购物车的url
		///bookstore/findShopCart.action
		///bookstore/addIntoShopCart.action
		String url = request.getRequestURI();	//如果是加如购物车的地址，查看购物车，查看订单，先判断是否已登录
		
		
		if(url.startsWith("/bookstore/findShopCart.action") || url.startsWith("/bookstore/addIntoShopCart.action") || url.startsWith("/bookstore/gotoMyItem.action")){
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("u");
			if(u != null){	//如果已经登录，放行
				return true;
			}else{	//如果没有登录，跳转到登录页面
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
				return false;
			}
		}
		
		//其他地址不拦截
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object hander, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
