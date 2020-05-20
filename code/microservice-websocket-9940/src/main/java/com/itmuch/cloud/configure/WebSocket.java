package com.itmuch.cloud.configure;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@Component
@ServerEndpoint(value = "/websocket/{userId}")	
public class WebSocket {
	private static int onlineCount=0;
	
	private Session session;
	
	//concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private static Map<String, Session> sessionPool = new HashMap<String, Session>();
    
    /**
     * @方法描述: 开启socket
     * @return: void
     * @Author: carry
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "userId") String userId) {
        this.session = session;
        webSockets.add(this);//加入set中
        addOnlineCount();           //在线数加1
        sessionPool.put(userId, session);//把对应用户id的session放到sessionPool中，用于单点信息发送
        System.out.println("【websocket消息】 有新连接加入！用户id" + userId + "，当前在线人数为" + getOnlineCount());
    }
    
    /**
     * @方法描述: 关闭socket
     * @return: void
     * @Author: carry
     */
    @OnClose
    public void onClose() {
        webSockets.remove(this);
        subOnlineCount();           //在线数减1
        System.out.println("【websocket消息】 连接断开！当前在线人数为" + getOnlineCount());
    }
 
    /**
     * @方法描述: 收到客户端消息
     * @return: void
     * @Author: carry
     */
    @OnMessage
    public void onMessage(String message) {
        System.out.println("【websocket消息】收到客户端消息:" + message);
        sendAllMessage(message);
    }
 
    /**
     * @方法描述: 广播消息全体发送
     * @return: void
     * @Author: carry
     */
    public void sendAllMessage(String message) {
    	System.err.println("信息："+message);
        for (WebSocket webSocket : webSockets) {
            System.out.println("【websocket消息】广播消息:" + message);
            try {
                webSocket.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
 
    /**
     * @方法描述: 一对一单点消息
     * @return: void
     * @Author: carry
     */
    public  void  sendOneMessage(String userId, String message) {
        try {
            // 防止推送到客户端的信息太多导致弹窗太快
            Thread.sleep(500);
            System.out.println("用户"+userId+"【websocket消息】单点消息:" + message);
            Session session = sessionPool.get(userId);
            if (session != null) {
                // getAsyncRemote是异步发送，加锁防止上一个消息还未发完下一个消息又进入了此方法
                // 也就是防止多线程中同一个session多次被调用报错,虽然上面睡了0.5秒，为了保险最好加锁
                synchronized (session) {
                    session.getAsyncRemote().sendText(message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /**
     * @方法描述: 发生错误时调用
     * @return: void
     * @Author: carry
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }
 
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
 
    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }
 
    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }



}
