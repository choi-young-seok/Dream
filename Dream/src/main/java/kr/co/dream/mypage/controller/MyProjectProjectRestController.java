package kr.co.dream.mypage.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.mypage.service.MyProjectService;
import kr.co.dream.project.domain.ProjectPointDTO;

@RestController
public class MyProjectProjectRestController {

	@Inject
	private MyProjectService service;
	
	@RequestMapping(value = "/myProjectList/{request}/{member_no}", method = RequestMethod.GET)
	public ResponseEntity<List<ProjectPointDTO>> testRequest(@PathVariable String request, @PathVariable int member_no){
		ResponseEntity<List<ProjectPointDTO>> entity = null;
		System.out.println("ø‰√ª  : " +request);
		return entity;
	}
	
//	@RequestMapping(value = "/myProjectList2")
//	public ResponseEntity<Map<String, Object>> testRequest(MyProjectCondition projectCondition){
////		service.myProjectList(projectCondition);
//		ResponseEntity<Map<String, Object>> entity = new ResponseEntity<Map<String, Object>>(service.myProjectList(projectCondition), HttpStatus.OK);
//		return entity;
//	}
}
