package cn.tedu.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")//表示用来设置当前bean的作用域；prototype表示多例模式，默认情况下为单例模式。
public class DemoScope {

}
