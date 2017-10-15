package cn.itcast.ssm.mapper;

import java.util.List;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.pojo.UserBook;

public interface ShopCartMapper {
	
	//如果点击的书在购物车不存在，将点击的书加入购物车
	public void addToShopcart(UserBook userBook) throws Exception;
	
	//如果点击的书在购物车中存在，数量加1
	public void addCountOfBook(UserBook userBook) throws Exception;
	//查看购物车
	public User findShopCart(Integer userid) throws Exception;
	
	//商品数量-1
	public void bookSubOne(UserBook userBook) throws Exception;
	
	//查询购物车是否有此书,返回此书的个数
	public int isInShopcart(UserBook userBook) throws Exception;
	
	//查看某本书的数量
	public int countOfBook(UserBook userBook) throws Exception;
	
	//清空当前用户的购物车
	public void clearShopCart(int userid) throws Exception;
	
	//从购物车中删除商品（根据user_id和book_id)
	public void deleteBook(UserBook userBook) throws Exception;
}
