package cn.itcast.ssm.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.pojo.Shopcart;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.pojo.UserBook;
import cn.itcast.ssm.service.BookService;
import cn.itcast.ssm.service.ShopCartService;
import cn.itcast.ssm.service.UserService;

@Controller
public class ShopCartController01{
	private UserBook userBook;
	private ShopCartService shopcartService;
	
	//查看购物车，根据客户的id
	@RequestMapping("/findShopCart.action")
	public ModelAndView findShopCart(Integer userid) throws Exception{
		System.out.println("查看用户id:"+userid);
		ModelAndView modelAndView = new ModelAndView();
		User u = shopcartService.findShopCart(userid);	//根据用户id查看用户的购物车
		
		
		modelAndView.addObject("user", u);
		modelAndView.setViewName("/WEB-INF/jsp/findshopcart.jsp");
		return modelAndView;
	}
	
	//加入购物车
	@RequestMapping("/addIntoShopCart.action")
	public String addIntoShopCart(UserBook userBook) throws Exception{
		this.userBook = userBook;
		
		//先查找购物车中是否有此书
		//select count(book_number) from shopcart where book_id=#{book_id} and user_id=#{user_id}
		int count = shopcartService.isInShopcart(userBook);//返回1或0，代表有或无
		
		//如果没有，将本书加入购物车
		if(count == 0){
			shopcartService.addToShopcart(userBook);
			
			return "redirect:/gotoShopCart.action";	//跳转到购物车
		}
		//如果有，数量+1
		shopcartService.addCountOfBook(userBook);
		
		return "redirect:/gotoShopCart.action";	//重定向到购物车
	}
	
	//重定向到购物车
	@RequestMapping("/gotoShopCart.action")
	public String gotoShopcart(){
		
		return "/findShopCart.action?userid="+this.userBook.getUser_id();	//根据user_id查询购物车
	}
	
	//在购物车中点击增加，图书的数量+1
	@RequestMapping("/bookAddOne.action")
	public String bookAddOne(UserBook userBook) throws Exception{	
		this.userBook = userBook;
		shopcartService.addCountOfBook(userBook);	//书的数量+1
		return "redirect:/gotoShopCart.action";	//重定向到购物车
	}
	
	//在购物车中点击数量减一，图书的数量-1
	@RequestMapping("/bookSubOne.action")
	public String bookSubOne(UserBook userBook) throws Exception{
		this.userBook = userBook;
		//先查询购物车是否有此书，1或0代表有或无
		int count = shopcartService.isInShopcart(userBook);
		
		
		if(count == 1){	//如果商品存在，返回1
			//查询商品数量
			//select book_number from shopcart where book_id=#{book_id} and user_id=#{user_id}
			if(shopcartService.countOfBook(userBook) > 1){
					
				//商品的数量减一
				//update shopcart set book_number=book_number-1 where book_id=#{book_id} and user_id=#{user_id}
				shopcartService.bookSubOne(userBook);
				
				return "redirect:/gotoShopCart.action";	//重定向到购物车
			}else{	//book_number <= 1
				
				shopcartService.deleteBook(userBook);
				
				return "redirect:/gotoShopCart.action";	//重定向到购物车
			}
		}
		//count == 0，商品不存在
		return "redirect:/gotoShopCart.action";	//重定向到购物车
	}
	
	//清空当前用户的购物车
	@RequestMapping("/clearShopCart.action")
	public ModelAndView clearShopCart(Integer userid) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		shopcartService.clearShopCart(userid);
		
		//跳转到图书查询列表
		modelAndView.setViewName("/getAllBook.action");
		return modelAndView;
	}
	
	//从购物车中删除某种书（根据用户user_id和book_id）
	@RequestMapping("/deleteBook.action")
	public ModelAndView deleteBook(UserBook userBook) throws Exception{
		shopcartService.deleteBook(userBook);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/findShopCart.action?userid="+userBook.getUser_id());	//跳转到购物车
		return modelAndView;
	}
	
	public ShopCartService getShopcartService() {
		return shopcartService;
	}

	public void setShopcartService(ShopCartService shopcartService) {
		this.shopcartService = shopcartService;
	}
	
	
}
