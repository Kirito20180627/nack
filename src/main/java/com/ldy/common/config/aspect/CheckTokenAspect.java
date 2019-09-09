package com.ldy.common.config.aspect;

import com.ldy.common.utils.http.HttpContextUtil;
import com.ldy.common.utils.token.InitToken;
import com.ldy.common.utils.token.JwtUtil;
import com.ldy.entity.vo.JsonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class CheckTokenAspect {
    private static final Logger log = LoggerFactory.getLogger(CheckTokenAspect.class);

    @Pointcut("@annotation(com.ldy.common.config.annotation.CheckToken)")
    public void checkTokenPointCut() {
    }

    private boolean authCheck() {
        return true;
    }

    @Around("checkTokenPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{

        Object result = null;
        JsonResult jsonResult = new JsonResult();
        String userName = HttpContextUtil.getClient();

        // 先尝试获取 token
        String token = JwtUtil.getToken(userName);

        // token 不存在（ 1. 还没有初始化生成 token   2. 没有权限 ）
        if (token.equals("nothing")) {
            //
            if (authCheck()) {
                InitToken.createToken(userName);
                result = joinPoint.proceed();
            }else {
                log.info("请求方没有获得授权");
                jsonResult.setMsg("无授权");
                result = jsonResult;
            }
        }else {
            if (JwtUtil.verifyToken(token, HttpContextUtil.getClient())) {
                result = joinPoint.proceed();
            }else {
                log.info("请求方的token已过期");
                jsonResult.setMsg("token已过期");
                result = jsonResult;
            }
        }
        return result;
    }
}
