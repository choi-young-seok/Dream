package kr.co.dream.mainView.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.mainView.service.MainListService;
import kr.co.dream.project.domain.ProjectPointDTO;

@RestController
public class MainListController {

	@Inject
	private MainListService service;

	@RequestMapping(value = "/mainList", method = RequestMethod.POST)
	public ResponseEntity<List<ProjectPointDTO>> mainList() {
		ResponseEntity<List<ProjectPointDTO>> entity = null;
		entity = new ResponseEntity<List<ProjectPointDTO>>(service.mainList(), HttpStatus.OK);
		return entity;
	}
}
