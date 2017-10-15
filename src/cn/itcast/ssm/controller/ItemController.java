package cn.itcast.ssm.controller;


//使用注解开发控制器需要导入的包

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.ssm.pojo.Item;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.service.ItemService;

@Controller
public class ItemController{
	private ItemService itemService;
	
	//提交订单
	@RequestMapping("/upItem.action")
	public String item(Item item,HttpServletRequest request) throws Exception{
		int userid = item.getUserId();
		int bookid = item.getBookId();
		String bookname = item.getBookName();
		bookname = new String(bookname.getBytes("iso-8859-1"),"utf-8");
		item.setBookName(bookname);
		double bookprice = item.getBookPrice();
		int booknum = item.getBookNum();
		
		
		
		//删除用户的购物车
		itemService.deleteShop(item);
		//将数据写入item表
		itemService.addItem(item);
		//查询我的订单
		
		//跳转到我的订单页面
		return "redirect:/gotoMyItem.action";
	}
	
	//我的订单,根据session中的userid查看我的订单
	@RequestMapping("/gotoMyItem.action")
	public String gotoMyItem(HttpSession session,HttpServletRequest request) throws Exception{
		User u = (User) session.getAttribute("u");
		
		List<Item> myItemList = itemService.getMyItemsById(u.getId());
		
		
		request.setAttribute("myItemList", myItemList);
		return "/WEB-INF/jsp/myitems.jsp";
	}
	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

}
