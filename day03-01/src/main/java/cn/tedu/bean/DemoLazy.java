package cn.tedu.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(true)//表示对象延迟加载，在使用的时候实例化（不会在初始化容器的时候实例化）
public class DemoLazy {
	public DemoLazy() {
		System.out.println("lazy被实例化了");
	}
}
