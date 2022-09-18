package kr.hkit.pms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableWebMvc
@RestController
@RequestMapping("/human/*")
public class HumanResourcesController {
	
	@GetMapping("/info")
	public void getInfo() {
		log.info("인적 정보 관리");
	}
	
	@GetMapping("/attend")
	public void getAttend() {
		log.info("출결 관리");
	}
	
	@GetMapping("/vacation")
	public void getVacation() {
		log.info("휴가 관리");
	}
	
}
