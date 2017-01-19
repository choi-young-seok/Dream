package kr.co.dream.common.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionAuthIntercepter extends HandlerInterceptorAdapter {

	//����� ���ǰ˻� �� url�̵�
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (request.getSession().getAttribute("session") == null) {
			request.getSession().setAttribute("needLoginSession","needLoginSession");
			return true;
		}
		
		return true;
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HttpSession session = request.getSession();
		String sessionValue =(String) session.getAttribute("needLoginSession");

		System.out.println("SessionAuthIntercepter [ afterCompletion() session value ] : " + session.getAttribute("needLoginSession"));
		if(sessionValue.equals("needLoginSession")){
			session.invalidate();
			System.out.println("SessionAuthIntercepter [ afterCompletion() ] �α����� ���� �ӽ� ���� ����");
		}
	
		super.afterCompletion(request, response, handler, ex);
	}
	
	
}
