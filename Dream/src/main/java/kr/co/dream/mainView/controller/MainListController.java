package kr.co.dream.mainView.controller;

import java.util.List;

import javax.inject.Inject;

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
	public List<ProjectVO> mainList(){
		List<ProjectVO> mainList = service.mainList();
		System.out.println("MainListController [mainList()] : " + mainList.toString());
		return mainList;
	}
}
