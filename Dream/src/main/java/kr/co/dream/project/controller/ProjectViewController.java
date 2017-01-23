package kr.co.dream.project.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dream.project.service.ProjectService;

@Controller
public class ProjectViewController {

	@Inject
	private ProjectService service;
	
	@RequestMapping(value = "projectInfoView")
	public String projectInfoView(Model model){
//		model.addAttribute("project", service.testSelectOne());
		return "project/projectInfoView";
	}
	
	@RequestMapping(value = "/projectStoryView")
	public String projectStoryView(){
		System.out.println("??");
		return "project/register/projectStoryView";
	}
}
