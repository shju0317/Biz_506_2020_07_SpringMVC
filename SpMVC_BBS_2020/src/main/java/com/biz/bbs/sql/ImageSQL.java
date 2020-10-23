package com.biz.bbs.sql;

import org.apache.ibatis.jdbc.SQL;

public class ImageSQL {
	public String insert() {
		
		SQL sql = new SQL();
		
		sql.INSERT_INTO("tbl_images");
		sql.INTO_COLUMNS("i_seq").INTO_VALUES("SEQ_IMAGES.NEXTVAL");
		sql.INTO_COLUMNS("i_b_seq").INTO_VALUES("#{b_seq}");
		sql.INTO_COLUMNS("i_org_name").INTO_VALUES("#{vo.i_org_name}");
		sql.INTO_COLUMNS("i_file_name").INTO_VALUES("#{vo.i_file_name}");
		
		return sql.toString();
		
	}
}
