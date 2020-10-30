package com.biz.grade.service;

import java.util.List;

import com.biz.grade.model.GradeVO;

public interface GradeService {
	public List<GradeVO> selectAll();
	public GradeVO findById(Long id);
	public int insert(GradeVO gradeVO);
	public int update(GradeVO gradeVO);
	public int delete(Long id);
}
