package com.biz.grade.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class GradeVO {
	private long id;			//	PRIMARY KEY
	private String g_sid;		//	VARCHAR(4)	NOT NULL
	private String g_name;		//	nVARCHAR2(30)	NOT NULL	
	private int g_kor;			//	NUMBER		
	private int g_eng;			//	NUMBER		
	private int g_math;			//	NUMBER		
	private int g_total;		//	NUMBER		
	private int g_avg;			//	NUMBER			
}
