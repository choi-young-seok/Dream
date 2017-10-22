package kr.co.dream.project.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dream.address.service.AddressService;
import kr.co.dream.member.service.MemberService;
import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.service.ProjectService;
import kr.co.dream.reward.service.RewardService;
import kr.co.dream.upload.util.PhotoVo;

@Controller
public class View_projectController {

	@Inject
	private ProjectService projectService;
	
	@Inject
	private AddressService addressService;
	
	@Inject
	private RewardService rewardService;

	// ������Ʈ �⺻ ���� �Է� ȭ�� ��û
	@RequestMapping(value = "/projectRegiterView")
	public String projectRegiterView(Model model) {
		System.out.println("ProjectRegisterViewController \tprojectBasicInfoView() [������Ʈ �⺻ ���� �Է� ȭ�� ��û]");
		return "project/register/projectBasicInfoView";
	}

	// ������Ʈ ���丮 ���� �Է� ȭ�� ��û
	@RequestMapping(value = "/projectStoryView")
	public String projectStoryView(@RequestParam int project_no, Model model) {
		System.out.println("ProjectRegisterViewController \tprojectStoryView() [������Ʈ ���丮 ���� �Է� ȭ�� ��û]");
		System.out.println("������Ʈ ��ȣ : " + project_no);
		model.addAttribute("project_no", project_no);
		// System.out.println(reward.toString());
		return "project/register/projectStoryView";
		// return "redirect:project/register/projectStoryView";
	}

	// ������Ʈ ������ ���� �Է� ȭ�� ��û
	@RequestMapping(value = "/projectProfileView", method = RequestMethod.POST)
	public String projectProfileView(ProjectVO projectStoryInfo, Model model) {
		System.out.println("ProjectRegisterViewController \tprojectProfileView() [������Ʈ ���丮 ���� �Է� ��û]");

		System.out.println("project_content : " + projectStoryInfo.toString());
		projectService.projectStoryInfo(projectStoryInfo);

		model.addAttribute("project_no", projectStoryInfo.getProject_no());
		int member_addressCount = addressService.get_memberAddress_count(projectStoryInfo.getMember_no());
		String member_profile = projectService.get_projectRegisterProfile(projectStoryInfo.getMember_no());
		if(member_profile != "NO PROFILE"){
			model.addAttribute("member_profile",member_profile);
		}
		if(member_addressCount == 0){
			model.addAttribute("addressInfo","noMemberAddress");
		}else {
			//ȸ�� �⺻ �����
			model.addAttribute("addressInfo", addressService.get_laterMemberAddress(projectStoryInfo.getMember_no()));
		}
		System.out.println("ProjectRegisterViewController \tprojectProfileView() [������Ʈ ����� ������ ���� �Է� ȭ�� ��û]");

		return "project/register/projectProfileView";
		// return "redirect:project/register/projectProfileView";
	}
	

	// ������Ʈ ���� �����Է� ȭ�� ��û
	@RequestMapping(value = "/projectAccountView")
	public String projectAccountView(@RequestParam int project_no, Model model) {
		System.out.println("ProjectRegisterViewController \tprojectAccountView() [������Ʈ ���� ���� �Է� ȭ�� ��û]");
		System.out.println("������Ʈ ��ȣ : " + project_no);
		model.addAttribute("project_no", project_no);
		return "project/register/projectAccountView";
	}
	
	//������Ʈ �̸����� ȭ�� ��û
	@RequestMapping(value = "/projectPreView")
	public String projectPreView(Model model, @RequestParam int project_no) {
		System.out.println("ProjectRegisterViewController \tprojectInfoView() [������Ʈ �̸����� ȭ�� ��û] : " + project_no);
		try {
			model.addAttribute("project_no",project_no);
			ProjectVO projectVO = projectService.projectPreview(project_no);
			model.addAttribute("project", projectVO);
			model.addAttribute("rewards", rewardService.rewardList(project_no));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(service.projectPreview(project_no).toString());
		return "project/projectInfoView";
	}
	
	//������Ʈ ��ȸ ȭ��
	@RequestMapping(value = "/projectInfoView")
	public String projectInfoView(Model model, @RequestParam int project_no) {
		System.out.println("ProjectRegisterViewController \tprojectInfoView() [������Ʈ ��ȸ ȭ�� ��û] : " + project_no);
		try {
			model.addAttribute("project_no",project_no);
			ProjectVO projectVO = projectService.projectInfoView(project_no);
			model.addAttribute("project", projectVO);
			model.addAttribute("rewards", rewardService.rewardList(project_no));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(service.projectPreview(project_no).toString());
		return "project/projectInfoView";
	}

	// ���� ���� ���ε�
	@RequestMapping("/photoUpload")
	public String photoUpload(HttpServletRequest request, PhotoVo vo) {
		String callback = vo.getCallback();
		String callback_func = vo.getCallback_func();
		String file_result = "";
		try {
			if (vo.getFiledata() != null && vo.getFiledata().getOriginalFilename() != null
					&& !vo.getFiledata().getOriginalFilename().equals("")) {
				// ������ �����ϸ�
				String original_name = vo.getFiledata().getOriginalFilename();
				String ext = original_name.substring(original_name.lastIndexOf(".") + 1);
				// ���� �⺻���
				String defaultPath = request.getSession().getServletContext().getRealPath("/resources/project/story");
				// ���� �⺻��� _ �󼼰��
				String path = defaultPath + File.separator;
				File file = new File(path);
				System.out.println("path:" + path);
				// ���丮 �������� ������� ���丮 ����
				if (!file.exists()) {
					file.mkdirs();
				}
				// ������ ���ε� �� ���ϸ�(�ѱ۹����� ���� ���������� �ø��� �ʴ°��� ����)
				String realname = UUID.randomUUID().toString() + "." + ext;
				///////////////// ������ ���Ͼ��� /////////////////
				vo.getFiledata().transferTo(new File(path + realname));
				file_result += "&bNewLine=true&sFileName=" + original_name + "&sFileURL=/dream/resources/project/story/"
						+ realname;
			} else {
				file_result += "&errstr=error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + callback + "?callback_func=" + callback_func + file_result;
	}

	// ���� ���� ���ε�
	@RequestMapping("/multiplePhotoUpload")

	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response) {
		try {
			// Cys file
			System.out.println("Cys File data print area --------------------------");

			System.out.println("End of Cys File data print area --------------------------");
			// END Cys file

			// ��������
			String sFileInfo = "";
			// ���ϸ��� �޴´� - �Ϲ� �������ϸ�
			String filename = request.getHeader("file-name");
			System.out.println("filename(�������ϸ�) : " + filename);
			// ���� Ȯ����
			String filename_ext = filename.substring(filename.lastIndexOf(".") + 1);
			// Ȯ���ڸ��ҹ��ڷ� ����
			filename_ext = filename_ext.toLowerCase();

			// ���� �⺻���(������)
			String dftFilePath = request.getSession().getServletContext().getRealPath("/resources/project/story");
			String filePath = dftFilePath + File.separator;

			// ���� �⺻ ��� ����(���� ����)
			// String dftFilePath = request.getSession().getServletContext().getRealPath("/");
			// String filePath = dftFilePath+"resources"+File.separator+"smarteditor"+File.separator+"multiupload"+File.separator;
			System.out.println("dftFilePath : " + dftFilePath);
			// ���� �⺻��� _ �󼼰��
			System.out.println("filePath (���� ���� ������) : " + filePath);
			File file = new File(filePath);

			if (!file.exists()) {
				file.mkdirs();
			}

			String realFileNm = "";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String today = formatter.format(new java.util.Date());
			realFileNm = today + UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
			String rlFileNm = filePath + realFileNm;
			File newFile = new File(rlFileNm);
			System.out.println("rlFileNm (���� ���ϰ�� + ���� ���ϸ�) : " + rlFileNm);

			///////////////// ������ ���Ͼ��� /////////////////

			// form�±׿��� ���۵� multi-part data(file data) Stream����
			InputStream is = request.getInputStream();
			System.out.println("is.available ��Ʈ������ �о�ü� �ִ� ������ ũ�� :" + is.available());
			System.out.println("is.read() ũ�Ⱑ 0�̾ƴϸ� -1�� ��ȯ�Ǵ°� :" + is.read());
			// BufferedImage

			OutputStream os = new FileOutputStream(rlFileNm);

			// request.getHeader("file-size").getBytes();

			int numRead = 0;
			byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
			// b = request.getHeader("file-size").getBytes();
			System.out.println("request.getHeader : " + request.getHeader("file-size"));
			while ((numRead = is.read(b, 0, b.length)) != -1) {
				os.write(b, 0, numRead);
			}

			if (is != null) {
				is.close();
			}
			os.flush();
			os.close();
			///////////////// ������ ���Ͼ��� /////////////////

			// ���� ���
			sFileInfo += "&bNewLine=true";
			System.out.println("sFileInfo 1 : " + sFileInfo);
			// img �±��� title �Ӽ��� �������ϸ����� ��������ֱ� ����
			sFileInfo += "&sFileName=" + filename;
			System.out.println("sFileInfo 2 : " + sFileInfo);

			sFileInfo += "&sFileURL=" + "/dream/resources/project/story/" + realFileNm;
			// sFileInfo += "&sFileURL=" + "/resources/smarteditor/multiupload/" + realFileNm;
			System.out.println("sFileInfo 3 : " + sFileInfo);

			PrintWriter print = response.getWriter();
			print.print(sFileInfo);
			print.flush();
			print.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
