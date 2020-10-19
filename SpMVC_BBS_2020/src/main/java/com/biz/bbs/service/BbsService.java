package com.biz.bbs.service;

import java.util.List;

import com.biz.bbs.model.BbsVO;

public interface BbsService {

	public List<BbsVO> selectAll();

	public void insert(BbsVO bbsVO);
	
}
