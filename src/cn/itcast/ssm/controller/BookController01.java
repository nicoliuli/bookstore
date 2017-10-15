package cn.itcast.ssm.controller;


//使用注解开发控制器需要导入的包
import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.service.BookService;

@Controller
public class BookController01{
	private BookService bookService;
	
	//根据id查找图书
	@RequestMapping("/findBookByName.action")
	public ModelAndView findBookByName(String bookName) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		if(bookName == null || bookName.equals("")){//如果没有输入书名
			
			modelAndView.setViewName("/WEB-INF/jsp/booklistempty.jsp");
			return modelAndView;
		}	
			
		List<Book> bookList = bookService.findBookByName(bookName);
		
		if(bookList.size() > 0){	//如果查到了图书
			modelAndView.addObject("bookList",bookList);
			modelAndView.setViewName("/WEB-INF/jsp/bookdescripse.jsp");
		}else{	//如果没有查到图书
			modelAndView.addObject("bookName",bookName);
			modelAndView.setViewName("/WEB-INF/jsp/booklistempty.jsp");
		}
		
		return modelAndView;
	}
	
	//查找所有的图书
	@RequestMapping("/getAllBook.action")
	public ModelAndView getAllBook() throws Exception{
		List<Book> bookList = bookService.getAllBook();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("bookList", bookList);
		modelAndView.setViewName("/WEB-INF/jsp/booklist.jsp");
			
		return modelAndView;
	}

	public BookService getBookService() {
		return bookService;
	}


	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	
}
