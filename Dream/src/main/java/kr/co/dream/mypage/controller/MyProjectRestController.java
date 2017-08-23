package kr.co.dream.mypage.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.service.ProjectService;

@RestController
public class MyProjectRestController {

	@Inject
	private ProjectService projectService;
	
	@RequestMapping(value = "/myProjectList/{request}/{member_no}", method = RequestMethod.GET)
	public ResponseEntity<List<ProjectPointDTO>> testRequest(@PathVariable String request, @PathVariable int member_no){
		ResponseEntity<List<ProjectPointDTO>> entity = null;
		System.out.println("ø‰√ª  : " +request);
		projectService.myProjectList(member_no, request);
		return entity;
	}
}
