package kr.co.dream.upload.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);

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

		String savedPath = calcPath(uploadPath, makeDirPaths);
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

	private static String calcPath(String uploadPath, String[] makeDirPaths) {

		String uploadFilePath = File.separator + makeDirPaths[0];
		String uploadMemberPath = uploadFilePath + File.separator + makeDirPaths[1];
		String requestPath = uploadMemberPath + File.separator + makeDirPaths[2];

		Calendar cal = Calendar.getInstance();

		String yearPath = requestPath + File.separator + cal.get(Calendar.YEAR);
		// File.separator = os마다 다른 파일경로간의 구분자를 해결하기 위한 java File class의 separator(구분자)메소드
		// window의 경우 testFolder 폴더 밑에 test.txt가 존재할경우 경로명은 : testFolder\\test.txt
		// linux의 경우 testFolder 폴더 밑에 test.txt가 존재할경우 경로명은 : testFolder/test.txt

		// separator 메소드가 쓰이는 이유는 File class의 separator메소드를 사용함으로써
		// os마다 다른 파일구분자(\\,/)를 신경쓰지 않아도 되기 때문
		// 따라서 String yearPah에는 현재 실행하는 OS의 구분자 + 오늘 연도정보가 저장
		// ex) String yearPath = /2017

		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		// 자바 DecimalFormat class : 10진수의 값을 원하는 포맷으로 변경해주는 클래스
		// new DecimalFormat("00") : DecimalFormat 클래스를 생성하며 반환할 최소 자리수(2자리 : ("00"))를 명시
		// .format(cal.get(Calendar.MONTH)+1); : 최소 2자리 이상을 명시해야될 값
		// yearPath + File.separator : 구분자를 포함한 현재 연도정보에 구분자를 포함 ("/2017/")
		// 따라서 String monthPath에는 최종값 : /2017/01~12 의 값을 가지게 될것
		// ex)String monthPath = /2017/06

		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		// monthPath + File.separator : 구분자를 포함한 현재 연도정보와 월정보에 구분자를 포함("/2017/06/")
		// 따라서 String datePath에는 최종값 : /2017/06/01~31 의 값을 가지게 될것
		// ex)String datePath = /2017/06/02

		// makeDir(uploadPath, yearPath, monthPath, datePath, uploadFilePath, uploadMemberPath, requestPath);
		makeDir(uploadPath, uploadFilePath, uploadMemberPath, requestPath, yearPath, monthPath, datePath);
		// 폴더생성 :첫번째인자 = 생성위치(uploadPath : 서버경로)
		// 두번째인자 : yearPath밑에,montPath,밑에 datePath까지 폴더생성
		// 실제 생성된값은 : 프로젝트 서버경로 밑에/2017/01/01

		return datePath;
		// ex)String datePath = /2017/06/02를 반환
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
