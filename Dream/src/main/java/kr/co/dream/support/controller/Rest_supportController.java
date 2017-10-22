package kr.co.dream.support.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.reward.service.RewardService;
import kr.co.dream.support.domain.SupportVO;
import kr.co.dream.support.domain.supportPayInfoDTO;
import kr.co.dream.support.service.SupportService;

@RestController
public class Rest_supportController {

	@Inject
	private SupportService service;

	@Inject
	private RewardService rewardService;

	@RequestMapping(value = "/get_pay_reward/{reward_no}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> get_pay_reward(@PathVariable("reward_no") int reward_no) {
		System.out.println("pathVariable을 통한 param input : " + reward_no);
		Map<String, Object> map = new HashMap<>();
		// 리워드 없는 후원
		if (reward_no == 0) {
			map.put("reward_no", "noReward");
		}
		// 리워드를 선택한 후원
		else {
			// 선택한 리워드 정보
			map.put("rewardVO", rewardService.getReward(reward_no));
//			model.addAttribute("rewardVO", rewardService.getReward(reward_no));
		}

		ResponseEntity<Map<String, Object>> entity = null;
		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		return entity;
	}

	@RequestMapping(value = "supportRegister_reward", method = RequestMethod.POST)
	public ResponseEntity<Integer> supportRegister_reward(@RequestBody SupportVO supportVO) {
		System.out.println("SupportRestController \tsupportRegister_reward");
		System.out.println(supportVO.toString());
		ResponseEntity<Integer> entity = null;
		
		try {
			entity = new ResponseEntity<Integer>(service.supportRegister_reward(supportVO), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return entity;
	}
	
	@RequestMapping(value = "supportRegister_noReward", method = RequestMethod.POST)
	public ResponseEntity<Integer> supportRegister_noReward(@RequestBody SupportVO supportVO) {
		System.out.println("SupportRestController \tsupportRegister_noReward");
		System.out.println(supportVO.toString());
		ResponseEntity<Integer> entity = null;
		
		try {
			entity = new ResponseEntity<Integer>(service.supportRegister_noReward(supportVO), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return entity;
	}


//	후원완료 화면 환불정보 수정
	@RequestMapping(value = "/update_paybackInfo", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> update_paybackInfo(@RequestBody supportPayInfoDTO payInfoDTO) {
		service.update_paybackInfo(payInfoDTO);
		ResponseEntity<String> entity = null;
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		return entity;
	}
}
