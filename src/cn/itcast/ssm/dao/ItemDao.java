package cn.itcast.ssm.dao;

import java.util.List;

import cn.itcast.ssm.pojo.Item;

public interface ItemDao {
	//根据userId和bookId删除从购物车中提交过来的书 
	public void deleteShop(Item item) throws Exception;
	
	//将从购物车提交的商品写入Item表
	public void addItem(Item item) throws Exception;
	
	// 根据userid查询我的订单
	public List<Item> getMyItemsById(int userid) throws Exception;
}
