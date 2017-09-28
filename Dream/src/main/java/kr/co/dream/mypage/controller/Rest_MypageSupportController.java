package kr.co.dream.mypage.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.mypage.service.MySupportService;
import kr.co.dream.support.domain.SupportPointDTO;

@RestController
public class Rest_MypageSupportController {

	@Inject
	private MySupportService mySupportService;
	
	@RequestMapping(value = "/get_mySupport_reward_info_list/{member_no}/{payback_check}", method = RequestMethod.GET)
	public ResponseEntity<List<SupportPointDTO>> get_mySupport_reward_info_list(
			@PathVariable("member_no") int member_no, 
			@PathVariable(value ="payback_check", required=false) String payback_check){
		
		System.out.println("Rest_MypageSupportController \tget_support_info input value : " +member_no+""+ payback_check);
		
		ResponseEntity<List<SupportPointDTO>> entity = null;
		entity = new ResponseEntity<List<SupportPointDTO>>(mySupportService.get_mySupport_reward_info_list(member_no, payback_check), HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value = "/get_mySupport_noReward_info_list/{member_no}/{payback_check}", method = RequestMethod.GET)
	public ResponseEntity<List<SupportPointDTO>> get_mySupport_noReward_info_list(
			@PathVariable("member_no") int member_no, 
			@PathVariable(value ="payback_check", required=false) String payback_check){
		
		System.out.println("Rest_MypageSupportController \tget_mySupport_noReward_info_list input value : " +member_no+""+ payback_check);
		
		ResponseEntity<List<SupportPointDTO>> entity = null;
		entity = new ResponseEntity<List<SupportPointDTO>>(mySupportService.get_mySupport_noReward_info_list(member_no, payback_check), HttpStatus.OK);
		return entity;
	}
}
