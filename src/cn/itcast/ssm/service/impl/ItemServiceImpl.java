package cn.itcast.ssm.service.impl;


import java.util.List;

import cn.itcast.ssm.dao.BookDao;
import cn.itcast.ssm.dao.ItemDao;
import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.pojo.Item;
import cn.itcast.ssm.service.BookService;
import cn.itcast.ssm.service.ItemService;

public class ItemServiceImpl implements ItemService {
	private ItemDao itemdao;//注入
	
	// 根据userId和bookId删除从购物车中提交过来的书
	@Override
	public void deleteShop(Item item) throws Exception {
		itemdao.deleteShop(item);
		
	}
	//将从购物车提交的商品写入Item表
	@Override
	public void addItem(Item item) throws Exception {
		itemdao.addItem(item);
		
	}

	//根据userid查询我的订单
	@Override
	public List<Item> getMyItemsById(int userid) throws Exception {
		// TODO Auto-generated method stub
		return itemdao.getMyItemsById(userid);
	}
	
	
	public ItemDao getItemdao() {
		return itemdao;
	}

	public void setItemdao(ItemDao itemdao) {
		this.itemdao = itemdao;
	}
}
