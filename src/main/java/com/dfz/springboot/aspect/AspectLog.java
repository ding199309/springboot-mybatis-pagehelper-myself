package com.dfz.springboot.aspect;

import com.dfz.springboot.annotation.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

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

    @Around("@annotation(com.dfz.springboot.annotation.Log)")
    public Object log(ProceedingJoinPoint point){
        Object obj=null;
        try {
            obj= point.proceed();
            MethodSignature signature= (MethodSignature) point.getSignature();
            Method method=signature.getMethod();
            Log log=method.getAnnotation(Log.class);
            if(log!=null){
                System.out.println("================="+log.value());
            }
            String className=point.getTarget().getClass().getName();//类名
            String methodName=signature.getName();//方法名

            Object[] args=point.getArgs();//请求参数

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


        return obj;
    }

}
