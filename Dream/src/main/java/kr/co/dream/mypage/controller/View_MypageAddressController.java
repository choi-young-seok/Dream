package kr.co.dream.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class View_MypageAddressController {

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
