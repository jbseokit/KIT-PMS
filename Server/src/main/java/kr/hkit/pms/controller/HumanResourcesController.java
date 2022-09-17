package kr.hkit.pms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableWebMvc
@RestController("/human/*")
public class HumanResourcesController {
	
	@GetMapping("/info")
	public void getInfo() {
		log.info("인적 정보 관리");
	}
}
