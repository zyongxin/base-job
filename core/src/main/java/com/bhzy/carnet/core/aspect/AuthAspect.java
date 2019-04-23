package com.bhzy.carnet.core.aspect;



import com.bhzy.carnet.core.annotation.Auth;
import com.bhzy.carnet.core.annotation.SysLogger;
import com.bhzy.carnet.enmus.ResponCodeEnmu;
import com.bhzy.carnet.resutl.Message;
import com.bhzy.carnet.utils.ExceptionUtil;
import com.bhzy.carnet.utils.RedisUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限认证，切面处理类
 */
@Aspect
@Component
public class AuthAspect {
	@Autowired
	private RedisUtil redisUtil;
	private static Logger logger = LoggerFactory.getLogger(AuthAspect.class);


	@Pointcut("@annotation(com.bhzy.carnet.core.annotation.Auth)")
	public void logPointCut() {

	}
	
	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();

		String token = (String)request.getAttribute("token");
		if(token == null){
			return new Message(ResponCodeEnmu.NO_LOGIN);
		}
		if(redisUtil.get(token) == null){
			return new Message(ResponCodeEnmu.NO_LOGIN);
		}
		Object result = point.proceed();
		return result;
	}


    
}
