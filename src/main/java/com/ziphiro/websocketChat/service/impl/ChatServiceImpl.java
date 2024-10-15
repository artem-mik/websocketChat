package com.ziphiro.websocketChat.service.impl;

import com.ziphiro.websocketChat.entity.ChatMessage;
import com.ziphiro.websocketChat.repository.ChatMessageRepository;
import com.ziphiro.websocketChat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatMessageRepository repository;

    @Override
    public ChatMessage saveMessage(String username, String content) {
        ChatMessage message = ChatMessage.builder()
                .username(username)
                .content(content)
                .timestamp(LocalDateTime.now()).build();
        return repository.save(message);
    }

    @Override
    public List<ChatMessage> getChatHistory() {
        return repository.findAll();
    }
}
