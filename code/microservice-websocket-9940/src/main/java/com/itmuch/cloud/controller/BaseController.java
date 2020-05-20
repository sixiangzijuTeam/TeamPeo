package com.itmuch.cloud.controller;

import com.itmuch.cloud.utils.AjaxResult;

public class BaseController {

	
	public  AjaxResult error(String msg) {
		return new AjaxResult(AjaxResult.FAIL_CODE, msg, null);
	}
	
	public  AjaxResult success() {
		return new AjaxResult(AjaxResult.SUCCESS_CODE, null, null);
	}
}
