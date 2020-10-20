package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.bbs.model.BbsVO;
import com.biz.bbs.sql.BbsSQL;

public interface BbsDao {
	
	@Select("SELECT * FROM tbl_bbs ORDER BY b_seq DESC")
	public List<BbsVO> selectAll();
	
	@Select("SELECT * FROM tbl_bbs WHERE b_seq=#{seq}")
	public BbsVO findBySeq(long seq);
	
	/*
	 * BbsSQL 클래스에 정의된 bbs_insert method를 호출하여
	 * SQL문을 생성하고, 여기에 코드를 추가하라
	 */
	@InsertProvider(type=BbsSQL.class, method="bbs_insert")
	public int insert(BbsVO bbsVO);
	
	@UpdateProvider(type=BbsSQL.class, method="bbs_update")
	public int update(BbsVO bbsVO);
	
	@Delete("DELETE FROM tbl_bbs WHERE b_seq=#{seq}")
	public int delete(long seq);
}
