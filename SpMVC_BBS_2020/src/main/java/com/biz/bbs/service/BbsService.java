package com.biz.bbs.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.biz.bbs.model.BbsVO;

public interface BbsService {

	public List<BbsVO> selectAll();
	public void insert(BbsVO bbsVO);
	public void insert(BbsVO bbsVO, MultipartFile file);
	public BbsVO findBySeq(long long_seq);
	public int delete(long long_seq);
}
