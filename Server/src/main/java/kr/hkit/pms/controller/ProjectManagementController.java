package kr.hkit.pms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableWebMvc
@RestController
@RequestMapping("/project/*")
public class ProjectManagementController {
	
	@GetMapping("/dash")
	public void getDash() {
		log.info("대쉬보드");
	}
	
	@GetMapping("/input")
	public void getInput() {
		log.info("투입 인원 관리");
	}
	
	@GetMapping("/proinfo")
	public void getProInfo() {
		log.info("프로젝트 정보 관리");
	}
	
	@GetMapping("/schedual")
	public void getSchedual() {
		log.info("일정 관리");
	}
}
