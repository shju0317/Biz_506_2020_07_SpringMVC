package com.biz.book.mapper;

import org.apache.ibatis.annotations.Select;

import com.biz.book.model.UserDetailsVO;

public interface UserDao extends GenericDao<UserDetailsVO, String>{
	
	// member 테이블의 전체 회원수 조회
	@Select("SELECT COUNT(*) FROM tbl_member")
	public int userCount();
}
