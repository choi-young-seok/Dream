package kr.co.dream.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionAuthIntercepter extends HandlerInterceptorAdapter {

	//����� ���ǰ˻� �� url�̵�
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.err.println("SessionAuthIntercepter \tpreHandle() \t\t[����� ���� �˻�]");
		if (request.getSession().getAttribute("session") == null) {
			System.out.println("SessionAuthIntercepter \tpreHandle() \t\t[��α��� �����]");
			request.getSession().setAttribute("needLoginSession","needLoginSession");
			System.out.println("SessionAuthIntercepter \tpreHandle() \t\t[�ӽü��� �߱�] : "+request.getSession().getAttribute("needLoginSession"));
			return true;
		}
		System.err.println("SessionAuthIntercepter \tpreHandle() \t\t[�α��� �����]");
		
		return true;
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HttpSession session = request.getSession();
		String sessionValue =(String) session.getAttribute("needLoginSession");

//		if(sessionValue.equals("needLoginSession")){
		if(sessionValue == "needLoginSession"){
			System.err.println("SessionAuthIntercepter \tafterCompletion() \t[�ӽ� �߱޼���  Ȯ��] : " + session.getAttribute("needLoginSession"));
			session.invalidate();
			System.out.println("SessionAuthIntercepter \tafterCompletion() \t[�α����� ���� �ӽ� ���� ����]");
		}else{
			System.err.println("SessionAuthIntercepter \tafterCompletion() \t[�ӽ� �߱޼��� ����]");
		}
	
		super.afterCompletion(request, response, handler, ex);
	}
	
	
}
