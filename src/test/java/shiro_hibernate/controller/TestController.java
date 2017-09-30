package shiro_hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping(value="/testShow")
	public String testShow(){
		System.out.println("testShow() ..");
		return "test/testShow";
	}
}
