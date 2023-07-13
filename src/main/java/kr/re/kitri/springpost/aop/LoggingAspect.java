package kr.re.kitri.springpost.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // 이전에는 별도의 설정파일에 advice가 어떤 기능에 weaving 될지를 적어놓는 방식이었으니
    // 최근에 annotation 방식으로 변경되었다.(==포인트컷, 타겟) *(..) 모든 메서드인데, 파라미터 타입은 관계 없다
    @Before("execution(* kr.re.kitri.springpost.service.PostService.*(..))")
    public void doLogging(JoinPoint joinPoint){ // 타겟 메서드에 대한 정보를 joinpoint를 통해서 파악할 수 있다.
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        log.debug(" {} - {} 에서 로그를 남깁니다.", className, methodName);
    }

}
