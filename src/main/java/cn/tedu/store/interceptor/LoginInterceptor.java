package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 配置拦截
 * @author soft01
 */
public class LoginInterceptor implements HandlerInterceptor{
	//Spring中配置拦截
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		if(request.getSession().getAttribute("user")!=null) {
			return true;
		}else {
			String url=request.getContextPath()+"/user/showLogin.do";
			response.sendRedirect(url);
			return false;
		}
		
	}
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}



}
