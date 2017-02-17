package kr.co.dream.project.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.service.ProjectService;

@RestController
public class ProjectRestController {

	@Inject
	private ProjectService service;
	
	@RequestMapping(value = "/basicInfoRegister", method = RequestMethod.POST)
	public ResponseEntity<String> basicInfoRegister(@RequestBody ProjectVO projectBasicInfo, HttpSession session){
		System.out.println("ProjectRestController \tbasicInfoRegister \tinput value : "+projectBasicInfo.toStringProjectBasicInfo());
		ResponseEntity<String> entity = null;
//		projectBasicInfo.setMember_mail();
		try {
			int project_no = service.projectBasicInfo(projectBasicInfo);
			System.out.println("입력한 프로젝트 번호 : "+project_no);
			projectBasicInfo.setProject_no(project_no);
			ProjectVO project = new ProjectVO();
			project.setProject_no(project_no);
			session.setAttribute("project",project);
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {			
			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	@RequestMapping(value = "/projectRewardRegister", method = RequestMethod.POST)
	public ResponseEntity<String> rewardInfoRegister(@RequestBody ProjectVO projectBasic){
		System.out.println("ProjectRestController \tbasicInfoRegister \tinput value : "+projectBasic.toString());
		ResponseEntity<String> entity = null;
		
		return entity;
	}
	
	@RequestMapping(value = "/projectProfileRegister", method = RequestMethod.POST)
	public ResponseEntity<String> projectProfileRegister(@RequestBody ProjectVO projectProfileInfo){
		System.out.println("ProjectRestController \tprojectProfileRegister \tinput value : "+projectProfileInfo.toStringProjectProfileInfo());
		ResponseEntity<String> entity = null;
		
		try {
			service.projectProfileInfo(projectProfileInfo);
			entity = new ResponseEntity<>("success",HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	@RequestMapping(value = "/projectAccountRegister", method = RequestMethod.POST)
	public ResponseEntity<String> projectAccountRegister(@RequestBody ProjectVO projectAccountInfo){
		System.out.println("ProjectRestController \tprojectAccountRegister \tinput value : "+projectAccountInfo.toStringAccountInfo());
		ResponseEntity<String> entity = null;
		
		try {
			service.projectAccountInfo(projectAccountInfo);
			entity = new ResponseEntity<>("success",HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	@RequestMapping(value = "/projectRegister", method = RequestMethod.POST)
	public ResponseEntity<String> projectRegister(int project_no){
		System.out.println("ProjectRestController \tprojectRegister \tinput value : " + project_no);
		ResponseEntity<String> entity = null;
		
		try {
			service.projectRegister(project_no);
			entity = new ResponseEntity<>("success",HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	

	
}
