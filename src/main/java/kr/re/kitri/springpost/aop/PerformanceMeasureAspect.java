package kr.re.kitri.springpost.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceMeasureAspect {
    //*.*(..) service 패키지 아래의 모든 클래스 안에 있는 모든 메서드 로 줄 수 있다.
    @Around("execution(* kr.re.kitri.springpost.service.*Service.*(..))")
    public Object measurePerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis(); //현재 시간 확보
        Object result = joinPoint.proceed(); // 함수를 실행하면 예외를 발생
        long end = System.currentTimeMillis();
        log.debug(String.format("%s - Method 의 실행시간은 , Time: %d ms 입니다.", joinPoint.getSignature().getName(), end - start));
        return result;
    }
}
