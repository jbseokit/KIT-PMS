package kr.hkit.pms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class LoginController {
	
	@GetMapping("/")
	public ModelAndView login() {
		log.info("-----로그인 화면");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/index");
		return mav;
	}
}
