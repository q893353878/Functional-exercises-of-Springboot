package com.st.aop;

import com.st.kit.Retkit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @ClassName AopExample
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/4 0004 上午 9:21
 * @Version 1.0
 **/
@Aspect
@Configuration
public class AopExample {
    /**
     * @author Admin
     * 使用@Aspect注解将一个java类定义为切面类
     * 使用@Pointcut定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等。
     * 根据需要在切入点不同位置的切入内容
     * 使用@Before在切入点开始处切入内容
     * 使用@After在切入点结尾处切入内容,不管是抛出异常或者正常退出都会执行
     * 使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     * 使用@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
     * 使用@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑
     *
     */
/**
 * @author Admin
 * 由于通过AOP实现，程序得到了很好的解耦，但是也会带来一些问题，比如：我们可能会对Web层做多个切面，校验用户，
 * 校验头信息等等，这个时候经常会碰到切面的处理顺序问题。
 *
 * 所以，我们需要定义每个切面的优先级，我们需要@Order(i)注解来标识切面的优先级。
 * i的值越小，优先级越高。假设我们还有一个切面是CheckNameAspect用来校验name必须为didi，
 * 我们为其设置@Order(10)，而上文中WebLogAspect设置为@Order(5)，所以WebLogAspect有更高的优先级，这个时候执行顺序是这样的：
 *
 * 在@Before中优先执行@Order(5)的内容，再执行@Order(10)的内容
 * 在@After和@AfterReturning中优先执行@Order(10)的内容，再执行@Order(5)的内容
 * 所以我们可以这样子总结：
 *
 * 在切入点前的操作，按order的值由小到大执行
 * 在切入点后的操作，按order的值由大到小执行
 */

    /**
     * @author Admin
     * 测试-aop-@Around proceed()之前
     * 测试-aop-@Before
     * 目标方法-testAop
     * 测试-aop-@Around proceed()之后
     * 测试-aop-@After
     * 测试-aop-@AfterReturning
     */

    /**
     * @author Admin
     * 不执行 proceed()
     * 测试-aop-@Around proceed()之前
     * 测试-aop-@After
     * 测试-aop-@AfterReturning
     */
    @Pointcut(value = "@annotation(AopAnnotation)")
    public void annotation() {
    }

    @Around(value = "annotation()&&@annotation(aopAnnotation)")
    public Object ceshiAopAnnotation(ProceedingJoinPoint proceedingJoinPoint, AopAnnotation aopAnnotation) throws Throwable {
        System.out.println(aopAnnotation.value());
        return Retkit.fail().message("你没有权限哦");
    }
    /**
     * @author admin
     * @date 2018/12/22-9:09
     * 两个..代表所有子目录，最后括号里的两个..代表所有参数
     */

    @Pointcut("execution(public * com.st.*.*(..))")
    public void logPointCut() {
    }


    /**
     * @author admin
     * @date 2018/12/22-9:27
     * 匹配Person类中的所有方法
     */


    @Pointcut("execution(public * com.st.aop..*.*(..))")
    public void before() {
    }


    /**
     * @author admin
     * @date 2018/12/2-9:31
     * 任何通知方法可以将第一个参数定义为org.aspectj.lang.JoinPoint类型
     * （环绕通知需要定义第一个参数为ProceedingJoinPoint类型，它是 JoinPoint 的一个子类）。
     * JoinPoint接口提供了一系列有用的方法，
     * getArgs()（返回方法参数）、
     * getThis()（返回代理对象）
     * getTarget()（返回目标）
     * getSignature()（返回正在被通知的方法相关信息）和
     * toString()（打印出正在被通知的方法的有用信息）
     */
    /**
     * @author admin
     * @date 2018/12/22-9:45
     * args 将目标方法的参数传入通知方法中
     */
    @Before(value = "before()")
    public void ceshiBefore(JoinPoint point) {
        /**
         * @author admin
         * @date 2018/12/22-9:37
         * 获取方法的的参数
         */
        /**
         * @author admin
         * @date 2018/12/22-9:59
         * 返回目标对象
         */
        /**
         * @author admin
         * @date 2018/12/22-9:59
         * 返回cglib代理的对象
         */

        System.out.println("测试-aop-@Before");
    }

    @After(value = "before()")
    public void ceshiAlter(JoinPoint joinPoint) {
        System.out.println("测试-aop-@After");
    }

    @AfterReturning(value = "before()", returning = "ret")
    public void ceshiAfterReturning(JoinPoint joinPoint, Retkit ret) {
        System.out.println(ret);
        ret.message("@AfterReturning");
        System.out.println("测试-aop-@AfterReturning");
    }

    @Around(value = "before()")
    public Object ceshiAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("测试-aop-@Around proceed()之前");
        if (true) {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            System.out.println(request.getParameter("jail"));
        }
        Retkit<Object> fail = Retkit.fail();
        System.out.println("测试-aop-@Around proceed()之后");
        return fail;
    }

    @AfterThrowing(value = "before()", throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        //目标方法名：
        System.out.println(exception.getMessage());
    }
}

