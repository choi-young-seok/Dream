package kr.co.dream.upload.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils2 {


	// public static String uploadFile(String uploadPath,
	// String originalName,
	// byte[] fileData)throws Exception{
	//
	// return null;
	// }
	//

	public static String uploadFile(String uploadPath, String[] makeDirPaths, String originalName, byte[] fileData)
			throws Exception {
		System.err.println("UploadFileUtils \tuploadFile() \t\t[input value List]");
		System.out.println(
				"\t\t\t▶요청 : uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes())    --------------------------------");
		System.out.println("\t\t\t파일 저장 서버 경로 : " + uploadPath);
		System.out.println("\t\t\t원본 파일 이름 : " + originalName);
		UUID uid = UUID.randomUUID();
		// UUID클래스의 randomUUID()를 통해 유일한 값생성

		String savedName = uid.toString() + "_" + originalName;
		// 실제 파일명에 생성된 랜덤값을 이어붙여 저장파일명 생성

		String savedPath = makePath(uploadPath, makeDirPaths);
		// calcPath(uploadPath)
		// 업로드 경로에 날짜계산을 통해 파일이 업로드된 날짜를 계산 후 저장경로 생성
		// savePath에는 오늘 날짜가 저장됨
		// 최종 return data : savedPath = 2017/01/23
		System.out.println("\t\t\t날짜 정보 폴더 : " + savedPath);

		File target = new File(uploadPath + savedPath, savedName);
		System.out.println("uploadPath : " + uploadPath);
		System.out.println("savedPath : " + savedPath);
		System.out.println("savedName : " + savedName);
		// uploadPath + savedPath : 저장경로+날짜정보로 폴더명 생성
		// 설정된 해당 폴더경로에 고유값(UUID.randomUUID())이 붙은 실제 파일명을 저장

		FileCopyUtils.copy(fileData, target);
		//http://guysheep.tistory.com/entry/Java-%ED%8C%8C%EC%9D%BC-%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C-%EC%8B%9C-IO%EC%99%80-New-IO
		// fileData : drag and drop으로 첨부된 파일데이터
		// target : 저장경로 + 날짜정보로 생성된 폴더에 고유값이 붙은 실제 파일객체
		// OutputStream outStream = new BufferedOutputStream(new FileOutputStream(out));
		// 이 부분이 실제로 서버에 이미지 byte[]이 저장되는 코드?
		System.out.println("FileCopyUtils.copy(fileData, target)  -- after --");

		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		// originalName : 실페 파일 이름
		// originalName.substring(originalName.lastIndexOf(".")+1) : 확장자 추출
		System.out.println("\t\t\t확장자 추출 : " + formatName);

		String uploadedFileName = null;

		if (MediaUtils.getMediaType(formatName) != null) {
			// 확장자가 JPG/GIF/PNG이면
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
			System.out.println("\t\t\t생성된 썸네일 이미지명 : " + uploadedFileName);
		} else {
			// 확장자가 JPG/GIF/PNG가 아니면
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
			System.out.println("\t\t\t생성된 파일명 : " + uploadedFileName);
		}
		System.out.println("-------------------------------------------------------");
		return uploadedFileName;

	}

	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception {

		String iconName = uploadPath + path + File.separator + fileName;

		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {

		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		// BufferedImage : 이미지 데이터를 저장하는 스트림 (이미지 데이터 객체화(로딩))
		// uploadPath+path : 서버경로 + 날짜정보 폴더경로
		// fileName : 해당경로에 위치한 파일명(UUID.randomUUID())
		// new File(uploadPath+path , fileName) :서버경로+날짜정보 폴더경로의 파일명을 가진 파일을 객체화
		// ImageIO.read(new File(uploadPath+path , fileName)) : 해당 파일 객체를 읽어 BufferedImage로 반환(리턴)
		// BufferedImage sourceImg = 해당 경로에 위치한 이미지파일 데이터를 저장한 이미지객체

		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 300);
		// 저장한 이미지 파일(sourceImg)을 읽어서 resize 실행 (썸네일생성)
		// BufferdImage 를 이용해서 이미지를 메모리상에 올려놓는다.

		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		// File.separator : 구분자 생성 (/)
		// 썸네일 이미지의 파일명 생성
		System.out.println("thumbnailName :" + thumbnailName);

		File newFile = new File(thumbnailName);
		// File class Constructor
		// File(String directory) : directory(파일경로)에 위치한 파일 객체 생성
		// File(String directory , String fileName) : directory(파일경로)에 위치한 fileName(파일명)의 파일 객체 생성
		// File(File obj , String fileName) : obj(파일객체)를 fileName(파일명)으로 파일 객체 생성

		// File newFile = new File(thumbnailName); : 썸네일 이미지 파일명으로 파일 객체 생성

		// ImageIO.read / ImageIO.write는 파일 객체를 파라미터로 하여 해당 파일 객체를 읽고 쓰는 객체
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		// fileName.substring(fileName.lastIndexOf(".")+1 : 원본파일의 확장자 추출

		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		// destImg : 썸네일 이미지 스트림(객체)
		// formateName.toUpperCase() : 원본파일의 확장자를 대문자로 변환
		// newFile = 썸네일 이미지 파일명으로 생성한 파일 객체
		// ImageIO.write(destImg, formatName.toUpperCase(), new file);
		// : 썸네일 이미지(destImg)를 추출하여 대문자로 변환한 확장자명(formatName.toUpperCase())와 결합하여 썸네일 파일명을 가진 파일(newFile) 생성

		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
		// 생성한 썸네일 파일명 리턴(반환)
	}

	private static String makePath(String uploadPath, String[] makeDirPaths) {

		String uploadFilePath = File.separator + makeDirPaths[0];
		// ex) uploadFilePath = uploadFile
		
		String uploadMemberPath = uploadFilePath + File.separator + makeDirPaths[1];
		// ex) uploadFilePath = uploadFile/test@naver.com
		
		String requestPath = uploadMemberPath + File.separator + makeDirPaths[2];
		// ex) uploadFilePath = uploadFile/test@naver.com/member_profile
		// ex) uploadFilePath = uploadFile/test@naver.com/project_thumbnail
		// ex) uploadFilePath = uploadFile/test@naver.com/project_video

		Calendar cal = Calendar.getInstance();

		String yearPath = requestPath + File.separator + cal.get(Calendar.YEAR);
		// ex) yearPath = /2017

		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		// ex) monthPath = /2017/06

		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		// ex) datePath = /2017/06/02

		makeDir(uploadPath, uploadFilePath, uploadMemberPath, requestPath, yearPath, monthPath, datePath);

		return datePath;
		// ex)datePath = uploadFile/test@naver.com/member_profile//2017/06/02
	}

	private static void makeDir(String uploadPath, String... datePaths) {
		// 생성위치(uploadPath)에 하위 폴더 경로 목록(String... paths)을 인자로 취함

		if (new File(datePaths[datePaths.length - 1]).exists()) {
			return;
		}
		// 해당 경로의 가장 끝경로(일 정보를 가진폴더)가 존재할경우 폴더생성 하지 않음 (중복으로 간주)

		for (String path : datePaths) {

			File dirPath = new File(uploadPath + path);

			if (!dirPath.exists()) {
				// 존재하지 않으면 폴더 생성(폴더가 중복되지 않는경우 폴더 생성)
				dirPath.mkdir();
			}
		}
	}
}
