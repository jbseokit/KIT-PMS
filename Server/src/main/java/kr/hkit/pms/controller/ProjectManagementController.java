package kr.hkit.pms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/project/*")
public class ProjectManagementController {
	
	@GetMapping("/members")
	public ModelAndView getInMem() {
		log.info("-----투입 인원 관리");
		ModelAndView mav = new ModelAndView("project_members");
		return mav;
	}
	
	@GetMapping("/info")
	public ModelAndView getProInfo() {
		log.info("-----프로젝트 정보 관리");
		ModelAndView mav = new ModelAndView("project_info");
		return mav;
	}
	
	@GetMapping("/schedual")
	public ModelAndView getEquip() {
		log.info("-----프로젝트 일정 관리");
		ModelAndView mav = new ModelAndView("project_schedual");
		return mav;
	}
}
