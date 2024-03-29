package com.biz.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.shop.model.ProductVO;
import com.biz.shop.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/product")
@Controller
public class ProductController {
	
	@Autowired
	@Qualifier("proServiceV1")
	private ProductService proService;
	
	// 상품리스트 보이기
	// http://localhost:8080/shop/product/
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String proHome(Model model, HttpSession httpSession) {
		Object obj = httpSession.getAttribute("LOGIN");
		
		if(obj == null) {
			model.addAttribute("BODY", "LOGIN");
			model.addAttribute("MSG", "로그인해주세요!");
			return "redirect:/member/login";
		}
		
		// 전체 상품리스트를 SELECT
		List<ProductVO> proList = proService.selectAll();
		
		// PRO_LIST에 담아서 home으로 보내기
		model.addAttribute("PRO_LIST", proList);
		model.addAttribute("BODY", "PRO_HOME");
		return "home";
	}
	
	// insert GET method : 상품정보 추가 anchor를 클릭했을때
	// write화면을 보여주는 method
	// <a href="http://localhost:8080/shop/product/list">상품등록</a> request반응
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(@ModelAttribute("PRO_VO") ProductVO proVO, Model model) {
		
		//return "product/product_write";
		model.addAttribute("BODY", "PRO_WRITE");
		return "home";
	}
	
	// form에서 값을 입력한 후 저장버튼을 눌렀을 때 호출되는 method
	// <form method="POST"> 로 되어있을 때 반응하는 method
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute ProductVO proVO) {
		log.debug("상품정보 입력: {}", proVO.toString());
		int ret = proService.insert(proVO);
		
		return "redirect:/product/";
	}
	
	/*
	 * RequestParam(query이름)
	 * URL에 담긴 변수이름과 실제 사용하는 파라미터변수이름이 다를 때는
	 * @RequestParam()을 사용하는 방법이 있다.
	 * RequestParam()은 spring 4.x 이상에서는 선택사항이다.
	 * query이름과 파라미터변수이름이 같을 때는 생략해도 된다.
	 * 단 이 어노테이션은 primitive형이거나 
	 * wrapper(Integer, Character, String, ...)형일 경우만
	 * 사용가능하다.
	 * 임의로 만든 VO를 파라미터로 사용할 때는 
	 * @ModelAttribute()를 사용해야 한다.
	 *  
	 */
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(@RequestParam("id") String p_code, Model model) {
		ProductVO proVO = proService.findById(p_code);
		
		model.addAttribute("PRO_VO", proVO);
		model.addAttribute("BODY", "PRO_DETAIL");
		return "home";
	}
	
	/*
	 * redirect
	 * request를 전환한다라는 개념
	 * 서버가 클라이언트에게 요청하기를
	 * 방금 요청한(delete)를 잘 수행했으니
	 * 다시 한번 /product/ URL로 request를 수행해달라는 요청
	 * 상태코드: 304
	 */
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam("id") String p_code) {
		int ret = proService.delete(p_code);
		return "redirect:/product/";
	}
	
	/*
	 * 1. PK를 매개변수로 update(GET) request를 수신
	 * 2. findById(PK)를 호출하여 VO값을 찾고
	 * 3. Model에 VO를 심어서
	 * 4. write.jsp로 내려보낸다.
	 * 5. write.jsp는 Model에 담긴 VO를 input box에 보여주고
	 * 6. 사용자에게 변경할 데이터를 입력하도록 수행
	 * 7. 저장(submit)수행
	 * 8. update(POST) request를 수신, 이때 데이터는 VO 매개변수로 수신
	 * 9. service.update(VO)를 수행하여 데이터 변경
	 */
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@RequestParam("id") String p_code, @ModelAttribute("PRO_VO") ProductVO proVO, Model model) {
		proVO = proService.findById(p_code);
		model.addAttribute("PRO_VO", proVO);
		model.addAttribute("BODY", "PRO_WRITE");
		
		return "home";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute ProductVO proVO, Model model) {
		int ret = proService.update(proVO);
		
		model.addAttribute("id", proVO.getP_code());
		
		return "redirect:/product/detail"; // ?id=+proVO.getP_code();
	}
}
