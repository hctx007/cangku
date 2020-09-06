package com.util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
public class LoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//获取Session
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cgy");
		if(obj != null)
			return true;
		//没有登录且不是登录页面，转发到登录页面，并给出提示错误信息
		request.setAttribute("msg", "登录失效，请重新登录！");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return false;
	}
}
