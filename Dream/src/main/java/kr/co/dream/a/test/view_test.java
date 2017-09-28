package kr.co.dream.a.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class view_test {

	@RequestMapping(value="reward_test")
	public String reward_test(){
		return "test/reward_test";
	}
}
