package kr.co.dream.mypage.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dream.mypage.domain.MyProjectCondition;
import kr.co.dream.mypage.service.MyProjectService;
import kr.co.dream.project.domain.ProjectVO;

@Controller
public class View_MyPageProjectController {

	@Inject
	private MyProjectService service;
	
	//마이페이지 : 진행중, 지난, 등록중 프로젝트 정보 요청
	@RequestMapping(value = "/mypage_project")
	public String mypage_project(){
		System.out.println("View_MyPageProjectController \tmypage_project");
//		System.out.println(projectCondition.toString());
//		if(projectCondition.getRequest().equals("during_registration")){
//			ProjectVO projectVO = service.during_registration(projectCondition);
//			model.addAttribute("during_registration",service.during_registration(projectCondition));
//		}else{
//			model.addAttribute("myProject",service.myProjectList(projectCondition));			
//		}
//		model.addAttribute("condition",projectCondition);
		return "mypage/project/project_info";
	}
}
