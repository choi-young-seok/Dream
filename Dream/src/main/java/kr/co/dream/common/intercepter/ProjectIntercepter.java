package kr.co.dream.common.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ProjectIntercepter extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1�ܰ� ��� �Ϸ���?
		//���⼭ 2~4�ܰ迡 �ش��ϴ� ������Ʈ ��� ���� �˻� �� �ӽ� ����(������Ʈ ��ȣ)�ο�
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//���Ǹ���?]
		super.postHandle(request, response, handler, modelAndView);
	}
	

}
