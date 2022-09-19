package kr.hkit.pms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableWebMvc
@RestController
@RequestMapping("/sales/*")
public class SalesResourcesController {
	
	@GetMapping("/agency")
	public void getAgency() {
		log.info("기관 정보 관리");
	}
	
	@GetMapping("/spend")
	public void getSpend() {
		log.info("지출 관리");
	}
}