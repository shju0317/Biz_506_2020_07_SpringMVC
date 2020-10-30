package com.biz.grade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.biz.grade.model.GradeVO;

public interface GradeDao {
	
	@Select("SELECT * FROM tbl_grade ORDER BY g_name DESC, g_sid DESC")
	public List<GradeVO> selectAll();
	
	@Select("SELECT * FROM tbl_grade WHERE id = #{id}")
	public GradeVO findById(Long id);

	@Delete("DELETE FROM tbl_grade WHERE id = #{id}")
	public int delete(Long id);
	
	public int insert(GradeVO gradeVO); 
	
	public int update(GradeVO gradeVO);
}
