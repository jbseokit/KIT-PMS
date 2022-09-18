package kr.hkit.pms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableWebMvc
@RestController
@RequestMapping("/material/*")
public class MaterialResourcesController {

	@GetMapping("/equip")
	public void getEquip() {
		log.info("장비 정보 관리");
	}
	
	@GetMapping("/facility")
	public void getFacility() {
		log.info("시설 관리");
	}
	
	@GetMapping("/sw")
	public void getSw() {
		log.info("SW 정보 관리");
	}
}
