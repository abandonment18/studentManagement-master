package com.gfxy.master.vo;

import lombok.Data;

@Data
public class ChatMessage {

    private Integer userId;

    private String username;

    private String avatar;

    private String msg;

    private int count;
}
