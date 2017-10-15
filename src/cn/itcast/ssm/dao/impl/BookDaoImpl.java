package cn.itcast.ssm.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.ssm.dao.BookDao;
import cn.itcast.ssm.mapper.BookMapper;
import cn.itcast.ssm.pojo.Book;

public class BookDaoImpl extends SqlSessionDaoSupport implements BookDao{

	//根据图书的name查询图书的信息
	@Override
	public List<Book> findBookByName(String bookName) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().getMapper(BookMapper.class).findBookByName(bookName);
	}
	

	//得到所有的图书
	@Override
	public List<Book> getAllBook() throws Exception {
		return this.getSqlSession().getMapper(BookMapper.class).getAllBook();
	}

	
	
}
