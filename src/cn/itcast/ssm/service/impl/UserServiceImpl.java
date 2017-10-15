package cn.itcast.ssm.service.impl;


import java.util.List;

import cn.itcast.ssm.dao.BookDao;
import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.service.BookService;
import cn.itcast.ssm.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userdao;//注入
	
	//用户注册时检查用户名是否存在
	@Override
	public List<User> findUserByUsername(User u) throws Exception {
		
		return userdao.findUserByUsername(u);
	}
	
	//用户登录时判断用户的用户名和密码是正确
	@Override
	public User findUsernameAndPassword(User u) throws Exception {
		
		return userdao.findUsernameAndPassword(u);
	}
	
	//将新注册的用户名添加到数据库
	@Override
	public void insertUser(User u) throws Exception {
		userdao.insertUser(u);
		
	}

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	

	

}
