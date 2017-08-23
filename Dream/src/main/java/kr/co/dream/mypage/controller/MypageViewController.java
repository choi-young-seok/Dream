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

	//���������� : ȸ������ ȭ�� ��û
	@RequestMapping(value = "/mypageMain")
	public String mypageMainView(int member_no) {
		System.out.println("���� ������ ��û :" + member_no);
		return "mypage/mypageMain";
	}
	
	//���������� : ������Ʈ ����Ʈ ȭ�� ��û
	@RequestMapping(value = "/myProject")
	public String myProjectList(int member_no){
		return "mypage/project/myProject";
	}

}
