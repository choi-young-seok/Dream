package kr.co.dream.address.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddressViewController {

	@RequestMapping(value = "/findAddressPop")
	public String findAddressPop() {
		System.out.println("AddressViewController \tfindAddressPop");
		return "support/find_Address_Pop";
	}

	@RequestMapping(value = "/get_changeAdress_list")
	public String get_changeAdress_list(int member_no, Model model) {
		model.addAttribute("session_no", member_no);
		return "jsp_piece/address/supportView_address_list";
	}
	
	@RequestMapping(value = "/choice_address_insert")
	public String choice_address_insert(int member_no, Model model) {
		model.addAttribute("session_no", member_no);
		return "jsp_piece/address/supportView_address_insert";
	}


}
