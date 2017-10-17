package kr.co.dream.common.interceptor;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.dream.member.domain.MemberVO;

public class MemberAutInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		System.out.println("getRequestURI : "+request.getRequestURI());
//		System.out.println("getRequestURL : "+request.getRequestURL());
//		System.out.println("getContextPath : "+request.getContextPath());
//		System.out.println("getParameterMap : "+request.getParameterMap());
		
//		Enumeration<String> aa = request.getParameterNames();
//		System.out.println("�̳ʸӷ��̼� : "+aa);
//		List<Map> parameters = new ArrayList<>();
//		Map map = new HashMap<>();
//		while(aa.hasMoreElements()){
//		for (int i = 0; aa.hasMoreElements(); i++) {
//			String parameter = aa.nextElement();
//			map.put(parameter, request.getParameter(parameter));
//			System.out.println("�� : "+map);
//			parameters.add(map);			
//		}
//		}
//		System.out.println("List parameters : "+parameters);
//		System.out.println("List size : "+parameters.size());
//		for (int i = 0; i < parameters.size(); i++) {
//			System.out.println("�̰ǹ��� : "+parameters.get(i));
//		}
		
//		System.out.println("getParameterNames : "+request.getParameterNames().toString());
//		System.out.println("getParameter(member_no) : "+request.getParameter("member_no"));
//		System.out.println("getSession().getAttribute(session) : "+request.getSession().getAttribute("session"));

		int member_no =  Integer.parseInt(request.getParameter("member_no"));
		MemberVO memberVO = (MemberVO) request.getSession().getAttribute("session");
		if(memberVO == null){
			//�α��ο�û
			response.sendRedirect("/dream/login_view");
			return false;
		}
		if(member_no != memberVO.getMember_no()){
			System.out.println("�߸��� ����");
			System.out.println("���ǹ�ȣ : " + memberVO.getMember_no());
//			request.setAttribute("member_no", memberVO.getMember_no());
			//���ǹ�ȣ�� �ٽ� �����̷�Ʈ
			response.sendRedirect(request.getRequestURI()+"?member_no="+memberVO.getMember_no());
			return false;
		}else{
			System.out.println("�ùٸ� ����");
		}
//		System.out.println("getParameter(member_no) : "+request.getParameter("member_no"));
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}
}
