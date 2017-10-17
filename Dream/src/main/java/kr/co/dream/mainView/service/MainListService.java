package kr.co.dream.mainView.service;

import java.util.List;
import java.util.Map;
import java.util.Locale.Category;

import kr.co.dream.mainView.domain.CategoryProjectListDTO;
import kr.co.dream.mainView.domain.ProjectCategoryDTO;
import kr.co.dream.project.domain.ProjectPointDTO;
import oracle.net.aso.l;

public interface MainListService {
	
	public Map<String, List<ProjectPointDTO>> main_project_list();
	
	public List<ProjectCategoryDTO> project_category_count();
	public List<CategoryProjectListDTO> main_project_category_list();
	public List<ProjectPointDTO> category_project_list_detail(String category);
	
	public Map<String, List<ProjectPointDTO>> project_search_result(String search_keyword);
}
