package cn.itcast.ssm.service.impl;


import java.util.List;

import cn.itcast.ssm.dao.BookDao;
import cn.itcast.ssm.dao.ShopCartDao;
import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.pojo.UserBook;
import cn.itcast.ssm.service.BookService;
import cn.itcast.ssm.service.ShopCartService;
import cn.itcast.ssm.service.UserService;

public class ShopCartServiceImpl implements ShopCartService {
	private ShopCartDao shopcartdao;//注入
	
	
	//如果点击的书在购物车不存在，将点击的书加入购物车
	@Override
	public void addToShopcart(UserBook userBook) throws Exception {
		shopcartdao.addToShopcart(userBook);
		
	}
	
	//如果点击的书在购物车中存在，数量加1
	@Override
	public void addCountOfBook(UserBook userBook) throws Exception {
		
		shopcartdao.addCountOfBook(userBook);
	}
	
	//商品数量-1
	@Override
	public void bookSubOne(UserBook userBook) throws Exception{
		shopcartdao.bookSubOne(userBook);
	}
	
	//查看购物车
	public User findShopCart(Integer userid) throws Exception{
		return shopcartdao.findShopCart(userid);
	}
	
	//查看购物车是否有此商品，返回此商品的数量
	@Override
	public int isInShopcart(UserBook userBook) throws Exception {
		
		return shopcartdao.isInShopcart(userBook);
	}
	
	//查看某本书的数量
	@Override
	public int countOfBook(UserBook userBook) throws Exception{
		
		return shopcartdao.countOfBook(userBook);
	}
	
	//清空当前用户的购物车
	public void clearShopCart(int userid) throws Exception{
		shopcartdao.clearShopCart(userid);
	}
	
	//从购物车中删除商品（根据user_id和book_id)
	public void deleteBook(UserBook userBook) throws Exception{
		shopcartdao.deleteBook(userBook);
	}
	
	public ShopCartDao getShopcartdao() {
		return shopcartdao;
	}

	public void setShopcartdao(ShopCartDao shopcartdao) {
		this.shopcartdao = shopcartdao;
	}
	
	

	
}
