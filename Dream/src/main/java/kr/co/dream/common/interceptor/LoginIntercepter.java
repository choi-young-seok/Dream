package kr.co.dream.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("LoginIntercepter \tpreHandle() \t\t[����� ���ǰ˻�]");
		System.out.println("LoginIntercepter \tpreHandle() \t\t[����� ��û url ] : " +request.getContextPath());
		HttpSession session = request.getSession();
		
		if (session.getAttribute("session") != null) {
			session.removeAttribute("session");
			System.out.println("LoginIntercepter \tpreHandle() \t\t[�α׾ƿ� ����]");
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoginIntercepter \tpostHandle() \t\t[�α��� ���� ���� �߱�]");
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object member = modelMap.get("member");
		session.setAttribute("session", member);
		super.postHandle(request, response, handler, modelAndView);
	}

	
	//ajax��û�� �𵨿��䰴ü���� ������Ʈ �߻�?
	//ajax��û�̶� �����͸� ���۵ǹǷ� �䰴ü������ ������Ʈ�� �߻��ϴ°ǰ�?
	
	// @Override
	// public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	// ModelAndView modelAndView) throws Exception {
	//
	// System.out.println(" --- LoginIntercepter [postHandle() ����� ���ǰ˻� �� ���Ǽ���]");
	// ModelMap map = modelAndView.getModelMap();
	// Object member = map.get("member");
	//
	// if (member != null) {
	// System.out.println(" --- LoginIntercepter [postHandle() ���ο� �α��� ����]");
	// HttpSession session = request.getSess	ion();
	// session.setAttribute("session", member);
	// // key : session
	// // value : member(member_mail, member_name)
	//
	// String dest = (String) session.getAttribute("dest");
	//
	// if (dest != null) {
	// modelAndView.setViewName("redirect:/" + dest);
	// }
	// }
	//
	// HttpSession session = request.getSession();
	// super.postHandle(request, response, handler, modelAndView);
	// }

}