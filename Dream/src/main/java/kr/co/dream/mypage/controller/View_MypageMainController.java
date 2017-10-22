package kr.co.dream.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class View_MypageMainController {
	
	//���������� : ����ȭ�� ��û
	@RequestMapping(value = "/mypage")
	public String mypageMainView() {
		System.out.println("View_MypageMainController \tmypageMainView");
		return "mypage/mypage_main";
	}
	
	@RequestMapping(value = "/mypage_project")
	public String mypage_project(){
		System.out.println("View_MyPageProjectController \tmypage_project");
		return "mypage/project/project_info";
	}
	
	@RequestMapping("/mypage_support")
	public String mypage_support(){
		System.out.println("View_MypageSupportController \tsupport");
		return "mypage/support/support_info";
	}
	
	//���������� : ȸ�� �ּ��� ��� ȭ�� ���
	@RequestMapping(value = "/mypage_address")
	public String mypage_address(){
		System.out.println("View_MypageAddressController \tmypage_address");
		return "mypage/address/address_info";
	}
	
	//���������� : ȸ�� �ּ��� ���� �߰� ȭ�� �̵�
	@RequestMapping(value = "/mypage_address_insert")
	public String mypage_address_insert(){
		System.out.println("View_MypageAddressController \tmypage_address_insert");
		return "mypage/address/address_info_insert";
	}

}
