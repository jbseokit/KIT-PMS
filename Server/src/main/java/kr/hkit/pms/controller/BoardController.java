package kr.hkit.pms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.log4j.Log4j2;


@Log4j2
@EnableWebMvc
@RestController
@RequestMapping("/board/*")
public class BoardController {
	
	@GetMapping("/free")
	public void getFree() {
		log.info("자 유 게 시 판");
	}
	
	@GetMapping("/notice")
	public void getNotice() {
		log.info("공 지 사 항");
	}
	
	@GetMapping("/ref")
	public void getRef() {
		log.info("자 료 실");
	}
}
