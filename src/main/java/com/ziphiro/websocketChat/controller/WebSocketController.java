package com.ziphiro.websocketChat.controller;

import com.ziphiro.websocketChat.entity.ChatMessage;
import com.ziphiro.websocketChat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WebSocketController {

    private final ChatService chatService;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        return chatService.saveMessage(message.getUsername(), message.getContent());
    }

    @RestController
    @RequestMapping("/api")
    public class ChatRestController { @GetMapping("/messages")
        public List<ChatMessage> getAllMessages() {
            return chatService.getChatHistory();
        }
    }


}
