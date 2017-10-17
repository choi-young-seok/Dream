package kr.co.dream.mainView.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.mainView.domain.CategoryProjectListDTO;
import kr.co.dream.mainView.domain.ProjectCategoryDTO;
import kr.co.dream.project.domain.ProjectPointDTO;

@Repository
public class MainListDAOImpl implements MainListDAO{
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public List<ProjectPointDTO> new_project_list() {
		return sqlSession.selectList("mainList.new_project_list", null, new RowBounds(0, 8));
	}

	@Override
	public List<ProjectPointDTO> hot_project_list() {
		return sqlSession.selectList("mainList.hot_project_list", null, new RowBounds(0, 8));
	}
	
	@Override
	public List<ProjectPointDTO> max_support_project() {
		return sqlSession.selectList("mainList.max_support_project");
	}

	@Override
	public List<ProjectCategoryDTO> project_category_count() {
		return sqlSession.selectList("mainList.project_category_count");
	}

	@Override
	public List<CategoryProjectListDTO> main_project_category_list() {
		return sqlSession.selectList("mainList.project_category_list");
	}

	@Override
	public List<ProjectPointDTO> category_project_list_detail(String category) {
		return sqlSession.selectList("mainList.category_project_list_detail",category);
	}

	@Override
	public List<String> project_category_list() {
		return sqlSession.selectList("mainList.project_category_list");
	}

	@Override
	public List<ProjectPointDTO> project_title_search(String search_keyword) {
		return sqlSession.selectList("project_search.search_project_title", search_keyword);
	}

	@Override
	public List<ProjectPointDTO> project_category_search(String search_keyword) {
		return sqlSession.selectList("project_search.search_project_category", search_keyword);
	}





}
