package test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestMd5 {
	@Test
	public void testString(){
		String str1 = "123456";
		String str2 = "123456";
		//获取消息摘要
		String md5Str1 = 
				DigestUtils.md5Hex(str1);
		String md5Str2 = 
				DigestUtils.md5Hex(str2);
		
		System.out.println(md5Str1);
		System.out.println(md5Str2);
	}
}










