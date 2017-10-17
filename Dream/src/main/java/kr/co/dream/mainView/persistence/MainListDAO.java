package kr.co.dream.mainView.persistence;

import java.util.List;

import kr.co.dream.mainView.domain.CategoryProjectListDTO;
import kr.co.dream.mainView.domain.ProjectCategoryDTO;
import kr.co.dream.project.domain.ProjectPointDTO;

public interface MainListDAO {

	public List<ProjectPointDTO> new_project_list();
	public List<ProjectPointDTO> hot_project_list();
	public List<ProjectPointDTO> max_support_project();
	
	public List<ProjectCategoryDTO> project_category_count();

	public List<String> project_category_list();
	
	public List<CategoryProjectListDTO> main_project_category_list();
	public List<ProjectPointDTO> category_project_list_detail(String category);
	
	public List<ProjectPointDTO> project_title_search(String search_keyword);
	public List<ProjectPointDTO> project_category_search(String search_keyword);
}
