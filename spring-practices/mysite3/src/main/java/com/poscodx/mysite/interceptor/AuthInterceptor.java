package com.poscodx.mysite.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.poscodx.mysite.vo.UserVo;

public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*
		 * 특정 url로 들어온 것에 대해서, interceptor를 적용해서 인가를  수행한다
		 */
		
		//1. handler 종류 확인 
		if (!(handler instanceof HandlerMethod)) {
			// DefaultServletHandler가 처리하는 경우 (정적자원, 매핑이 안된 url)
			return true;
		}
		
		//2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		//3. @Auth가져오기
		
		Auth auth = handlerMethod.getBeanType().getAnnotation(Auth.class);
		if (auth == null) auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		
		//4. hnalder method에 @Auth가 없는 경우
		if(auth == null) {
			return true;
		}
		
		//5. @Auth가 붙어 있기 때문에 인증(Authentication)확인을 한다
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		if(authUser == null ) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		
		
		//6. 권한 체크를 위해 role 가져오기("USER", "ADMIN")
		String role = auth.role();

		
		
		//7. @Auth role이 "USER"인 경우, authUser의 role은 상관없다
		if ("USER".equals(role)) {
			return true;
		}

		//8. @Auth role이 "ADMIN"인 경우, role을 따져봐야 한다
		if (!"ADMIN".equals(authUser.getRole())) {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		
		
		//9. role이 관리자
		return true;
		
	
		

		
	}
	
}
