package crw.bishe.team.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * @Description aop日志管理
 * @Author crw
 * @Date Created in 2019/12/20 0020
 * @Time 11:15
 */
@Configuration
@Aspect
@Log4j2
public class WebLogAspect {

    // 排除掉WebSocket ,否则无法使用@ServerEndpoint
//    @Pointcut("!execution(public * crw.bishe.team.controller.MyWebSocket.*(..))")
//    public void webLog2(){}

    //切入点
    @Pointcut("execution(public * crw.bishe.team..*.*(..)) && !execution(public * crw.bishe.team.controller.MyWebSocket.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 记录下请求内容
        log.info("调用类名 : " + joinPoint.getSignature().getDeclaringType().getSimpleName() + "--->方法名为 : " + joinPoint.getSignature().getName());
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) {
        // 处理完请求，返回内容
        log.info(joinPoint.getSignature().getDeclaringType().getSimpleName() +"类"+joinPoint.getSignature().getName()+"方法的"+"返回值 : " + ret);
    }

}
