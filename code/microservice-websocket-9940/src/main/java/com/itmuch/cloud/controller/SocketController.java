package com.itmuch.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.configure.WebSocket;
import com.itmuch.cloud.utils.AjaxResult;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/websocket")
public class SocketController extends BaseController{

	@Autowired
	private WebSocket webSocket;
	
	@RequestMapping("/find")
	public String findTest() {
		return "成功";
	}
	
	/** 
    * @方法描述: 向所有用户发送消息(一人对所有人发布同一个消息)
    * @return: com.XX.common.base.AjaxResult
    * @Author: carry
    */
    @PostMapping("/sendAllWebSocket")
    public AjaxResult sendAllWebSocket(@RequestParam String jsonMsg) {
        try {
            webSocket.sendAllMessage(jsonMsg);
        } catch (Exception e) {
        	System.err.println(e);
            return error(e.getMessage());
        }
        return success();
    }

    
    /** 
     * @方法描述: 一对一发送消息(一人对一人发布同一个消息)
     * @return: com.XX.common.base.AjaxResult
     * @Author: carry
     */
      @PostMapping("/sendOneWebSocketOneToOne")
      public AjaxResult sendOneWebSocketOneToOne(@RequestParam("userId") String userId, @RequestParam String jsonMsg) {
          try {
              webSocket.sendOneMessage(userId, jsonMsg);
          } catch (Exception e) {
              return error(e.getMessage());
          }
   
          return success();
      }
   
      /**
       * @方法描述: 一对一发送多消息(一人对一人发布多个消息)
       *         此方法会出现多线程问题，需要在sendOneMessage进行处理
       * @return: com.XX.common.base.AjaxResult
       * @Author: carry
       */
      @PostMapping("/sendManayWebSocketOneToOne")
      public AjaxResult sendManayWebSocketOneToOne(@RequestParam("userId") String userId, @RequestParam String jsonString) {
          try {
              JSONArray jsonArray = JSONArray.fromObject(jsonString);
              for(int i=0;i<jsonArray.size();i++){
                  JSONObject jsonObject= JSONObject.fromObject(jsonArray.get(i));
                  webSocket.sendOneMessage(userId, jsonObject.toString());
              }
          } catch (Exception e) {
              return error(e.getMessage());
          }
   
          return success();
      }
   
      /** 
      * @方法描述: 一对多发送消息(一人对多人发布同一个消息)
      * @return: com.fencer.common.base.AjaxResult
      * @Author: carry
      */
      @PostMapping("/sendUserListWebSocket")
      public AjaxResult sendUserListWebSocket(@RequestParam List<String> userList, @RequestParam String jsonMsg) {
          try {
              for (String userId : userList) {
                  webSocket.sendOneMessage(userId, jsonMsg);
              }
   
          } catch (Exception e) {
              return error(e.getMessage());
          }
   
          return success();
      }
}
