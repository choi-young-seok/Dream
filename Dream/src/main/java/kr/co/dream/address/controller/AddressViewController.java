package kr.co.dream.address.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dream.address.service.AddressService;

@Controller
public class AddressViewController {

	@Inject
	private AddressService addressService;

	@RequestMapping(value = "/findAddressPop")
	public String findAddressPop(){
		System.out.println("AddressViewController \tfindAddressPop");
		return "support/find_Address_Pop";
	}
}
