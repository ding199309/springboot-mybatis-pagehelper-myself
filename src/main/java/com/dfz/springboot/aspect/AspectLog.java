package com.dfz.springboot.aspect;

import com.dfz.springboot.annotation.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author dfz
 * E-mail:  dfz@jkinvest.cn
 * @version 1.0
 * @date 创建时间：2017/11/13 17:55
 * @parameter
 * @return
 */

@Component
@Aspect
public class AspectLog {

      private Logger logger= LoggerFactory.getLogger(AspectLog.class);
      ThreadLocal<Long> time=new ThreadLocal<>();

    @Around("@annotation(com.dfz.springboot.annotation.Log)")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        time.set(System.currentTimeMillis());
        Object obj=point.proceed();
        System.out.println("=====时间差===="+(System.currentTimeMillis()-time.get()));


        ServletRequestAttributes attributes  = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("URL:"+request.getRequestURL().toString());
        logger.info("HTTP_METHOD:" + request.getMethod());
        logger.info("IP:"+request.getRemoteAddr());
        logger.info("CLASS_METHOD:" + point.getSignature().getDeclaringTypeName() + "...." + point.getSignature().getName());
        logger.info("ARGS:" + Arrays.toString(point.getArgs()));


        saveLog(point,System.currentTimeMillis()-time.get());
        return obj;
    }


    public void  saveLog(ProceedingJoinPoint point,long time){

            MethodSignature signature= (MethodSignature) point.getSignature();
            Method method=signature.getMethod();
            Class<?> clazz=  signature.getClass();
            Log log=method.getAnnotation(Log.class);
            if(log!=null){
                System.out.println("=====注解============"+log.value());
            }
            //类名
            String className=point.getTarget().getClass().getName();
            //方法名
            String methodName=signature.getName();
            //请求参数
            Object[] args=point.getArgs();



    }
}
