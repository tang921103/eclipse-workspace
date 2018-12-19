package base.common;

import java.lang.reflect.Method;

/**
 * 为了方便利用java反射调用处理器的方法而设计的类。
 * 	method.invoke(obj);
 * @author soft01
 *
 */
public class Handler {
	private Method mh;
	private Object obj;
	public Handler(Method mh,Object obj) {
		this.mh = mh;
		this.obj = obj;
	}
	public Method getMh() {
		return mh;
	}
	public Object getObj() {
		return obj;
	}
	public void setMh(Method mh) {
		this.mh = mh;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
