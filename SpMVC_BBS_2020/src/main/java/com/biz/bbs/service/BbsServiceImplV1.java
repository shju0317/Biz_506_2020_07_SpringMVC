package com.biz.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.BbsDao;
import com.biz.bbs.model.BbsVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("bbsServiceV1")
public class BbsServiceImplV1 implements BbsService{
	
	private final BbsDao bbsDao;

	@Override
	public List<BbsVO> selectAll() {
		return bbsDao.selectAll();
	}

	@Override
	public void insert(BbsVO bbsVO) {
		bbsDao.insert(bbsVO);
		
	}
}
