package kr.co.dream.support.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dream.project.reward.service.RewardService;
import kr.co.dream.project.service.ProjectService;
import kr.co.dream.support.domain.SupportVO;
import kr.co.dream.support.service.SupportService;
import kr.co.dream.support.service.SupportServiceImpl;

@Controller
public class SupportViewController {

	@Inject
	private ProjectService projectService;

	@Inject
	private SupportService service;

	@Inject
	private RewardService rewardService;

	private static final Logger logger = LoggerFactory.getLogger(SupportServiceImpl.class);

	@RequestMapping("/supportForm")
	public String supportForm(SupportVO supportVO, Model model, @RequestParam int project_no) {
		System.out.println("SupportViewController \tsupportForm \tinput value : " + supportVO.toString());
		System.out.println("SupportViewController \t프로젝트 번호 : " + project_no);

		// System.out.println(projectService.projectPreview(project_no));
		model.addAttribute("project", projectService.projectPreview(project_no));
		model.addAttribute("rewards", rewardService.rewardList(project_no));

		return "/support/supportView";
	}

	@RequestMapping("/pay_info_registForm")
	public String pay_info_registForm(@RequestParam int reward_no, int project_no, int support_amount, Model model) {
		System.out.println("SupportViewController \tpay_info_registForm \tinput value [reward_no]:" + reward_no
				+ " [support_amount] : " + support_amount);
		model.addAttribute("project", projectService.projectPreview(project_no));
		model.addAttribute("support_amount", support_amount);
		model.addAttribute("reward_no", reward_no);
		model.addAttribute("rewardVO", rewardService.getReward(reward_no));
		return "/support/pay_info_registForm";
	}

	@RequestMapping(value = "supportCompleteView", method = RequestMethod.GET)
	public String support_register(@RequestParam int support_no, String shipping_address_no, Model model) {
		System.out.println("요청진입");
		System.out.println(shipping_address_no);

		if (shipping_address_no.equals("noReward")) {
			shipping_address_no = "0";
			SupportVO supportVO = service.get_supportInfo(support_no, Integer.parseInt(shipping_address_no));
			
			System.out.println(supportVO.toString());
			model.addAttribute("supportVO", supportVO);
			if (supportVO.getRewardVO() == null) {
				return "/support/supportCompleteView";
			}
		}
			SupportVO supportVO = service.get_supportInfo(support_no, Integer.parseInt(shipping_address_no));
			model.addAttribute("supportVO", supportVO);
			model.addAttribute("addressVO", supportVO.getAddressVO());
			model.addAttribute("itemsVO", supportVO.getRewardVO());
			System.out.println(supportVO.getAddressVO().toString());
			System.out.println(supportVO.getRewardVO().toString());
		// logger.info(supportVO.toString());
		// logger.info(supportVO.getAddressVO().toString());
		// logger.info(supportVO.getRewardVO().toString());

		return "/support/supportCompleteView";
	}

}
