package kr.hkit.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.hkit.pms.service.human.HumanResourcesService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/human/*")
public class HumanResourcesController {
	
	@Autowired
	HumanResourcesService hrs;
	
	@GetMapping("/info")
	public ModelAndView getInfo() {
		log.info("-----인적 정보");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/human/info");
		mav.addObject("humanInfo", hrs.getList());
		return mav;
	}
	
	@GetMapping("/attend")
	public ModelAndView getAttend() {
		log.info("-----출결 정보");
		ModelAndView mav = new ModelAndView("/human/attend");
		return mav;
	}
	
	@GetMapping("/vacation")
	public ModelAndView getVacation() {
		log.info("-----휴가 정보");
		ModelAndView mav = new ModelAndView("/human/vacation");
		return mav;
	}
}
