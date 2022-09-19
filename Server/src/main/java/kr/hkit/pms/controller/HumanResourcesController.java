package kr.hkit.pms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/human/*")
public class HumanResourcesController {
	
	@GetMapping("/info")
	public ModelAndView getInfo() {
		log.info("-----인적 정보");
		ModelAndView mav = new ModelAndView("human_info");
		return mav;
	}
	
	@GetMapping("/attend")
	public ModelAndView getAttend() {
		log.info("-----출결 정보");
		ModelAndView mav = new ModelAndView("human_attend");
		return mav;
	}
	
	@GetMapping("/vacation")
	public ModelAndView getVacation() {
		log.info("-----휴가 정보");
		ModelAndView mav = new ModelAndView("human_vacation");
		return mav;
	}
}
