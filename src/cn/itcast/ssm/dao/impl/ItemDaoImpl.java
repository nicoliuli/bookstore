package cn.itcast.ssm.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.ssm.dao.ItemDao;
import cn.itcast.ssm.mapper.ItemMapper;
import cn.itcast.ssm.pojo.Item;

public class ItemDaoImpl extends SqlSessionDaoSupport implements ItemDao{
	
	//根据userId和bookId删除从购物车中提交过来的书
	@Override
	public void deleteShop(Item item) throws Exception {
		this.getSqlSession().getMapper(ItemMapper.class).deleteShop(item);
		
	}

	//将从购物车提交的商品写入Item表
	@Override
	public void addItem(Item item) throws Exception {
		
		this.getSqlSession().getMapper(ItemMapper.class).addItem(item);
	}
	
	//根据userid查询我的订单
	@Override
	public List<Item> getMyItemsById(int userid) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().getMapper(ItemMapper.class).getMyItemsById(userid);
	}
}
