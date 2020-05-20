package com.itmuch.cloud.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itmuch.cloud.utils.AjaxResult;

@Service
public class LogService {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
	
	
	public void logDownload(String name, HttpServletResponse response) throws Exception {
		File file = new File("D:" + File.separator + "ceshi" + File.separator + name+".txt");

		if (!file.exists()) {
			throw new FileNotFoundException(name + "文件不存在");
		}
		response.setContentType("application/force-download");
		response.addHeader("Content-Disposition", "attachment;fileName=" + name+".txt");

		byte[] buffer = new byte[1024];
		try (FileInputStream fis = new FileInputStream(file); 
			BufferedInputStream bis = new BufferedInputStream(fis)
		) 
		{
			OutputStream os = response.getOutputStream();
			int i = bis.read(buffer);
			while (i != -1) {
					os.write(buffer, 0, i);
					i = bis.read(buffer);
			}
		}
	}
	
	public AjaxResult logUp(MultipartFile file) throws Exception {
		File folder = new File("D:" + File.separator + "ceshi" + File.separator+"upfile");
	    if (!folder.exists()) {
	        folder.mkdirs();
	    }
	    //上传文件是否为空
	    if(null == file) {
	    	throw new FileNotFoundException("上传文件为空");
	    }
	    String oldName = file.getOriginalFilename();
	    String newName = oldName.substring(0, oldName.lastIndexOf("."))+"-"+sdf.format(new Date()) + oldName.substring(oldName.lastIndexOf("."));
	    file.transferTo(new File(folder,newName));
	    return new AjaxResult(200, "成功", null);
	}
}
