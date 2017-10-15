package cn.itcast.ssm.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.ssm.dao.BookDao;
import cn.itcast.ssm.dao.ShopCartDao;
import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.BookMapper;
import cn.itcast.ssm.mapper.ShopCartMapper;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.pojo.UserBook;

public class ShopCartDaoImpl extends SqlSessionDaoSupport implements ShopCartDao{
	
	
	//如果点击的书在购物车不存在，将点击的书加入购物车
	@Override
	public void addToShopcart(UserBook userBook) throws Exception {
		this.getSqlSession().getMapper(ShopCartMapper.class).addToShopcart(userBook);
		
	}
	
	//如果点击的书在购物车中存在，数量加1
	@Override
	public void addCountOfBook(UserBook userBook) throws Exception{
		this.getSqlSession().getMapper(ShopCartMapper.class).addCountOfBook(userBook);
	}
	
	//商品数量-1
	public void bookSubOne(UserBook userBook) throws Exception{
		this.getSqlSession().getMapper(ShopCartMapper.class).bookSubOne(userBook);
	}
	
	//查看购物车
	@Override
	public User findShopCart(Integer userid) throws Exception {
		return this.getSqlSession().getMapper(ShopCartMapper.class).findShopCart(userid);
	}

	//查看购物车是否有此商品，有的话返回数量，没有返回0
	@Override
	public int isInShopcart(UserBook userBook) throws Exception{
		return this.getSqlSession().getMapper(ShopCartMapper.class).isInShopcart(userBook);
	}
	
	//查看某本书的数量
	@Override
	public int countOfBook(UserBook userBook) throws Exception{
		return this.getSqlSession().getMapper(ShopCartMapper.class).countOfBook(userBook);
	}
	//清空当前用户的购物车
	@Override
	public void clearShopCart(int userid) throws Exception{
		this.getSqlSession().getMapper(ShopCartMapper.class).clearShopCart(userid);
	}
	
	//从购物车中删除商品（根据user_id和book_id)
	@Override
	public void deleteBook(UserBook userBook) throws Exception{
		this.getSqlSession().getMapper(ShopCartMapper.class).deleteBook(userBook);
	}
}
