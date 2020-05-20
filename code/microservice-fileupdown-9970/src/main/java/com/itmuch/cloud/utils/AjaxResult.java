package com.itmuch.cloud.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AjaxResult {
	
	public final static Integer SUCCESS_CODE=200;
	public final static Integer FAIL_CODE=500;
	
	private Integer code ;
	private String msg;
	private String data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public AjaxResult(Integer code, String msg, String data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public AjaxResult() {
		super();
	}
	
	
}
