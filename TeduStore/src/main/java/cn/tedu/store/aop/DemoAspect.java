package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
//表示类为切面类
@Aspect
public class DemoAspect {
	//before表示在业务方法之前执行的代码
	//bean（userService）表示横切的bean类为UserService
	//userService表示Spring实例化bean的名称（id）
	//前置通知
	@Before("bean(userService)")
	public void test1() {
		System.out.println("业务方法之前执行!");
	}
	//最终通知,不管有没有异常都要执行的方法
	@After("bean(userService)")
	public void test2() {
		System.out.println("业务方法之后执行！");
	}
	//后置通知
	//不发生异常，执行该通知
	@AfterReturning("bean(userService)")
	public void test3() {
		System.out.println("afterReturning");
	}
	//后置通知
	//发生异常，执行该通知
	@AfterThrowing("bean(userService)")
	public void test4() {
		System.out.println("afterThrowing");
	}
	//环绕通知
	//1.方法必须有返回值。返回值类型：业务逻辑方法的返回值类型
	//2.必须有参数
	//3.必须把值返回
	@Around("execution(* cn.tedu.store.service.UserService.login(..))")
	public Object test5(ProceedingJoinPoint pp) throws Throwable {
		System.out.println("业务开始");
		long t1 = System.currentTimeMillis();
		Object obj = pp.proceed();
		long t2 = System.currentTimeMillis();
		System.out.println("业务完毕");
		System.out.println("执行时间："+(t2-t1));
		return obj;
	}
}
