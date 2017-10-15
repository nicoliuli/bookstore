package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.pojo.Book;

public interface BookService {
	//根据bookname查找图书，返回图书的信息
	public List<Book> findBookByName(String bookName) throws Exception;
	
	//得到所有的图书
	public List<Book> getAllBook() throws Exception;
}
