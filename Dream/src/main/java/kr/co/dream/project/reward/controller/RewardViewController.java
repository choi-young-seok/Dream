package kr.co.dream.project.reward.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RewardViewController {

	// ������Ʈ ������ �Է� ȭ�� ��û
	@RequestMapping(value = "/projectRewardView")
	public String projectRewardView(@RequestParam int project_no, Model model) {
		System.out.println("RewardViewController \tprojectRewardView() [������Ʈ ������ ���� �Է� ȭ�� ��û] projcet_no : " + project_no);
		model.addAttribute("project_no",project_no);
		return "project/register/projectRewardView";
	}
	
}
