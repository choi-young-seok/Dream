package kr.co.dream.mypage.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dream.project.service.ProjectService;

@Controller
public class MypageProjectViewController {

	@Inject
	private ProjectService service;
	
	@RequestMapping(value = "/processing_project_View")
	public String processing_project_View(int member_no,Model model){
		System.out.println("���� �� ������Ʈ ����Ʈ ��� ȭ�� ȸ�� ��ȣ : "+member_no);
		model.addAttribute("processing_project_list",service.processing_project_list(member_no));
		return "mypage/project/processing_project_list";
	}
}
