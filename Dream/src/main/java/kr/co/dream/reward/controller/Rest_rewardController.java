package kr.co.dream.reward.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.reward.domain.RewardVO;
import kr.co.dream.reward.service.RewardService;

@RestController
public class Rest_rewardController {

	@Inject
	private RewardService rewardService;

	// 리워드 조회
	@RequestMapping(value = "/get_rewardInfo/{total_reward_no}", method = RequestMethod.GET)
	public ResponseEntity<RewardVO> get_rewardInfo(@PathVariable("total_reward_no") int total_reward_no) {
		System.out.println("RewardRestController \tget_rewardInfo \tinput value : " + total_reward_no);

		ResponseEntity<RewardVO> entity = null;
		try {
			entity = new ResponseEntity<RewardVO>(rewardService.getReward(total_reward_no), HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;

	}

	// 리워드 목록 조회
	@RequestMapping(value = "/get_rewardInfo_list/{project_no}", method = RequestMethod.GET)
	public ResponseEntity<List<RewardVO>> get_rewardInfo_list(@PathVariable("project_no") int project_no) {
		System.out.println("RewardRestController \tget_rewardInfo \tinput value : " + project_no);

		ResponseEntity<List<RewardVO>> entity = null;

		try {
			entity = new ResponseEntity<List<RewardVO>>(rewardService.rewardList(project_no), HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}

		return entity;
	}
}
