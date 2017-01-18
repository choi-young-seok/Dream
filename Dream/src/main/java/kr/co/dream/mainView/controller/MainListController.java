package kr.co.dream.mainView.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.mainView.service.MainListService;
import kr.co.dream.project.domain.ProjectVO;

@RestController
public class MainListController {

	@Inject
	private MainListService service;
	
	@RequestMapping(value ="/mainList" , method = RequestMethod.POST)
	public ResponseEntity<List<ProjectVO>> mainList(){
		ResponseEntity<List<ProjectVO>> entity = null;
		entity = new ResponseEntity<List<ProjectVO>>(service.mainList(), HttpStatus.OK);
		
		for (int i = 0; i < entity.getBody().size(); i++) {
			ProjectVO project = entity.getBody().get(i);
			System.out.println("MainListController mainList() output value] : "+project);
		}
		return entity;
	}
}
