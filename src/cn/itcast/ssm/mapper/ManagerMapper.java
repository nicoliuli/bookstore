package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.pojo.Item;

public interface ManagerMapper {
	//后台管理员查看所有的订单控制订单的发货状态
	public List<Item> getAllItem()throws Exception;
	
	//改变发货的状态
	public void chstatus(Item item) throws Exception;
}
