package cn.itcast.ssm.dao;

import java.util.List;

import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.pojo.User;

public interface UserDao {
	//用户注册时检查用户名是否存在
	public List<User> findUserByUsername(User u) throws Exception;
	
	//将新注册的用户名添加到数据库
	public void insertUser(User u) throws Exception;
	
	//用户登录时判断用户的用户名和密码是正确
	public User findUsernameAndPassword(User u) throws Exception;
}
