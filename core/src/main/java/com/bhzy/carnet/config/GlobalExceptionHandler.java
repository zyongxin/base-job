package com.bhzy.carnet.config;



import com.bhzy.carnet.enmus.ResponCodeEnmu;
import com.bhzy.carnet.resutl.Message;
import com.bhzy.carnet.utils.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	
		private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

		// 添加全局异常处理流程，根据需要设置需要处理的异常
		@ExceptionHandler(value = Exception.class)
		public Message globalExceptionHandler(HttpServletRequest request,
				Exception exception) {
			logger.error("捕获了{}异常  访问路径为:{} 参数为:{} 错误信息为:{}",
					exception.getClass(),request.getRequestURI(),request.getQueryString(), ExceptionUtil.getStackTraceAsString(exception));
			Message response = Message.build(ResponCodeEnmu.FAIL.getCode(),
					"系统异常，请稍后再试", ExceptionUtil.getStackTraceAsString(exception));
			return response;
		}
		
		@ExceptionHandler(value = BusinessException.class)
		public Message businessExceptionHandler(HttpServletRequest request,
				Exception exception) {
			logger.error("捕获了{}异常  访问路径为:{} 参数为:{} 错误信息为:{}",
					exception.getClass(),request.getRequestURI(),request.getQueryString(),ExceptionUtil.getStackTraceAsString(exception));
			Message response = Message.build(ResponCodeEnmu.FAIL.getCode(),
					exception.getMessage(), ExceptionUtil.getStackTraceAsString(exception));
			return response;
		}
		
		@ExceptionHandler(value = MissingServletRequestParameterException.class)
		public Message MissingServletRequestParameterExceptionHandler(HttpServletRequest request,
				Exception exception) {
			logger.error("捕获了{}异常  访问路径为:{} 参数为:{} 错误信息为:{}",
					exception.getClass(),request.getRequestURI(),request.getQueryString(),ExceptionUtil.getStackTraceAsString(exception));
			Message response = Message.build(ResponCodeEnmu.FAIL.getCode(),
					"参数异常", ExceptionUtil.getStackTraceAsString(exception));
			return response;
		}
		
}
