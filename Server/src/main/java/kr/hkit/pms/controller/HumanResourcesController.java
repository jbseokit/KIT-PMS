package kr.hkit.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.hkit.pms.domain.common.Criteria;
import kr.hkit.pms.domain.common.PageNumDto;
import kr.hkit.pms.domain.human.HumanInfoMgtDto;
import kr.hkit.pms.service.common.PageNumService;
import kr.hkit.pms.service.human.HumanResourcesService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/human/*")
public class HumanResourcesController {
	
	@Autowired
	HumanResourcesService hrs;
	
	@Autowired
	PageNumService pns;
	
//	@GetMapping("/hr/{mbr_sn}")
//	public ModelAndView getInfo(Criteria cri, @PathVariable("mbr_sn") String mbr_sn) {
//		log.info("-----인적 정보");
//		int total = pns.getTotal(cri);
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/human/info");
//		mav.addObject("humanInfo", hrs.getInfoList(cri));
//		mav.addObject("pageMaker", new PageNumDto(cri, total));
//		return mav;
//	}
	
	@GetMapping("/hr-list")
	public ModelAndView getInfo(Criteria cri) {
		log.info("-----인적 정보");
		int total = pns.getTotal(cri);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/human/info");
		mav.addObject("humanInfo", hrs.selectHrList(cri));
		mav.addObject("pageMaker", new PageNumDto(cri, total));
		return mav;
	}
	
	@GetMapping("/hr-register")
	public ModelAndView HRregister() {
		log.info("-----hr register controller : get");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/human/register");
		return mav;
	}
	
	@PostMapping("/hr-register")
	public ModelAndView HRregister(HumanInfoMgtDto human) {
		log.info("-----hr register controller : post : " + human);
		ModelAndView mav = new ModelAndView();
		hrs.registerHr(human);
		mav.setViewName("redirect:/human/hr-list");
		return mav;
	}
	
	@GetMapping("/at-list")
	public ModelAndView getAttend(Criteria cri) {
		log.info("-----출결 정보");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/human/attend");
		mav.addObject("humanAttend", hrs.selectAtList(cri));
		return mav;
	}
	
	@GetMapping("/va-list")
	public ModelAndView getVacation(Criteria cri) {
		log.info("-----휴가 정보");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/human/vacation");
		mav.addObject("humanVacation", hrs.selectVaList(cri));
		return mav;
	}
	
}
