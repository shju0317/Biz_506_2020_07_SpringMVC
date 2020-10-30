package com.biz.grade.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.grade.model.GradeVO;
import com.biz.grade.service.GradeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("gradeServiceV1")
	private GradeService gradeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<GradeVO> gradeList = gradeService.selectAll();
		model.addAttribute("GRADE_LIST", gradeList);

		return "home";
	}
	
	@RequestMapping(value="/input", method=RequestMethod.GET)
	public String input(Model model) {
		
		return "grade-input";
	}
	
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public String input(@ModelAttribute GradeVO gradeVO, Model model) {
		
		log.debug("GRADEVO >> {}", gradeVO.toString());
		
		int ret = gradeService.insert(gradeVO);
		if (ret > 0) {
			log.debug("INSERT 수행한 후 결과 {}개 성공", ret);
		}

		
		model.addAttribute("GRADE", gradeVO);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model model) {
		
		Long long_id = Long.valueOf(id);
		GradeVO gradeVO = gradeService.findById(long_id);
		model.addAttribute("GRADE", gradeVO);
		
		return "grade-input";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(GradeVO gradeVO, Model model) {
		
		log.debug("UPDATE 요청데이터 {}", gradeVO.toString());
		
		//Long id = gradeVO.getId();
		//GradeVO gradeOldVO = gradeService.findById(id);
		
		int ret = gradeService.update(gradeVO);
		if (ret > 0) {
			log.debug("업데이트된 데이터 개수 {}", ret);
		}
		
		return "redirect:/";
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(String id) {
		Long long_id = Long.valueOf(id);
		GradeVO gradeVO = gradeService.findById(long_id);
		
		int ret = gradeService.delete(long_id);
		
		if(ret > 0) {
			log.debug("삭제된 데이터 개수 {}", ret);
		}
		return "redirect:/";
	}
	
}
