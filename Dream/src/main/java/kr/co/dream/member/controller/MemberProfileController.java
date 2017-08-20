package kr.co.dream.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MemberProfileController {

	public String memberProfileUpload(){
	
		return "success";
	}
	
	public String test(Model model){
		
		
		return null;
	}
}
