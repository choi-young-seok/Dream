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
	
	//마이페이지 : 회원정보 화면 요청
	@RequestMapping(value = "/mypageMain")
	public String mypageMainView(int member_no) {
		System.out.println("마이 페이지 요청 :" + member_no);
		return "mypage/mypageMain";
	}
	
	//마이페이지 : 프로젝트 리스트 화면 요청
	@RequestMapping(value = "/myProjectMain")
	public String myProjectList(int member_no){
		return "mypage/project/myProjectMain";
	}
	
	//마이페이지 : 진행중, 지난, 등록중 프로젝트 정보 요청
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
	
	//마이페이지 : 후원간략 정보 요청
//	@RequestMapping(value="supportPointView")
//	public String support_point(int member_no, @RequestParam(value="payback_check", required = false, defaultValue = "N") String payback_check, Model model){
//		model.addAttribute("supportPoint",service.get_supportPointInfo(member_no, payback_check));
//		return "/mypage/support/mySupport";
//	}

}
