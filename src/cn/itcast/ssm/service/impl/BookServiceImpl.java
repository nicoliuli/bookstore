package cn.itcast.ssm.service.impl;


import java.util.List;

import cn.itcast.ssm.dao.BookDao;
import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao bookdao;//注入

	//根据bookName查找图书的信息
	@Override
	public List<Book> findBookByName(String bookName) throws Exception {
		
		return bookdao.findBookByName(bookName);
	}
	
	//查找所有的图书
	@Override
	public List<Book> getAllBook() throws Exception {
		// TODO Auto-generated method stub
		return bookdao.getAllBook();
	}
	
	public BookDao getBookdao() {
		return bookdao;
	}

	public void setBookdao(BookDao bookdao) {
		this.bookdao = bookdao;
	}

	

}
