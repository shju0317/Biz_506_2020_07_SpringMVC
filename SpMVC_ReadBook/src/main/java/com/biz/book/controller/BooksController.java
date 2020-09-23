package com.biz.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.book.mapper.BookDao;
import com.biz.book.model.BookVO;

@Controller
@RequestMapping(value="/books")
public class BooksController {
	
	@Autowired
	private BookDao bookDao;
	
	// value={"/",""} 로 하는 이유
	// 	 localhost:8080/book/books
	// 	 localhost:8080/book/books/
	// 	 둘 다 쓸 수 있도록 하려고
	// @ResponseBody
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String list(Model model){
		List<BookVO> bookList = bookDao.selectAll();
		model.addAttribute("BOOKS", bookList);
		
		return "books/book-list";
	}
	
	@RequestMapping(value="/input", method=RequestMethod.GET)
	public String input() {
		
		return "books/book-write";
		
		/*
		Controller의 Mapping method의 return type이 String일 때
		null값을 return하면
		method를 호출할 때 사용했던 mapping URL.jsp 형식의 return문이
		자동으로 생성된다.
		*/
		// return null;
	}
}
