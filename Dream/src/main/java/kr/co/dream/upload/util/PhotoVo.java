package kr.co.dream.upload.util;

import org.springframework.web.multipart.MultipartFile;

public class PhotoVo {

	private MultipartFile Filedata;
    //callback URL
    private String callback;
    //�ݹ��Լ�
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
