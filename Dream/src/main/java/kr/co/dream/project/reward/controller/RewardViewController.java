package kr.co.dream.project.reward.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RewardViewController {

	// 프로젝트 리워즈 입력 화면 요청
	@RequestMapping(value = "/projectRewardView")
	public String projectRewardView(@RequestParam int project_no, Model model) {
		System.out.println("RewardViewController \tprojectRewardView() [프로젝트 리워드 정보 입력 화면 요청] projcet_no : " + project_no);
		model.addAttribute("project_no",project_no);
		return "project/register/projectRewardView";
	}
	
}
