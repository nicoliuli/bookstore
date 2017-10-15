package cn.itcast.ssm.dao;

import java.util.List;

import cn.itcast.ssm.pojo.Book;

public interface BookDao {
	//根据图书的id查询图书的信息
	public List<Book> findBookByName(String bookName) throws Exception;
	
	//得到所有的图书
	public List<Book> getAllBook() throws Exception;
}
