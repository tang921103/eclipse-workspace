package raf;
/**
 * 登陆验证
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
public class Demo3 {
	public static void main(String [] args) throws IOException{
		RandomAccessFile raf = new RandomAccessFile("user.dat","r");
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入用户名");
		String name = scan.nextLine();
		System.out.println("请输入密码");
		String password = scan.nextLine();
		boolean logIn = true;
		for(int i = 0;i<raf.length()/100;i++){	
			raf.seek(i*100);
			byte[] data = new byte[32];
			raf.read(data);
			String useName = new String(data,"UTF-8").trim();			
			if(name.equals(useName)){
				raf.read(data);
				String usePassword = new String(data,"UTF-8").trim();				
				if(password.equals(usePassword)){
					System.out.println("登录成功");
					logIn = false;					
				}	
				break;														
			}			
			}					
		if(logIn){
			System.out.println("用户名和密码错误！");
		}
		raf.close();
	}
}
