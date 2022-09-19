package kr.hkit.pms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/material/*")
public class MaterialResourcesController {
	
	@GetMapping("/equip")
	public ModelAndView getEquip() {
		log.info("-----장비 정보 관리");
		ModelAndView mav = new ModelAndView("material_equip");
		return mav;
	}
	
	@GetMapping("/fac")
	public ModelAndView getFac() {
		log.info("-----시설 관리");
		ModelAndView mav = new ModelAndView("material_fac");
		return mav;
	}
	
	@GetMapping("/sw")
	public ModelAndView getInfo() {
		log.info("-----SW 정보 관리");
		ModelAndView mav = new ModelAndView("material_sw");
		return mav;
	}
}
