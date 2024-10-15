package com.ziphiro.websocketChat.service;

import com.ziphiro.websocketChat.entity.ChatMessage;

import java.util.List;

public interface ChatService {

    ChatMessage saveMessage(String username, String content);
    List<ChatMessage> getChatHistory();
}
