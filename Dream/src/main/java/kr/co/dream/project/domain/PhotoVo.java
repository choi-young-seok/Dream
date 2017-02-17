package kr.co.dream.project.domain;

import org.springframework.web.multipart.MultipartFile;

public class PhotoVo {

	private MultipartFile Filedata;
    //callback URL
    private String callback;
    //콜백함수
    private String callback_func;
    
	public MultipartFile getFiledata() {
		return Filedata;
	}
	public void setFiledata(MultipartFile filedata) {
		Filedata = filedata;
	}
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	public String getCallback_func() {
		return callback_func;
	}
	public void setCallback_func(String callback_func) {
		this.callback_func = callback_func;
	}

}
