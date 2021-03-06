package kr.co.dream.project.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.project.domain.ProjectProfileDTO;
import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.service.ProjectService;

@RestController
public class Rest_projectController {

	@Inject
	private ProjectService service;

	// 프로젝트 기본 정보 등록 요청
	@RequestMapping(value = "/basicInfoRegister", method = RequestMethod.POST)
	public ResponseEntity<String> basicInfoRegister(@RequestBody ProjectVO projectBasicInfo, HttpSession session) {
		System.out.println("ProjectRestController \tbasicInfoRegister \tinput value : " + projectBasicInfo.toString());
		ResponseEntity<String> entity = null;

		try {
			int project_no = service.projectBasicInfo(projectBasicInfo);
			System.out.println("입력한 프로젝트 번호 : " + project_no);
			projectBasicInfo.setProject_no(project_no);
			entity = new ResponseEntity<>("" + project_no, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}

	// 프로젝트 등록자 프로필 정보 등록 요청
	@RequestMapping(value = "/projectProfileRegister", method = RequestMethod.POST)
	public ResponseEntity<String> projectProfileRegister(@RequestBody ProjectProfileDTO projectProfileDTO) {
		System.out.println(
				"ProjectRestController \tprojectProfileRegister \tinput value : " + projectProfileDTO.toString());
		ResponseEntity<String> entity = null;

		try {
			 service.projectProfileInfo(projectProfileDTO);
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}

	// 프로젝트 계좌 정보 등록 요청
	@RequestMapping(value = "/projectAccountRegister", method = RequestMethod.POST)
	public ResponseEntity<String> projectAccountRegister(@RequestBody ProjectVO projectAccountInfo) {
		System.out.println(
				"ProjectRestController \tprojectAccountRegister \tinput value : " + projectAccountInfo.toString());
		ResponseEntity<String> entity = null;

		try {
			service.projectAccountInfo(projectAccountInfo);
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}

	// 프로젝트 미리보기 -> 최종등록 요청
	@RequestMapping(value = "/projectRegister", method = RequestMethod.POST)
	public ResponseEntity<String> projectRegister(int project_no) {
		System.out.println("ProjectRestController \tprojectRegister \tinput value : " + project_no);
		ResponseEntity<String> entity = null;

		try {
			service.projectRegister(project_no);
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}

}
