package kr.co.dream.support.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dream.address.service.AddressService;
import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.service.ProjectService;
import kr.co.dream.reward.service.RewardService;
import kr.co.dream.support.domain.SupportDetailDTO;
import kr.co.dream.support.domain.SupportVO;
import kr.co.dream.support.service.SupportService;

@Controller
public class View_supportController {

	@Inject
	private ProjectService projectService;

	@Inject
	private SupportService supportService;

	@Inject
	private RewardService rewardService;
	
	@Inject
	private AddressService addressService;

	//������ ���� ȭ��
	@RequestMapping(value = "/support_choice_View", method = RequestMethod.GET)
	public String support_choice_View(SupportVO supportVO, Model model, @RequestParam int project_no) {
		System.out.println("SupportViewController \tsupportForm \tinput value : " + supportVO.toString());
		System.out.println("SupportViewController \t������Ʈ ��ȣ : " + project_no);

		// System.out.println(projectService.projectPreview(project_no));
		//�̺κ� MyBatis Collection���� ó���Ͽ� ProjectVO in List<RewardVO>�� ó��
		ProjectPointDTO projectVO = projectService.support_project_point_info(project_no);
		model.addAttribute("project", projectVO);
		model.addAttribute("rewards", rewardService.rewardList(project_no));

		return "/support/supportView";
	}
	//������ ���� �Ŀ� �Ŀ��ϱ� ��
	@RequestMapping(value ="support_NoReward_View" ,method = RequestMethod.GET)
	public String support_NoReward_View(@RequestParam int project_no, @RequestParam int support_amount, Model model){
		
		model.addAttribute("project",projectService.support_project_point_info(project_no));
		model.addAttribute("support_amount", support_amount);
		
		return "/support/support_noReward_view";
	}

	//������ �ִ� �Ŀ� �Ŀ��ϱ� ��
	@RequestMapping("/support_selectReward_view")
	public String support_selectReward_view(@RequestParam int member_no, int reward_no, int project_no, int support_amount, Model model) {
		System.out.println("SupportViewController \tpay_info_registForm \tinput value [reward_no]:" + reward_no
				+ " [support_amount] : " + support_amount);
		//������Ʈ ��������
		model.addAttribute("project", projectService.projectPreview(project_no));
		//�Ŀ��ݾ�
		model.addAttribute("support_amount", support_amount);
		//���� ������ ��ȣ
		model.addAttribute("rewardVO", rewardService.getReward(reward_no));

		int member_addressCount = addressService.get_memberAddress_count(member_no);
		
		if(member_addressCount == 0){
			model.addAttribute("addressInfo","noMemberAddress");
		}else {
			//ȸ�� �⺻ �����
			model.addAttribute("addressInfo", addressService.get_laterMemberAddress(member_no));
		}

		return "/support/support_selectReward_view";
	}
	
	//������ �Ŀ� �Ϸ�ȭ��
	@RequestMapping(value = "supportDetailView_reward", method = RequestMethod.GET)
	public String supportDetailView_reward(@RequestParam int member_no ,@RequestParam int support_no, @RequestParam(value="payback_check" ,required=false, defaultValue="N") String payback_check, Model model) {
		System.out.println("contoller supportDetailView_reward");
		System.out.println("member_no : "+member_no);
		SupportDetailDTO detailDTO =  supportService.get_SupportDetail(member_no, support_no,payback_check);
		model.addAttribute("support_no",support_no);
		model.addAttribute("supportDetail", detailDTO);

		return "/support/supportDetailView_reward";
	}
	//������ �Ŀ� �Ϸ�ȭ��
	@RequestMapping(value = "supportDetailView_noReward", method = RequestMethod.GET)
	public String supportDetailView_noReward(@RequestParam int member_no ,@RequestParam int support_no, @RequestParam(value="payback_check" ,required=false, defaultValue="N") String payback_check, Model model) {
		System.out.println("contoller supportDetailView_noReward");
		System.out.println("member_no : "+member_no);
		SupportDetailDTO detailDTO =  supportService.get_SupportDetail(member_no, support_no,payback_check);
		model.addAttribute("support_no",support_no);
		model.addAttribute("supportDetail", detailDTO);
		
		return "/support/supportDetailView_noReward";
	}

}
