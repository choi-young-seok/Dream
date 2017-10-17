package kr.co.dream.common.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionAuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getSession().getAttribute("session") == null) {
			request.getSession().setAttribute("needLoginSession", "needLoginSession");
			return true;
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HttpSession session = request.getSession();
		String sessionValue = (String) session.getAttribute("needLoginSession");

		if (sessionValue == "needLoginSession") {
			session.invalidate();
		} 

		super.afterCompletion(request, response, handler, ex);
	}
}


