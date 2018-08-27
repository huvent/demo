package com.huxp.core.aspect;

import com.esotericsoftware.reflectasm.FieldAccess;
import com.esotericsoftware.reflectasm.MethodAccess;
import com.huxp.core.annotation.Json;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;


/**
 * @Author: Huxp
 * @Since: 2018/8/27 下午7:40
 */
@Aspect
@Component
public class FiledFilterAspect {

    //&& @annotation(com.huxp.core.annotation.Json)

//    @Around(value = "execution (* com.huxp.demo.controller..*.*(*, *, ..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
//    public Object around(ProceedingJoinPoint point) throws Throwable {
//
//        Json json = extractAccessDescriptor(point);
//
//        Object returnValue = point.proceed(point.getArgs());
//
//        FieldAccess fieldAccess = FieldAccess.get(returnValue.getClass());
//
//        for (String field : fieldAccess.getFieldNames()) {
//            System.out.println("field = [" + field + "]");
//        }
//
//        return returnValue;
//    }


    @Around("@annotation(json)")
    public Object around(ProceedingJoinPoint point, Json json) throws Throwable {

        Object returnValue = point.proceed(point.getArgs());

        System.out.println(returnValue);

        if (returnValue instanceof List) {
            for (Object obj : (List) returnValue) {
                FieldAccess fieldAccess = FieldAccess.get(obj.getClass());
                for (String field : fieldAccess.getFieldNames()) {
                    System.out.println("field = [" + field + "]");
                }

                MethodAccess access = MethodAccess.get(obj.getClass());
                for (String field : access.getMethodNames()) {
                    System.out.println("field = [" + field + "]");
                }
            }
        }

        return returnValue;
    }

    private Json extractAccessDescriptor(JoinPoint point) {

        Json json = null;

        Signature signature = point.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            json = method.getAnnotation(Json.class);
        }

        return json;
    }
}
