package com.biz.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.book.model.BookVO;
import com.biz.book.service.NaverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/naver")
public class NaverController {
	
	@Autowired
	@Qualifier("naverServiceV1")
	private NaverService<BookVO> nServiceV1;
	
	@Autowired
	@Qualifier("naverServiceV2_XML")
	private NaverService<BookVO> nServiceV2;

	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(String search_text) {
		return "naver/naver-list";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	
	// required=false : 필수 아님(=값이 안와도 됨)
	// defaultValue="BOOK" : 값을 BOOK으로
	public String search(@RequestParam(name="category", required=false, defaultValue="BOOK") String category, 
			@RequestParam(name="search_text")String search_text, 
			Model model) {
		
		log.debug(search_text);
		log.debug(category);
		
		String queryURL = nServiceV2.queryURL(category, search_text.trim());
		
		// V1에서 사용되는 method
		//String jsonString = naverService.getNaverSearch(queryURL);
		//List<BookVO> bookList = naverService.getNaverList(jsonString);
		
		List<BookVO> bookList = nServiceV2.getNaverList(queryURL);
		
		model.addAttribute("NAVERS", bookList);
		return "naver/naver-list";
	}
	
	@ResponseBody
	@RequestMapping(value="/api", method = RequestMethod.POST, produces="application/xml;charset=utf8")
	public String naver(String book_name) {
		String queryURL = nServiceV1.queryURL("BOOK", book_name);
		String retString = nServiceV1.getNaverSearch(queryURL);		
		return retString;
		
		// List<BookVO> bookList = naverService.getNaverList(jsonString);
		// return bookList;
	}
	
	// .../query?num1=값&num2=값
	@ResponseBody
	@RequestMapping(value="/query", method=RequestMethod.GET)
	public String query(int num1, @RequestParam(name="num2", required=false, defaultValue="500") int num2) {
		return (num1 + num2) + "";
	}
	
}
