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
		System.out.println("프리인터");
		HttpSession session = request.getSession();
		if (session.getAttribute("session") != null) {
			session.removeAttribute("session");
			System.out.println(">>> 기존 로그인 정보 삭제");
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("포스트 인터");
		ModelMap map = modelAndView.getModelMap();
		Object member = map.get("member");

		if (member != null) {
			System.out.println(" >>> 새로운 로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("session", member);
			// key : session 
			// value : member(member_mail, member_name)

			String dest = (String) session.getAttribute("dest");

			if (dest != null) {
				modelAndView.setViewName("redirect:/" + dest);
			}
		}

		HttpSession session = request.getSession();
		super.postHandle(request, response, handler, modelAndView);
	}

}
