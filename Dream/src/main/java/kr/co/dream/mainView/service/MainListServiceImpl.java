package kr.co.dream.mainView.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dream.mainView.domain.CategoryProjectListDTO;
import kr.co.dream.mainView.domain.ProjectCategoryDTO;
import kr.co.dream.mainView.persistence.MainListDAO;
import kr.co.dream.project.domain.ProjectPointDTO;

@Service
public class MainListServiceImpl implements MainListService {

	@Inject
	private MainListDAO dao;

	@Override
	public Map<String, List<ProjectPointDTO>> main_project_list() {
		Map<String, List<ProjectPointDTO>> main_project_map = new HashMap<>();
		main_project_map.put("max_support_project", dao.max_support_project());
		System.out.println("최다후원 프로젝트 :"+main_project_map);
		main_project_map.put("hot_project_list", dao.hot_project_list());
		main_project_map.put("new_project_list", dao.new_project_list());
		return main_project_map;
	}

	@Override
	public List<ProjectCategoryDTO> project_category_count() {
		return dao.project_category_count();
	}

	@Override
	public List<CategoryProjectListDTO> main_project_category_list() {
		return dao.main_project_category_list();
	}

	@Override
	public List<ProjectPointDTO> category_project_list_detail(String category) {
		return dao.category_project_list_detail(category);
	}

	@Override
	@Transactional
	public Map<String, List<ProjectPointDTO>> project_search_result(String search_keyword) {
		Map<String, List<ProjectPointDTO>> search_result_map = new HashMap<>();
		search_result_map.put("project_title_result", dao.project_title_search(search_keyword));
		search_result_map.put("project_category_result", dao.project_category_search(search_keyword));
		return search_result_map;
	}

}
