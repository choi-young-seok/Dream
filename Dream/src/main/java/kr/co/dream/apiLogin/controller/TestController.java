package kr.co.dream.apiLogin.controller;

import java.io.File;


public class TestController {
	public static void main(String[] args) {
		System.out.println("파일생성 테스트");
		if(new File("testFolder").exists()){
			return;
		}else{
			String path = "E:\\Kosta Project_neon\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp9\\wtpwebapps\\Dream\\resources";
			System.out.println(path);
			String userName = File.separator + "kancho33@naver.com";
//			String path = "E:\\Kosta Project_neon\\.metadata\\.plugins\org.eclipse.wst.server.core\tmp9\wtpwebapps\Dream\resources";
			File dirpath = new File(path+userName);
			if(!dirpath.exists()){
				dirpath.mkdir();
				System.out.println("생성완료");
			}
		}
		
	}
}
