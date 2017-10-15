package cn.itcast.ssm.service.impl;


import java.util.List;

import cn.itcast.ssm.dao.ManagerDao;
import cn.itcast.ssm.pojo.Item;
import cn.itcast.ssm.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerdao;//注入
	
	//后台管理员查看所有的订单控制订单的发货状态
	@Override
	public List<Item> getAllItem() throws Exception {
		// TODO Auto-generated method stub
		return managerdao.getAllItem();
	}

	//改变发货的状态
	@Override
	public void chstatus(Item item) throws Exception {
		managerdao.chstatus(item);
		
	}
	
	public ManagerDao getManagerdao() {
		return managerdao;
	}

	public void setManagerdao(ManagerDao managerdao) {
		this.managerdao = managerdao;
	}
	
}
