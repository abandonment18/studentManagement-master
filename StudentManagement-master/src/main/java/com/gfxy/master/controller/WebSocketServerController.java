package com.gfxy.master.controller;

import com.alibaba.fastjson.JSONObject;
import com.gfxy.master.service.UserService;
import com.gfxy.master.vo.ChatMessage;
import com.gfxy.master.vo.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@Tag(name = "WebSocketServerController", description = "聊天")
@Slf4j
@Component
@ServerEndpoint("/personChat/{sid}/{userId}")
public class WebSocketServerController {

    /**
     * 房间 号 -> 组成员信息
     */
    private static final ConcurrentHashMap<String, List<Session>> groupMemberInfoMap = new ConcurrentHashMap<>();
    /**
     * 房间 号 -> 在线人数
     */
    private static final ConcurrentHashMap<String, Set<Integer>> onlineUserMap = new ConcurrentHashMap<>();

    /**
     * 因为 applicationContext 与 webSocket 是两个线程
     * 如果 单纯的用
     *
     * @Autowired private UserService userService;
     * 是不能用的，因为这里想调用 applicationContext 会报指针异常，因为不在同一线程
     * 具体请看 https://blog.csdn.net/song_chengbo/article/details/110120641
     */
    private static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        WebSocketServerController.userService = userService;
    }

    /**
     * 收到消息调用的方法，群成员发送消息
     *
     * @param sid:房间号
     * @param userId：用户id
     * @param message：发送消息
     */
    @OnMessage
    public void onMessage(@PathParam("sid") String sid, @PathParam("userId") Integer userId, String message) {
        List<Session> sessionList = groupMemberInfoMap.get(sid);
        Set<Integer> onlineUserList = onlineUserMap.get(sid);
        // 先一个群组内的成员发送消息
        sessionList.forEach(item -> {
            try {
                // json字符串转对象
                ChatMessage msg = JSONObject.parseObject(message, ChatMessage.class);
                msg.setCount(onlineUserList.size());
                // json对象转字符串
                String text = JSONObject.toJSONString(msg);
                item.getBasicRemote().sendText(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 建立连接调用的方法，群成员加入
     *
     * @param session
     * @param sid
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid, @PathParam("userId") Integer userId) {
        // 初始化 sessionList 和 onlineUserList。如果 sid 对应的 sessionList 或 onlineUserList 不存在，则会创建一个新的 list 或 set。
        List<Session> sessionList = groupMemberInfoMap.computeIfAbsent(sid, k -> new ArrayList<>());
        Set<Integer> onlineUserList = onlineUserMap.computeIfAbsent(sid, k -> new HashSet<>());
        onlineUserList.add(userId);
        sessionList.add(session);
        // 发送上线通知
        sendInfo(sid, userId, onlineUserList.size(), "上线了~");
    }


    public void sendInfo(String sid, Integer userId, Integer onlineSum, String info) {
        // 获取该连接用户信息
        User user = userService.selectInfoById(userId);
        // 发送通知
        ChatMessage msg = new ChatMessage();
        msg.setCount(onlineSum);
        msg.setUserId(userId);
        msg.setAvatar(user.getAvatar());
        msg.setUsername(user.getUsername());
        msg.setMsg(info);
        // json对象转字符串
        String text = JSONObject.toJSONString(msg);
        onMessage(sid, userId, text);
    }

    /**
     * 关闭连接调用的方法，群成员退出
     *
     * @param session
     * @param sid
     */
    @OnClose
    public void onClose(Session session, @PathParam("sid") String sid, @PathParam("userId") Integer userId) {
        List<Session> sessionList = groupMemberInfoMap.get(sid);
        sessionList.remove(session);
        Set<Integer> onlineUserList = onlineUserMap.get(sid);
        onlineUserList.remove(userId);
        // 发送离线通知
        sendInfo(sid, userId, onlineUserList.size(), "下线了~");
    }

    /**
     * 传输消息错误调用的方法
     *
     * @param error
     */
    @OnError
    public void OnError(Throwable error) {
        log.info("Connection error");
    }
}
