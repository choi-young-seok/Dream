package kr.co.dream.mainView.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dream.mainView.service.MainListService;

@Controller
public class View_mainController {
	@Inject
	private MainListService mainListService;

	@RequestMapping("/main_category")
	public String main_category(Model model){
		model.addAttribute("project_category",mainListService.project_category_count());
		return "mainView/main_category";
	}
	
	@RequestMapping("/project_category")
	public String project_category(String category, Model model){
		System.out.println(category);
		model.addAttribute("category", category);
		return "mainView/category_project_list";
	}
	
	@RequestMapping("/search_result_view")
	public String search_result_view(String search_keyword, Model model){
		System.out.println(search_keyword);
		model.addAttribute("search_keyword", search_keyword);
		return "mainView/search_result_view";
	}
	
	
}
