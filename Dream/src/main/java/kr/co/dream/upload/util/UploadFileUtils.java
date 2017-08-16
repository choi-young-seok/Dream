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
				"\t\t\t����û : uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes())    --------------------------------");
		System.out.println("\t\t\t���� ���� ���� ��� : " + uploadPath);
		System.out.println("\t\t\t���� ���� �̸� : " + originalName);
		UUID uid = UUID.randomUUID();
		// UUIDŬ������ randomUUID()�� ���� ������ ������

		String savedName = uid.toString() + "_" + originalName;
		// ���� ���ϸ� ������ �������� �̾�ٿ� �������ϸ� ����

		String savedPath = calcPath(uploadPath, makeDirPaths);
		// calcPath(uploadPath)
		// ���ε� ��ο� ��¥����� ���� ������ ���ε�� ��¥�� ��� �� ������ ����
		// savePath���� ���� ��¥�� �����
		// ���� return data : savedPath = 2017/01/23
		System.out.println("\t\t\t��¥ ���� ���� : " + savedPath);

		File target = new File(uploadPath + savedPath, savedName);
		System.out.println("uploadPath : " + uploadPath);
		System.out.println("savedPath : " + savedPath);
		System.out.println("savedName : " + savedName);
		// uploadPath + savedPath : ������+��¥������ ������ ����
		// ������ �ش� ������ο� ������(UUID.randomUUID())�� ���� ���� ���ϸ��� ����

		FileCopyUtils.copy(fileData, target);
		// fileData : drag and drop���� ÷�ε� ���ϵ�����
		// target : ������ + ��¥������ ������ ������ �������� ���� ���� ���ϰ�ü
		// OutputStream outStream = new BufferedOutputStream(new FileOutputStream(out));
		// �� �κ��� ������ ������ �̹��� byte[]�� ����Ǵ� �ڵ�?
		System.out.println("FileCopyUtils.copy(fileData, target)  -- after --");

		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		// originalName : ���� ���� �̸�
		// originalName.substring(originalName.lastIndexOf(".")+1) : Ȯ���� ����
		System.out.println("\t\t\tȮ���� ���� : " + formatName);

		String uploadedFileName = null;

		if (MediaUtils.getMediaType(formatName) != null) {
			// Ȯ���ڰ� JPG/GIF/PNG�̸�
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
			System.out.println("\t\t\t������ ����� �̹����� : " + uploadedFileName);
		} else {
			// Ȯ���ڰ� JPG/GIF/PNG�� �ƴϸ�
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
			System.out.println("\t\t\t������ ���ϸ� : " + uploadedFileName);
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
		// BufferedImage : �̹��� �����͸� �����ϴ� ��Ʈ�� (�̹��� ������ ��üȭ(�ε�))
		// uploadPath+path : ������� + ��¥���� �������
		// fileName : �ش��ο� ��ġ�� ���ϸ�(UUID.randomUUID())
		// new File(uploadPath+path , fileName) :�������+��¥���� ��������� ���ϸ��� ���� ������ ��üȭ
		// ImageIO.read(new File(uploadPath+path , fileName)) : �ش� ���� ��ü�� �о� BufferedImage�� ��ȯ(����)
		// BufferedImage sourceImg = �ش� ��ο� ��ġ�� �̹������� �����͸� ������ �̹�����ü

		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 300);
		// ������ �̹��� ����(sourceImg)�� �о resize ���� (����ϻ���)
		// BufferdImage �� �̿��ؼ� �̹����� �޸𸮻� �÷����´�.

		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		// File.separator : ������ ���� (/)
		// ����� �̹����� ���ϸ� ����
		System.out.println("thumbnailName :" + thumbnailName);

		File newFile = new File(thumbnailName);
		// File class Constructor
		// File(String directory) : directory(���ϰ��)�� ��ġ�� ���� ��ü ����
		// File(String directory , String fileName) : directory(���ϰ��)�� ��ġ�� fileName(���ϸ�)�� ���� ��ü ����
		// File(File obj , String fileName) : obj(���ϰ�ü)�� fileName(���ϸ�)���� ���� ��ü ����

		// File newFile = new File(thumbnailName); : ����� �̹��� ���ϸ����� ���� ��ü ����

		// ImageIO.read / ImageIO.write�� ���� ��ü�� �Ķ���ͷ� �Ͽ� �ش� ���� ��ü�� �а� ���� ��ü
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		// fileName.substring(fileName.lastIndexOf(".")+1 : ���������� Ȯ���� ����

		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		// destImg : ����� �̹��� ��Ʈ��(��ü)
		// formateName.toUpperCase() : ���������� Ȯ���ڸ� �빮�ڷ� ��ȯ
		// newFile = ����� �̹��� ���ϸ����� ������ ���� ��ü
		// ImageIO.write(destImg, formatName.toUpperCase(), new file);
		// : ����� �̹���(destImg)�� �����Ͽ� �빮�ڷ� ��ȯ�� Ȯ���ڸ�(formatName.toUpperCase())�� �����Ͽ� ����� ���ϸ��� ���� ����(newFile) ����

		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
		// ������ ����� ���ϸ� ����(��ȯ)
	}

	private static String calcPath(String uploadPath, String[] makeDirPaths) {

		String uploadFilePath = File.separator + makeDirPaths[0];
		String uploadMemberPath = uploadFilePath + File.separator + makeDirPaths[1];
		String requestPath = uploadMemberPath + File.separator + makeDirPaths[2];

		Calendar cal = Calendar.getInstance();

		String yearPath = requestPath + File.separator + cal.get(Calendar.YEAR);
		// File.separator = os���� �ٸ� ���ϰ�ΰ��� �����ڸ� �ذ��ϱ� ���� java File class�� separator(������)�޼ҵ�
		// window�� ��� testFolder ���� �ؿ� test.txt�� �����Ұ�� ��θ��� : testFolder\\test.txt
		// linux�� ��� testFolder ���� �ؿ� test.txt�� �����Ұ�� ��θ��� : testFolder/test.txt

		// separator �޼ҵ尡 ���̴� ������ File class�� separator�޼ҵ带 ��������ν�
		// os���� �ٸ� ���ϱ�����(\\,/)�� �Ű澲�� �ʾƵ� �Ǳ� ����
		// ���� String yearPah���� ���� �����ϴ� OS�� ������ + ���� ���������� ����
		// ex) String yearPath = /2017

		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		// �ڹ� DecimalFormat class : 10������ ���� ���ϴ� �������� �������ִ� Ŭ����
		// new DecimalFormat("00") : DecimalFormat Ŭ������ �����ϸ� ��ȯ�� �ּ� �ڸ���(2�ڸ� : ("00"))�� ���
		// .format(cal.get(Calendar.MONTH)+1); : �ּ� 2�ڸ� �̻��� ����ؾߵ� ��
		// yearPath + File.separator : �����ڸ� ������ ���� ���������� �����ڸ� ���� ("/2017/")
		// ���� String monthPath���� ������ : /2017/01~12 �� ���� ������ �ɰ�
		// ex)String monthPath = /2017/06

		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		// monthPath + File.separator : �����ڸ� ������ ���� ���������� �������� �����ڸ� ����("/2017/06/")
		// ���� String datePath���� ������ : /2017/06/01~31 �� ���� ������ �ɰ�
		// ex)String datePath = /2017/06/02

		// makeDir(uploadPath, yearPath, monthPath, datePath, uploadFilePath, uploadMemberPath, requestPath);
		makeDir(uploadPath, uploadFilePath, uploadMemberPath, requestPath, yearPath, monthPath, datePath);
		// �������� :ù��°���� = ������ġ(uploadPath : �������)
		// �ι�°���� : yearPath�ؿ�,montPath,�ؿ� datePath���� ��������
		// ���� �����Ȱ��� : ������Ʈ ������� �ؿ�/2017/01/01

		return datePath;
		// ex)String datePath = /2017/06/02�� ��ȯ
	}

	private static void makeDir(String uploadPath, String... datePaths) {
		// ������ġ(uploadPath)�� ���� ���� ��� ���(String... paths)�� ���ڷ� ����

		if (new File(datePaths[datePaths.length - 1]).exists()) {
			return;
		}
		// �ش� ����� ���� �����(�� ������ ��������)�� �����Ұ�� �������� ���� ���� (�ߺ����� ����)

		for (String path : datePaths) {

			File dirPath = new File(uploadPath + path);

			if (!dirPath.exists()) {
				// �������� ������ ���� ����(������ �ߺ����� �ʴ°�� ���� ����)
				dirPath.mkdir();
			}
		}
	}
}
