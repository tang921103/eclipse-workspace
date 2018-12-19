package cn.tedu.store.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameAlreadyExistException;
@Service
public class UserService implements IUserService{
	@Resource
	private UserMapper userMapper;
	public void addUser(User user) {
		//1.调用持久层的方法
		//selectByUsername(user.getUsername());
		//返回user1对象
		User user1 = 
				userMapper.selectByUsername(
				user.getUsername());
		
		//2.如果user1==null，
		//调用insertUser(user)方法；
		if(user1==null){
			userMapper.insertUser(user);
		}else{
		//3.如果user1!=null,抛出异常UsernameAlreadyExistException;
			//throw new UsernameAlreadyExistException("用户名已存在！");
			throw new 
			UsernameAlreadyExistException(
					"用户名已存在！");
		}
	}
	public boolean checkEmail(String email) {
		
	  return userMapper.selectByEmail(email)>0;
	}
	public boolean checkPhone(String phone) {
		
		return userMapper.selectByPhone(phone)>0;
	}
	public boolean checkUsername(String username) {
		
		return userMapper.selectByUsername(username)!=null;
	}
	public User login(String username, String password) {
		System.out.println("userService开始");
		System.out.println();
		//1.调用持久层的方法：selectByUsername(username);返回user对象
		User user= 
			userMapper.selectByUsername(username);
		if(user==null){
			//3.抛出异常UserNotFoundException("账号不存在");
			throw new UserNotFoundException("账号不存在");
		}else{
			//4.从user对象中取出密码和参数的password比较
			if(user.getPassword().equals(password)){
			//5.return user;
				
				return user;
			}else{
				//6.抛出异常PasswordNotMatchException("密码错误")
				throw new PasswordNotMatchException("密码错误");
			}		
		}
		
	}
	public void changePassword(
			Integer id, 
			String oldPwd, 
			String newPwd) {
		//1.调用，返回user对象
		User user = 
				userMapper.selectUserById(id);
		//2.判断user是否为null，
			//如果为null，表示没有该用户
			//如果不为null，表示用户存在
		if(user!=null){
			//判断旧密码是否相同
			//如果旧密码相同，那么修改密码
			//否则抛出异常
			if(user.getPassword().equals(oldPwd)){
				User user1 = new User();
				user1.setId(id);
				user1.setPassword(newPwd);
				userMapper.updateUser(user1);
			}else{
				throw new PasswordNotMatchException(
						"旧密码不匹配");
			}
		}else{
			//抛出异常
			throw new UserNotFoundException(
					"用户不存在");
		}
		
	}
	public void updateUser(Integer id, 
			String username, 
			Integer gender, 
			String email, 
			String phone) {
		//1.调用持久层的selectUserById(id),
		//返回user1对象;用来检查用户是否存在
		User user1 = 
			userMapper.selectUserById(id);
		//user1不为null，表示用户存在
		if(user1!=null){
			//检查用户名是否重复
			//调用持久层的方法selectUserByUsername(username)
			User user2 = 
				userMapper.selectByUsername(username);
			//如果user2不为null，说明数据库中存在该用户名
			//如果用户名和登录用户的名称相同，可以实现修改
			if(user2!=null&&!username.equals(
					user1.getUsername())){
				throw new UsernameAlreadyExistException(
						"用户名已存在");
			}else{
				User user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setPhone(phone);
				user.setEmail(email);
				user.setGender(gender);
				userMapper.updateUser(user);
			}
			
		}else{
			//表示用户不存在，抛出异常
			throw new UserNotFoundException(
					"用户不存在");
		}
		
		
	}
	public User getUserById(Integer id) {
		
		return userMapper.selectUserById(id);
	}
	/**
	 * 修改图片
	 */
	public void updateImage(Integer id, String image) {
		userMapper.updateImage(id, image);
		
	}

}




