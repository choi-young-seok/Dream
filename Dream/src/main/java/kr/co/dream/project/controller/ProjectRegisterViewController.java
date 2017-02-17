package kr.co.dream.project.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dream.project.domain.PhotoVo;
import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.service.ProjectService;

@Controller
public class ProjectRegisterViewController {

	@Inject
	private ProjectService service;

	// 프로젝트 기본 정보 입력 화면 요청
	@RequestMapping(value = "/projectRegiterView")
	public String projectRegiterView(Model model) {
		System.out.println("ProjectViewController \tprojectBasicInfoView() [프로젝트 기본 정보 입력 화면 요청]");
		return "project/register/projectBasicInfoView";
	}

	// 프로젝트 리워즈 입력 화면 요청
	@RequestMapping(value = "/projectRewardView")
	public String projectRewardView() {
		System.out.println("ProjectViewController \tprojectRewardView() [프로젝트 리워드 정보 입력 화면 요청]");

		return "project/register/projectRewardView";
	}

	// 프로젝트 스토리 정보 입력 화면 요청
	@RequestMapping(value = "/projectStoryView")
	public String projectStoryView() {
		System.out.println("ProjectViewController \tprojectStoryView() [프로젝트 스토리 정보 입력 화면 요청]");
		return "project/register/projectStoryView";
	}

	// 프로젝트 프로필 정보 입력 화면 요청
	@RequestMapping(value = "/projectProfileView", method = RequestMethod.POST)
	public String projectProfileView(ProjectVO projectStoryInfo, HttpServletRequest request) {
		System.out.println("ProjectViewController \tprojectProfileView() [프로젝트 등록자 프로필 정보 입력 화면 요청]");
		System.out.println("project_content : " + projectStoryInfo.toStringProjectStoryInfo());
		service.projectStoryInfo(projectStoryInfo);

		return "project/register/projectProfileView";
	}

	// 프로젝트 계좌 정보입력 화면 요청
	@RequestMapping(value = "/projectAccountView")
	public String projectAccountView() {
		System.out.println("ProjectViewController \tprojectAccountView() [프로젝트 계좌 정보 입력 화면 요청]");
		return "project/register/projectAccountView";
	}

	@RequestMapping(value = "/projectInfoView")
	public String projectAccountView(Model model, int project_no) {
		System.out.println("ProjectViewController \tprojectAccountView() [프로젝트 계좌 정보 입력 화면 요청] : " + project_no);
		model.addAttribute("project", service.projectPreview(project_no));
		System.out.println(service.projectPreview(project_no).toString());
		return "project/projectInfoView";
	}

	// 단일 파일 업로드
	@RequestMapping("/photoUpload")
	public String photoUpload(HttpServletRequest request, PhotoVo vo) {
		String callback = vo.getCallback();
		String callback_func = vo.getCallback_func();
		String file_result = "";
		try {
			if (vo.getFiledata() != null && vo.getFiledata().getOriginalFilename() != null
					&& !vo.getFiledata().getOriginalFilename().equals("")) {
				// 파일이 존재하면
				String original_name = vo.getFiledata().getOriginalFilename();
				String ext = original_name.substring(original_name.lastIndexOf(".") + 1);
				// 파일 기본경로
				String defaultPath = request.getSession().getServletContext().getRealPath("/resources/project/story");
				// 파일 기본경로 _ 상세경로
				String path = defaultPath + File.separator;
				File file = new File(path);
				System.out.println("path:" + path);
				// 디렉토리 존재하지 않을경우 디렉토리 생성
				if (!file.exists()) {
					file.mkdirs();
				}
				// 서버에 업로드 할 파일명(한글문제로 인해 원본파일은 올리지 않는것이 좋음)
				String realname = UUID.randomUUID().toString() + "." + ext;
				///////////////// 서버에 파일쓰기 /////////////////
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

	// 다중 파일 업로드
	@RequestMapping("/multiplePhotoUpload")

	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response) {
		try {
			// Cys file
			System.out.println("Cys File data print area --------------------------");

			System.out.println("End of Cys File data print area --------------------------");
			// END Cys file

			// 파일정보
			String sFileInfo = "";
			// 파일명을 받는다 - 일반 원본파일명
			String filename = request.getHeader("file-name");
			System.out.println("filename(원본파일명) : " + filename);
			// 파일 확장자
			String filename_ext = filename.substring(filename.lastIndexOf(".") + 1);
			// 확장자를소문자로 변경
			filename_ext = filename_ext.toLowerCase();

			// 파일 기본경로(내설정)
			String dftFilePath = request.getSession().getServletContext().getRealPath("/resources/project/story");
			String filePath = dftFilePath + File.separator;

			// 파일 기본 경로 설정(원래 설정)
			// String dftFilePath = request.getSession().getServletContext().getRealPath("/");
			// String filePath = dftFilePath+"resources"+File.separator+"smarteditor"+File.separator+"multiupload"+File.separator;
			System.out.println("dftFilePath : " + dftFilePath);
			// 파일 기본경로 _ 상세경로
			System.out.println("filePath (실제 서버 저장경로) : " + filePath);
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
			System.out.println("rlFileNm (저장 파일경로 + 저장 파일명) : " + rlFileNm);

			///////////////// 서버에 파일쓰기 /////////////////

			// form태그에서 전송된 multi-part data(file data) Stream생성
			InputStream is = request.getInputStream();
			System.out.println("is.available 스트림으로 읽어올수 있는 데이터 크기 :" + is.available());
			System.out.println("is.read() 크기가 0이아니면 -1이 반환되는가 :" + is.read());
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
			///////////////// 서버에 파일쓰기 /////////////////

			// 정보 출력
			sFileInfo += "&bNewLine=true";
			System.out.println("sFileInfo 1 : " + sFileInfo);
			// img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
			sFileInfo += "&sFileName=" + filename;
			System.out.println("sFileInfo 2 : " + sFileInfo);

			// 내꺼
			sFileInfo += "&sFileURL=" + "/dream/resources/project/story/" + realFileNm;
			// 원래설정
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
