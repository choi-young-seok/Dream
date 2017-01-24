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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.dream.project.domain.PhotoVo;
import kr.co.dream.project.service.ProjectService;

@Controller
public class ProjectViewController {

	@Inject
	private ProjectService service;

	@RequestMapping(value = "projectInfoView")
	public String projectInfoView(Model model) {
		// model.addAttribute("project", service.testSelectOne());
		return "project/projectInfoView";
	}

	@RequestMapping(value = "/projectStoryView")
	public String projectStoryView() {
		System.out.println("??");
		return "project/register/projectStoryView";
	}

	// �������Ͼ��ε�
	@RequestMapping("/multiplePhotoUpload")

	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response) {
		try {
			//Cys file
			System.out.println("Cys File data print area --------------------------");
			
			System.out.println("End of Cys File data print area --------------------------");
			//END Cys file
			
			// ��������
			String sFileInfo = "";
			// ���ϸ��� �޴´� - �Ϲ� �������ϸ�
			String filename = request.getHeader("file-name");
			System.out.println("filename(�������ϸ�) : "+filename);
			// ���� Ȯ����
			String filename_ext = filename.substring(filename.lastIndexOf(".") + 1);
			// Ȯ���ڸ��ҹ��ڷ� ����
			filename_ext = filename_ext.toLowerCase();
			
			// ���� �⺻���(������)
			String dftFilePath = request.getSession().getServletContext().getRealPath("/resources/project/story");
			String filePath = dftFilePath +File.separator;
			
			// ���� �⺻ ��� ����(���� ����)
//			String dftFilePath = request.getSession().getServletContext().getRealPath("/");
//			String filePath = dftFilePath+"resources"+File.separator+"smarteditor"+File.separator+"multiupload"+File.separator;
			System.out.println("dftFilePath : " +dftFilePath);
			// ���� �⺻��� _ �󼼰��
			System.out.println("filePath (���� ���� ������) : " +filePath);
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
			
			
			
			//form�±׿��� ���۵� multi-part data(file data) Stream����
			InputStream is = request.getInputStream();
			System.out.println("is.available ��Ʈ������ �о�ü� �ִ� ������ ũ�� :"  +is.available());
			System.out.println("is.read() ũ�Ⱑ 0�̾ƴϸ� -1�� ��ȯ�Ǵ°� :"  +is.read());
//			BufferedImage
			
			OutputStream os = new FileOutputStream(rlFileNm);
		
//			request.getHeader("file-size").getBytes();
			
			int numRead=0;
			byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
//			b = request.getHeader("file-size").getBytes();
			System.out.println("request.getHeader : "+request.getHeader("file-size"));
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
			System.out.println("sFileInfo 1 : " +sFileInfo);
			// img �±��� title �Ӽ��� �������ϸ����� ��������ֱ� ����
			sFileInfo += "&sFileName=" + filename;
			System.out.println("sFileInfo 2 : " +sFileInfo);
			
			//����
			sFileInfo += "&sFileURL=" + "/dream/resources/project/story/" + realFileNm;
			//��������
//			sFileInfo += "&sFileURL=" + "/resources/smarteditor/multiupload/" + realFileNm;
			System.out.println("sFileInfo 3 : " +sFileInfo);
			
			PrintWriter print = response.getWriter();
			print.print(sFileInfo);
			print.flush();
			print.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/projectStory")
	public String projectStory() {
		System.out.println("projectStory");
		return null;
	}

	@RequestMapping(value = "/projectStoryRegit")
	public String projectStoryRegit(String editor) throws IOException {
		System.out.println("projectStoryRegit");
		System.out.println("editor : " + editor);
		return null;
	}
	
	
	@RequestMapping("/photoUpload")
	public String photoUpload(HttpServletRequest request, PhotoVo vo){
	    String callback = vo.getCallback();
	    String callback_func = vo.getCallback_func();
	    String file_result = "";
	    try {
	        if(vo.getFiledata() != null && vo.getFiledata().getOriginalFilename() != null && !vo.getFiledata().getOriginalFilename().equals("")){
	            //������ �����ϸ�
	            String original_name = vo.getFiledata().getOriginalFilename();
	            String ext = original_name.substring(original_name.lastIndexOf(".")+1);
	            //���� �⺻���
	            String defaultPath = request.getSession().getServletContext().getRealPath("/resources/project/story");
	            //���� �⺻��� _ �󼼰��
	            String path = defaultPath + File.separator;             
	            File file = new File(path);
	            System.out.println("path:"+path);
	            //���丮 �������� ������� ���丮 ����
	            if(!file.exists()) {
	                file.mkdirs();
	            }
	            //������ ���ε� �� ���ϸ�(�ѱ۹����� ���� ���������� �ø��� �ʴ°��� ����)
	            String realname = UUID.randomUUID().toString() + "." + ext;
	        ///////////////// ������ ���Ͼ��� /////////////////
	            vo.getFiledata().transferTo(new File(path+realname));
	            file_result += "&bNewLine=true&sFileName="+original_name+"&sFileURL=/dream/resources/project/story/"+realname;
	        } else {
	            file_result += "&errstr=error";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "redirect:" + callback + "?callback_func="+callback_func+file_result;
	}
}
