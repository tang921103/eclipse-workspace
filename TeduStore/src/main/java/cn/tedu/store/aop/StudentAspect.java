package cn.tedu.store.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
/**
 * 定义切面类
 * @author soft01
 *
 */
@Component
public class StudentAspect {
	public void test1() {
		System.out.println("模拟前置通知");
	}
}
