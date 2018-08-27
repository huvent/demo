package com.huxp.core.aspect;

import com.esotericsoftware.reflectasm.FieldAccess;
import com.esotericsoftware.reflectasm.MethodAccess;
import com.huxp.core.annotation.Json;
import org.apache.commons.lang3.StringUtils;
import org.apache.el.util.ReflectionUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import static org.springframework.util.ReflectionUtils.findField;


/**
 * @Author: Huxp
 * @Since: 2018/8/27 下午7:40
 */
@Aspect
@Component
public class FiledFilterAspect {

    @Around("@annotation(json)")
    public Object around(ProceedingJoinPoint point, Json json) throws Throwable {

        Object returnValue = point.proceed(point.getArgs());

        System.out.println(returnValue);

        if (returnValue instanceof Iterable) {
            Iterable iterable = (Iterable) returnValue;
            Iterator it = iterable.iterator();
            if(it.hasNext()){
                Object obj = it.next();
//            }
//            for (Object obj : (Iterable) returnValue) {
                if(json.type().equals(obj.getClass())){
                   String filter =  json.filter();
                   String method = "set"+ StringUtils.capitalize(filter);
//                    MethodAccess access = MethodAccess.get(obj.getClass());
//                    for (String field : access.getMethodNames()) {
//                        if(field.equals(method)){
//                            access.invoke(obj,field,access.getParameterTypes()[access.getIndex(field)],null);
//                        }
//                        System.out.println("field = [" + field + "]");
//                    }
//                    for (Class[] field : access.getParameterTypes()) {
//
//                        System.out.println("field = [" + field + "]");
//                    }
                    Field field =  ReflectionUtils.findField(obj.getClass(),filter);
                    field.setAccessible(true);
                    field.set(obj,null);
//                    Method method1 = ReflectionUtils.findMethod(obj.getClass(),method);
//                    method1.invoke(obj,new Object[]{null});
                }


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

}
