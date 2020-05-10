//package crw.bishe.team.aop;
//
//import lombok.extern.log4j.Log4j2;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Description aop缓存管理，用Redis做缓存
// * @Author crw
// * @Date Created in 2019/12/26 0026
// * @Time 18:27
// */
//@Configuration
//@Aspect
//@Log4j2
//public class CacheAspect {
//    //切入点
//    @Pointcut("@annotation("")")
//    public void pointCut() {
//    }
//
//    @Around("pointCut()")
//    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
//        log.info("环绕通知的目标方法名："+proceedingJoinPoint.getSignature().getName());
//        try {
//            Object obj = proceedingJoinPoint.proceed();
//            return obj;
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        return null;
//    }
//}
