package kr.co.dream.mypage.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.service.MemberService;
import kr.co.dream.project.domain.ProjectVO;

@Controller
public class MypageViewController {

	//마이페이지 : 회원정보 화면 요청
	@RequestMapping(value = "/mypageMain")
	public String mypageMainView(int member_no) {
		System.out.println("마이 페이지 요청 :" + member_no);
		return "mypage/mypageMain";
	}
	
	//마이페이지 : 프로젝트 리스트 화면 요청
	@RequestMapping(value = "/myProject")
	public String myProjectList(int member_no){
		return "mypage/project/myProject";
	}

}
