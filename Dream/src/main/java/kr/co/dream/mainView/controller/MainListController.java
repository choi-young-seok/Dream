package kr.co.dream.mainView.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.mainView.domain.CategoryProjectListDTO;
import kr.co.dream.mainView.service.MainListService;
import kr.co.dream.project.domain.ProjectPointDTO;

@RestController
public class MainListController {

	@Inject
	private MainListService service;

	@RequestMapping(value = "/mainList", method = RequestMethod.POST)
	public ResponseEntity<Map<String, List<ProjectPointDTO>>> mainList() {
		ResponseEntity<Map<String, List<ProjectPointDTO>>> entity = null;

		entity = new ResponseEntity<Map<String, List<ProjectPointDTO>>>(service.main_project_list(), HttpStatus.OK);
		return entity;
	}

	@RequestMapping(value = "main_category_list/{category}", method = RequestMethod.GET)
	public ResponseEntity<List<ProjectPointDTO>> main_category_list(@PathVariable("category") String category) {
		System.out.println("MainListController \tmain_category_list input value : " + category);
		ResponseEntity<List<ProjectPointDTO>> entity = null;
		entity = new ResponseEntity<List<ProjectPointDTO>>(service.category_project_list_detail(category),
				HttpStatus.OK);
		return entity;
	}

	@RequestMapping(value = "main_category_project", method = RequestMethod.GET)
	public ResponseEntity<List<CategoryProjectListDTO>> main_category_project() {
		ResponseEntity<List<CategoryProjectListDTO>> entity = null;
		entity = new ResponseEntity<List<CategoryProjectListDTO>>(service.main_project_category_list(), HttpStatus.OK);
		return entity;
	}

	@RequestMapping(value = "project_search/{search_keyword}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, List<ProjectPointDTO>>> project_search(
			@PathVariable("search_keyword") String search_keyword) {
		System.out.println(" 검색어 요청 : " + search_keyword);
		ResponseEntity<Map<String, List<ProjectPointDTO>>> entity = null;
		entity = new ResponseEntity<Map<String, List<ProjectPointDTO>>>(service.project_search_result(search_keyword),
				HttpStatus.OK);
		return entity;
	}
}
