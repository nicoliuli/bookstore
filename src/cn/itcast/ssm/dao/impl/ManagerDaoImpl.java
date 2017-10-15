package cn.itcast.ssm.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.ssm.dao.ManagerDao;
import cn.itcast.ssm.mapper.ManagerMapper;
import cn.itcast.ssm.pojo.Item;

public class ManagerDaoImpl extends SqlSessionDaoSupport implements ManagerDao{
	
	//后台管理员查看所有的订单控制订单的发货状态
	@Override
	public List<Item> getAllItem() throws Exception {
		
		return this.getSqlSession().getMapper(ManagerMapper.class).getAllItem();
	}
	
	//改变发货的状态
	@Override
	public void chstatus(Item item) throws Exception {
		this.getSqlSession().getMapper(ManagerMapper.class).chstatus(item);
		
	}
	
	
}
