package com.itmuch.cloud.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.itmuch.cloud.service.LogService;
import com.itmuch.cloud.utils.AjaxResult;

@RestController
public class FileController {
	@Autowired
    private LogService logService;
	

	@GetMapping(value = "/download/{name}")
    public void logDownload(@PathVariable String name, HttpServletResponse response) throws Exception {
        logService.logDownload(name, response);
    }
	/** 单文件上传
	 * @param request
	 * @throws Exception
	 */
	@PostMapping("/upload")
	public AjaxResult logUp(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws Exception {
		return logService.logUp(file);
	}
	/** 多文件上传
	 * @param request
	 * @throws Exception
	 */
	@PostMapping("/uploads")
	public AjaxResult logUps(HttpServletRequest request) throws Exception {
		List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
		try {
			for (MultipartFile file : files) {
				logService.logUp(file);
			}
		} catch (Exception e) {
			return new AjaxResult(500,e.getMessage(),null);
		}
	    return new AjaxResult(200, "成功", null);
	}
}
