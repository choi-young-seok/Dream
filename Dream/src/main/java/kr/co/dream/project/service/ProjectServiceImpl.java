package kr.co.dream.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dream.address.persistence.AddressDAO;
import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectProfileDTO;
import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.persistence.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Inject
	private ProjectDAO dao;
	
	@Inject
	private AddressDAO addressDAO;

	// ----- ������Ʈ ��� -----
	// ������Ʈ �⺻���� ���
	@Override
	public int projectBasicInfo(ProjectVO projectBasicInfo) {
		return dao.projectBasicInfo(projectBasicInfo);
	}

	// ������Ʈ ���丮 ���� ���
	@Override
	public void projectStoryInfo(ProjectVO projectStoryInfo) {
		dao.projectStoryInfo(projectStoryInfo);
	}

	// ������Ʈ ������ ���� ���
	@Transactional
	@Override
	public void projectProfileInfo(ProjectProfileDTO projectProfileDTO) {
		dao.projectMemberProfile_update(projectProfileDTO);
		System.out.println("������Ʈ ������ ���� : " + projectProfileDTO);
		if(projectProfileDTO.getAddress_member_no() == 0){
			//0�ϰ�� ���ο� ����� ���� �Է�
			int address_member_no = addressDAO.insert_memberAddress(projectProfileDTO.getMemberAddressVO());
			System.out.println("������ ���� ��巹�� �ɹ� ��ȣ : " +address_member_no);
			projectProfileDTO.setAddress_member_no(address_member_no);
			dao.projectRegisterProfile_update(projectProfileDTO);	
			addressDAO.update_project_delivery_address(address_member_no);
//			projectProfileDTO.setAddress_member_no(address_member_no);
			
		}else{
			//0�� �ƴҰ�� ���� ����� ���� �Է�
			dao.projectRegisterProfile_update(projectProfileDTO);	
			addressDAO.update_project_delivery_address(projectProfileDTO.getAddress_member_no());
		}
	}

	// ������Ʈ ���� ���� ���
	@Override
	public void projectAccountInfo(ProjectVO projectAccountInfo) {
		System.out.println("ProjectServiceImpl \tprojectAccountInfo \t" + projectAccountInfo.toString());
		dao.projectAccountInfo(projectAccountInfo);
	}

	// ������Ʈ �̸����� ȭ�� : 1 ~ 5�ܰ��� ������Ʈ �Է� ���� ��ȸ
	@Transactional
	@Override
	public ProjectVO projectPreview(int project_no) {
		System.out.println("ProjectServiceImpl \tprojectPreview \t" + project_no);
		ProjectVO projectVO = dao.projectInfoView(project_no);
		projectVO.setRegister_profile(dao.get_projectRegisterProfile(projectVO.getMember_no()));
		return projectVO;
	}

	// ������Ʈ ���� ���
	@Override
	public void projectRegister(int project_no) {
		dao.projectRegister(project_no);
	}
	// ----- ������Ʈ ��� ���� �� -----

	// ������Ʈ ��ȸ ȭ�� �� ��ȸ�� ó��
	@Transactional
	@Override
	public ProjectVO projectInfoView(int project_no) {
		ProjectVO projectVO = dao.projectInfoView(project_no);
		projectVO.setRegister_profile(dao.get_projectRegisterProfile(projectVO.getMember_no()));
		dao.projectViewCnt(project_no);
		return projectVO;

	}

	// ������Ʈ ����ȭ�� ������Ʈ ���� ���� ��ȸ
	@Override
	public ProjectPointDTO support_project_point_info(int project_no) {
		return dao.support_project_point_info(project_no);
	}

	// ���������� ������Ʈ
	@Override
	public List<ProjectPointDTO> myProjectList(int member_no, String request) {
		if (request.equals("processing_project")) {
			System.out.println("���� �� ������Ʈ ���");
		} else if (request.equals("success_project")) {
			System.out.println("���� ������Ʈ ���");
		} else if (request.equals("expire_project")) {
			System.out.println("���� ������Ʈ ���");
		} else if (request.equals("during_registration")) {
			System.out.println("��� �� ������Ʈ ���");
		} else {

		}
		return null;
	}

	@Override
	public String get_projectRegisterProfile(int member_no) {
		return dao.get_projectRegisterProfile(member_no);
	}




}
