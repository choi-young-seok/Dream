package kr.co.dream.reward.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.reward.domain.RewardVO;
import kr.co.dream.reward.domain.RewardsList;
import kr.co.dream.reward.service.RewardService;

@RestController
public class RewardRestController {

	@Inject
	private RewardService rewardService;

	// 리워드 등록
	@RequestMapping(value = "/projectRewardRegister", method = RequestMethod.POST)
	public ResponseEntity<String> rewardInfoRegister(@RequestBody RewardsList rewardsList, Model model) {
		System.out.println("RewardRestController \trewardInfoRegister \tinput value");
		ResponseEntity<String> entity = null;

		try {
			List<RewardVO> rewards = rewardsList.getRewardsList();

			for (int i = 0; i < rewards.size(); i++) {
				System.out.println(rewards.get(i).toString());
			}

			rewardService.rewardInfoRegister(rewards);
			int project_no = rewards.get(0).getProject_no();
			entity = new ResponseEntity<String>("" + project_no, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}

		return entity;
	}
}
