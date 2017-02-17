package kr.co.dream.project.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.service.ProjectService;

@RestController
public class ProjectViewController {

	@Inject
	private ProjectService service;

	// @RequestMapping(value = "/projectInfoView")
	// public String projectInfoView(int project_no){
	// System.out.println("ProjectViewController \tprojectInfoView \tinput value : "+project_no);
	// service.projectInfoView(project_no);
	//
	// return "project/projectInfoView";
	// }

	@RequestMapping(value = "/processing_project_list")
	public ResponseEntity<List<ProjectVO>> processing_project_list(int member_no) {
		ResponseEntity<List<ProjectVO>> entity = null;
		System.out.println("projetViewController \tprocessing_project_list() \tinput value : " + member_no);
		List<ProjectVO> projectList = service.processing_project_list(member_no);
		System.out.println(projectList.size());
		entity = new ResponseEntity<List<ProjectVO>>(projectList, HttpStatus.OK);
		return entity;
	}
}
