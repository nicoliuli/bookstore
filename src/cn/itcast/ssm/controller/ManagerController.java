package cn.itcast.ssm.controller;


//使用注解开发控制器需要导入的包

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.ssm.pojo.Item;
import cn.itcast.ssm.service.ManagerService;

@Controller
public class ManagerController{
	private ManagerService managerService;
	
	@RequestMapping("/gotoItemList.action")
	public void gotoItemList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//查询所有订单
		List<Item> itemList = managerService.getAllItem();
		request.setAttribute("itemList",itemList);
		request.getRequestDispatcher("/WEB-INF/jsp/itemlist.jsp").forward(request, response);	//跳转到所有订单列表
	}
	
	//改变发货的状态
	@RequestMapping("/chstatus.action")
	public String chstatus(HttpServletRequest request,Item item) throws Exception{
		
		
		//根据userid和bookid改变item表的status字段，0-->1发货
		managerService.chstatus(item);
		//重定向到后台商品列表
		return "redirect:/gotoItemList.action";
	}
	
	
	
	public ManagerService getManagerService() {
		
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
}
