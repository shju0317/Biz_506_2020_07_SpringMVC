package com.biz.book.mapper;

import com.biz.book.model.BookVO;

/*
 * GenericDao를 extends하면 기본 CRUD메서드를
 * 별도로 정의하지 않아도 된다.
 */
public interface BookDao extends GenericDao<BookVO, Integer>{
	
}
