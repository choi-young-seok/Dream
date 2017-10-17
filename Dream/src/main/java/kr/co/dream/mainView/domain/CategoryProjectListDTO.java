package kr.co.dream.mainView.domain;

import java.util.List;

import kr.co.dream.project.domain.ProjectPointDTO;
import lombok.Data;

@Data
public class CategoryProjectListDTO {

	private String project_category;
	private List<ProjectPointDTO> projectPointDTOs;
}
