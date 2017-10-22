package kr.co.dream.common.intercepter;

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

		System.out.println("LoginIntercepter \tpreHandle() \t\t[사용자 세션검사]");
		HttpSession session = request.getSession();
		
		if (session.getAttribute("session") != null) {
			session.removeAttribute("session");
			System.out.println("LoginIntercepter \tpreHandle() \t\t[로그아웃 성공]");
		}
		return super.preHandle(request, response, handler);
	}

//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		System.out.println("LoginIntercepter \tpostHandle()");
//		Object member = modelAndView.getModel();
//		System.out.println("modelandView.getModel"+member);
//		
//		System.out.println(request.getAttribute("member"));
//		
//		ModelMap map = modelAndView.getModelMap();
////		Object member = map.get("member");
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("session", member);
//
//		System.out.println("LoginIntercepter \tpostHandle() \t\t[로그인 성공 세션 발급]");
//		super.postHandle(request, response, handler, modelAndView);
//	}

	
	//ajax요청시 모델엔뷰객체에서 널포인트 발생?
	//ajax요청이라서 데이터만 전송되므로 뷰객체에대한 널포인트가 발생하는건가?
	
	// @Override
	// public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	// ModelAndView modelAndView) throws Exception {
	//
	// System.out.println(" --- LoginIntercepter [postHandle() 사용자 세션검사 및 세션설정]");
	// ModelMap map = modelAndView.getModelMap();
	// Object member = map.get("member");
	//
	// if (member != null) {
	// System.out.println(" --- LoginIntercepter [postHandle() 새로운 로그인 성공]");
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
