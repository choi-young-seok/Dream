package kr.co.dream.project.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.service.ProjectService;
import kr.co.dream.reward.service.RewardService;

@Controller
public class ProjectViewController {
	
	@Inject
	private ProjectService service;
	
	@Inject
	private RewardService rewardService;
	
	//프로젝트 미리보기 화면 요청
	@RequestMapping(value = "/projectPreView")
	public String projectPreView(Model model, @RequestParam int project_no) {
		System.out.println("ProjectRegisterViewController \tprojectInfoView() [프로젝트 미리보기 화면 요청] : " + project_no);
		try {
			model.addAttribute("project_no",project_no);
			ProjectVO projectVO = service.projectPreview(project_no);
			model.addAttribute("project", projectVO);
			model.addAttribute("rewards", rewardService.rewardList(project_no));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(service.projectPreview(project_no).toString());
		return "project/projectInfoView";
	}
	
	//프로젝트 조회 화면
	@RequestMapping(value = "/projectInfoView")
	public String projectInfoView(Model model, @RequestParam int project_no) {
		System.out.println("ProjectRegisterViewController \tprojectInfoView() [프로젝트 조회 화면 요청] : " + project_no);
		try {
			model.addAttribute("project_no",project_no);
			ProjectVO projectVO = service.projectInfoView(project_no);
			model.addAttribute("project", projectVO);
			model.addAttribute("rewards", rewardService.rewardList(project_no));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(service.projectPreview(project_no).toString());
		return "project/projectInfoView";
	}
}
