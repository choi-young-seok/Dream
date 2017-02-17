package kr.co.dream.upload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import kr.co.dream.member.service.MemberService;
import kr.co.dream.upload.service.uploadService;
import kr.co.dream.upload.util.MediaUtils;
import kr.co.dream.upload.util.UploadFileUtils;

@Controller
public class UploadController {

	@Inject
	private MemberService service;
	
	@Inject 
	private uploadService uploadService;

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

//	@Resource(name = "uploadPath")
//	private String uploadPath;

//	@RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
//	public void uploadForm() {
//
//	}

//	@RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
//	public String uploadForm(MultipartFile file, Model model) throws Exception {
//
//		// Drag & Drop 파일 정보 출력
//		logger.info("originalName: " + file.getOriginalFilename());
//		logger.info("size: " + file.getSize());
//		logger.info("contentType: " + file.getContentType());
//
//		// db파일이름
//		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
//
//		System.out.println("Controller UploadForm SaceName : " + savedName);
//
//		model.addAttribute("savedName", savedName);
//
//		return "uploadResult";
//	}

//	@RequestMapping(value = "/uploadAjax", method = RequestMethod.GET)
//	public void uploadAjax() {
//	}
//
//	private String uploadFile(String originalName, byte[] fileData) throws Exception {
//		System.out.println("업로드파일");
//		UUID uid = UUID.randomUUID();
//
//		// 파일이름 중복 방지
//		String savedName = uid.toString() + "_" + originalName;
//		// 중복방지처리 파일 이름
//		System.out.println("Controller UploadForm SaceName : " + savedName);
//
//		//파일 저장
//		File target = new File(uploadPath, savedName);
//
//		//썸네일 이미지 생성
//		FileCopyUtils.copy(fileData, target);
//
//		return savedName;
//	}

	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file, HttpServletRequest request) throws Exception {
		
		System.err.println("UploadController \tuploadAjax() \t\t[input value List]");
		//뷰에서 전송된 formData객체 내의 파일데이터를 수신하기 위한 데이터타입 : MultipartFile
		System.out.println("\t\t▶요청 : uploadAjax    --------------------------------");
		System.out.println("\t\t원본 파일 이름 : " + file.getOriginalFilename());
		//파일이 저장되는 실제경로 
		//E:\Kosta Project_neon\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\SpringBoard\resources\img\thumnail
		String uploadPath = request.getSession().getServletContext().getRealPath("resources/member/thumbnail");
		System.out.println("\t\t파일 저장 경로 : " +request.getSession().getServletContext().getRealPath("resources/member/thumbnail"));
		//request객체로 부터 파일이 저장되는 경로 추출
		//request.getSession().getServletContext().getRealPath("") = E:\Kosta Project_neon\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\SpringBoard(Project명)
		//request.getSession().getServletContext().getRealPath("상세 폴더명")
		System.out.println("\t\t파일 크기 : " + file.getSize());
		System.out.println("\t\t파일 형식 : " + file.getContentType());
		//이걸로 확장자 검사 가능할듯
		System.out.println("-------------------------------------------------------");

		return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
		//UpLoadFileUtils.uploadFile(uploadPath,file.getOriginalFilename(), file.getBytes()) : 분석해서 주석달것
		//uploadFile()에 전달되는 인자 uploadPath : 저장경로, file.getOriginalFilename() : 실제 파일명, 파일데이터
		//
		//HttpStatus.CREATED : 201 : Created (수정으로 인해서 새로운 리소스가 생성되었을 때)
	}

	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName, HttpServletRequest request) throws Exception {

		System.err.println("UploadController \tdisplayFile()]");
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		System.out.println("Controller displayFile() 파일이름 : " + fileName);

		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);
			// 파일 확장자 추출 후 이미지일 경우 MIME타입 지정

			HttpHeaders headers = new HttpHeaders();
			String uploadPath = request.getSession().getServletContext().getRealPath("resources/member/thumbnail");
			in = new FileInputStream(uploadPath + fileName);
			System.out.println("uploadPath + fileName : " +uploadPath+fileName);
			if (mType != null) {
				headers.setContentType(mType);
			} else {

				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				// 이미지가 아닌경우 다운로드 타입 지정
				headers.add("Content-Disposition",
						"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
				// 다운로드 파일 이름 한글 처리
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	@ResponseBody
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName, HttpServletRequest request) {

		logger.info("delete file: " + fileName);

		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		MediaType mType = MediaUtils.getMediaType(formatName);
		String uploadPath = request.getSession().getServletContext().getRealPath("resources/member/thumbnail");

		if (mType != null) {

			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
		}

		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/deleteAllFiles", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(@RequestParam("files[]") String[] files, HttpServletRequest request) {

		logger.info("delete all files: " + files);

		if (files == null || files.length == 0) {
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		}

		for (String fileName : files) {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);
			String uploadPath = request.getSession().getServletContext().getRealPath("resources/member/thumbnail");
			if (mType != null) {

				String front = fileName.substring(0, 12);
				String end = fileName.substring(14);
				new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
			}

			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/savedImage")
	public void savedImage(String fileName){
		System.out.println("fileName : " +fileName);
	}

//	@RequestMapping("/getAttach/{bno}")
//	@ResponseBody
//	public List<String> getAttach(@PathVariable("bno") int bno) throws Exception {
//		System.out.println("Controller : " + service.getAttach(bno));
//		return service.getAttach(bno);
//	}

}