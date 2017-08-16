package kr.co.dream.support.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.address.domain.FindResultAddressVO;
import kr.co.dream.address.domain.ShippingAddressVO;
import kr.co.dream.project.reward.service.RewardService;
import kr.co.dream.support.domain.ShippingItemsVO;
import kr.co.dream.support.domain.SupportVO;
import kr.co.dream.support.service.SupportService;
import kr.co.dream.support.service.SupportServiceImpl;

@RestController
public class SupportRestController {

	@Inject
	private SupportService service;

	@Inject
	private RewardService rewardService;

	private static final Logger logger = LoggerFactory.getLogger(SupportServiceImpl.class);

	@RequestMapping(value = "/get_pay_reward/{reward_no}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> get_pay_reward(@PathVariable("reward_no") int reward_no, Model model) {
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

	@RequestMapping(value = "supportRegister", method = RequestMethod.POST)
	public ResponseEntity<ShippingItemsVO> support_register(@RequestBody SupportVO supportVO) {

		ResponseEntity<ShippingItemsVO> entity = null;
		
		try {
			ShippingItemsVO itemsVO =  service.supportRegister(supportVO);
			System.out.println("등록 성공");
			entity = new ResponseEntity<ShippingItemsVO>(itemsVO, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return entity;
	}

}
