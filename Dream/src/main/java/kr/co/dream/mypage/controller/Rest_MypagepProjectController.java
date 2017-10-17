package kr.co.dream.mypage.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.mypage.domain.MyProjectCondition;
import kr.co.dream.mypage.service.MyProjectService;
import kr.co.dream.project.domain.ProjectPointDTO;

@RestController
public class Rest_MypagepProjectController {
	
	@Inject
	private MyProjectService service;
	
	@RequestMapping(value = "/get_myProject_list/{member_no}/{request}/{success_state}", method = RequestMethod.GET)
	public ResponseEntity<List<ProjectPointDTO>> get_myProject_list(
			@PathVariable("member_no") int member_no,
			@PathVariable("request") String request, 
			@PathVariable("success_state") String success_state
			){
		System.out.println("Rest_MypagepProjectController \tget_myProject_list : " +request+", "+member_no+", "+success_state);
		
		MyProjectCondition condition = new MyProjectCondition();
		condition.setMember_no(member_no);
		condition.setRequest(request);
		condition.setSuccess_state(success_state);
		
		
		ResponseEntity<List<ProjectPointDTO>> entity = null;
		entity = new ResponseEntity<List<ProjectPointDTO>>(service.myProjectList(condition), HttpStatus.OK);
		return entity;
	}
	
}
