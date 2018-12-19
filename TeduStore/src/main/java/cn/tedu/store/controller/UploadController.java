package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {
	//显示上传的表单
	@RequestMapping("/showUpload.do")
	public String showUpload() {
		return "upload";
	}
	//实现上传文件的功能
	@RequestMapping("/uploadFile.do")
	public String uploadFile(MultipartFile file) {
		//1.使用工具类提供的方法实现上传功能
		try {
			file.transferTo(new File("/home/soft01/桌面/teaching/ssm/学子商城/file",file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.响应页面
		return "redirect:../main/showIndex.do";
	}
}
