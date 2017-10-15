package cn.itcast.ssm.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.ssm.dao.BookDao;
import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.BookMapper;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.pojo.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	//用户注册时检查用户名是否存在
	@Override
	public List<User> findUserByUsername(User u) throws Exception {
		
		return this.getSqlSession().getMapper(UserMapper.class).findUserByUsername(u);
	}
	
	//用户登录时判断用户的用户名和密码是正确
	@Override
	public User findUsernameAndPassword(User u) throws Exception {
		
		return this.getSqlSession().getMapper(UserMapper.class).findUsernameAndPassword(u);
	}
	
	//将新注册的用户名添加到数据库
	@Override
	public void insertUser(User u) throws Exception {
		this.getSqlSession().getMapper(UserMapper.class).insertUser(u);
		
	}

	
	
}
