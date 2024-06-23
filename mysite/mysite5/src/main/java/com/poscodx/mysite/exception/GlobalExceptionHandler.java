package com.poscodx.mysite.exception;


import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poscodx.mysite.dto.JsonResult;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Log logger = LogFactory.getLog(GlobalExceptionHandler.class);
	
	 @ExceptionHandler(NoHandlerFoundException.class)
	    public void handleNoHandlerFoundException(HttpServletRequest request, HttpServletResponse response, NoHandlerFoundException e) throws Exception {
	        // 로깅
		 
	        logger.error("Handler not found - " + request.getRequestURI());

	        // json 요청인지 HTML 요청인지 구분
	        String accept = request.getHeader("accept");

	        if (accept != null && accept.matches(".*application/json.*")) {
	            // JSON 응답
	            JsonResult jsonResult = JsonResult.fail("Handler not found for the requested URL");
	            String jsonString = new ObjectMapper().writeValueAsString(jsonResult);

	            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	            response.setContentType("application/json; charset=utf-8");
	            OutputStream os = response.getOutputStream();
	            os.write(jsonString.getBytes("utf-8"));
	            os.close();
	        } else {
	            // HTML 요청일 경우, 404 페이지로 포워딩
	            request.getRequestDispatcher("/WEB-INF/views/errors/404.jsp").forward(request, response);
	        }
	     
	 }
	 
	
	
			
	@ExceptionHandler(Exception.class)
	public void handler(
		HttpServletRequest request,
		HttpServletResponse response,
		Exception e
	) throws Exception {
		//1. 로깅(logging)
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		logger.error(errors.toString());
		
		//2. 요청구분
		// json 요청: request header에 application/json (o)
		// html 요청: request header에 application/json (x)
		String accept = request.getHeader("accept");
		
		if(accept.matches(".*application/json.*")) {
			//3. json 응답
			JsonResult jsonResult = JsonResult.fail(errors.toString());
			String jsonString = new ObjectMapper().writeValueAsString(jsonResult);
			
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json; charset=utf-8");
			OutputStream os = response.getOutputStream();
			os.write(jsonString.getBytes("utf-8"));
			os.close();
		} else {
			//4. 사과 페이지(정상종료)
			request.setAttribute("error", errors.toString());
			request
				.getRequestDispatcher("/WEB-INF/views/errors/exception.jsp")
				.forward(request, response);
		}
	}
}
