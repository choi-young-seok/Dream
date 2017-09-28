package kr.co.dream.mypage.controller;



import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dream.mypage.domain.MyProjectCondition;
import kr.co.dream.mypage.service.MyProjectService;
import kr.co.dream.project.domain.ProjectVO;

@Controller
public class MypageProjectViewController {

	@Inject
	private MyProjectService service;
	
	//���������� : ȸ������ ȭ�� ��û
	@RequestMapping(value = "/mypageMain")
	public String mypageMainView(int member_no) {
		System.out.println("���� ������ ��û :" + member_no);
		return "mypage/mypageMain";
	}
	
	//���������� : ������Ʈ ����Ʈ ȭ�� ��û
	@RequestMapping(value = "/myProjectMain")
	public String myProjectList(int member_no){
		return "mypage/project/myProjectMain";
	}
	
	//���������� : ������, ����, ����� ������Ʈ ���� ��û
	@RequestMapping(value = "myProject")
	public String myProject(MyProjectCondition projectCondition, Model model){
		System.out.println(projectCondition.toString());
		if(projectCondition.getRequest().equals("during_registration")){
			ProjectVO projectVO = service.during_registration(projectCondition);
			model.addAttribute("during_registration",service.during_registration(projectCondition));
		}else{
			model.addAttribute("myProject",service.myProjectList(projectCondition));			
		}
		model.addAttribute("condition",projectCondition);
		return "mypage/project/myProjectMain";
	}
	
	//���������� : �Ŀ����� ���� ��û
//	@RequestMapping(value="supportPointView")
//	public String support_point(int member_no, @RequestParam(value="payback_check", required = false, defaultValue = "N") String payback_check, Model model){
//		model.addAttribute("supportPoint",service.get_supportPointInfo(member_no, payback_check));
//		return "/mypage/support/mySupport";
//	}

}
