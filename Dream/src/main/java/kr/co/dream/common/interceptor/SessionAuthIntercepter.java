package kr.co.dream.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionAuthIntercepter extends HandlerInterceptorAdapter {

	//사용자 세션검사 및 url이동
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.err.println("SessionAuthIntercepter \tpreHandle() \t\t[사용자 세션 검사]");
		if (request.getSession().getAttribute("session") == null) {
			System.out.println("SessionAuthIntercepter \tpreHandle() \t\t[비로그인 사용자]");
			request.getSession().setAttribute("needLoginSession","needLoginSession");
			System.out.println("SessionAuthIntercepter \tpreHandle() \t\t[임시세션 발급] : "+request.getSession().getAttribute("needLoginSession"));
			return true;
		}
		System.err.println("SessionAuthIntercepter \tpreHandle() \t\t[로그인 사용자]");
		
		return true;
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HttpSession session = request.getSession();
		String sessionValue =(String) session.getAttribute("needLoginSession");

//		if(sessionValue.equals("needLoginSession")){
		if(sessionValue == "needLoginSession"){
			System.err.println("SessionAuthIntercepter \tafterCompletion() \t[임시 발급세션  확인] : " + session.getAttribute("needLoginSession"));
			session.invalidate();
			System.out.println("SessionAuthIntercepter \tafterCompletion() \t[로그인을 위한 임시 세션 삭제]");
		}else{
			System.err.println("SessionAuthIntercepter \tafterCompletion() \t[임시 발급세션 없음]");
		}
	
		super.afterCompletion(request, response, handler, ex);
	}
	
	
}
