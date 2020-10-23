package com.biz.bbs;

import com.biz.bbs.model.BbsVO;

public class ClassParamEx {
	public static void main(String[] args) {
		BbsVO bbsVO = new BbsVO();
		long b_seq = 99;
		
		System.out.println(b_seq);// b_seq = 99
		
		b_seq(b_seq);
		
		System.out.println(b_seq);// b_seq = 99 (primitive형인 long이기 때문에)
		
		bbsVO.setB_seq(b_seq);
		System.out.println(bbsVO.getB_seq()); // b_seq = 99
		
		b_seq(bbsVO);
		// case1
		System.out.println(bbsVO.getB_seq()); // b_seq = 99
		
		// case2
		System.out.println(bbsVO.getB_seq()); // b_seq = 2008 (클래스를 매개변수로 받았을때)
	}

	private static void b_seq(long b_seq) {
		b_seq = 525;
	}

	private static void b_seq(BbsVO vo) { // 참조형
		// case1
		//vo = new BbsVO();
		
		// case2
		vo.setB_seq(2008);
	}
}
