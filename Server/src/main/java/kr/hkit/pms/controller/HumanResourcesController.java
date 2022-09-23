package kr.hkit.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	// -----------------------------hr Controller-----------------------------
	
	// R
	@GetMapping("/hr-list")
	public ModelAndView selectHrList(Criteria cri) {
		log.info("-----인적 정보");
		int total = pns.getTotalHr(cri);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/human/selectHrList");
		mav.addObject("humanInfo", hrs.selectHrList(cri));
		mav.addObject("pageMaker", new PageNumDto(cri, total));
		return mav;
	}
	
	@GetMapping("/hr")
	public ModelAndView selectHr(@RequestParam("mbr_sn") String mbr_sn) {
		log.info("-----hr select controller : get");
		ModelAndView mav = new ModelAndView();
		mav.addObject("human", hrs.selectHr(mbr_sn));
		mav.setViewName("/human/selectHr");
		return mav;
	}
	
	// C
	@GetMapping("/hr-register")
	public ModelAndView registerHr() {
		log.info("-----hr register controller : get");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/human/registerHr");
		return mav;
	}
	
	@PostMapping("/hr-register")
	public ModelAndView registerHr(HumanInfoMgtDto human) {
		log.info("-----hr register controller : post : " + human);
		hrs.registerHr(human); // 등록
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/human/hr-list"); // url 호출
		return mav;
	}
	
	// U
	@GetMapping("/hr-modify")
	public ModelAndView modifyHr(@RequestParam("mbr_sn") String mbr_sn) {
		log.info("-----hr modify controller : get");
		ModelAndView mav = new ModelAndView();
		mav.addObject("human", hrs.selectHr(mbr_sn));
		mav.setViewName("/human/modifyHr");
		return mav;
	}
	
	@PostMapping("/hr-modify")
	public ModelAndView modifyHr(HumanInfoMgtDto human) {
		log.info("-----hr modify controller : post");
		hrs.modifyHr(human);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/human/hr-list");
		return mav;
	}
	
	// D
	@GetMapping("/hr-remove")
	public ModelAndView removeHr(@RequestParam("mbr_sn") String mbr_sn) {
		log.info("-----hr remove controller : get");
		hrs.removeHr(mbr_sn);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/human/hr-list");
		return mav;
	}
	
	// -----------------------------at Service-----------------------------
	
	@GetMapping("/at-list")
	public ModelAndView getAttend(Criteria cri) {
		log.info("-----출결 정보");
		int total = pns.getTotalAt(cri);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/human/selectAtList");
		mav.addObject("humanAttend", hrs.selectAtList(cri));
		mav.addObject("pageMaker", new PageNumDto(cri, total));
		return mav;
	}
	
	
	// -----------------------------va Service-----------------------------
	
	@GetMapping("/va-list")
	public ModelAndView getVacation(Criteria cri) {
		log.info("-----휴가 정보");
		int total = pns.getTotalVa(cri);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/human/selectVaList");
		mav.addObject("humanVacation", hrs.selectVaList(cri));
		mav.addObject("pageMaker", new PageNumDto(cri, total));
		return mav;
	}
	
}
