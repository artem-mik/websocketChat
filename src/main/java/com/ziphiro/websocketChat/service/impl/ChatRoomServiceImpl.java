package com.ziphiro.websocketChat.service.impl;

import com.ziphiro.websocketChat.entity.ChatRoom;
import com.ziphiro.websocketChat.repository.ChatRoomRepository;
import com.ziphiro.websocketChat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ConcurrentHashMap <Long, ChatRoom> rooms = new ConcurrentHashMap<>();

    @Override
    public ChatRoom createRoom(String roomName) {
        return chatRoomRepository.save(ChatRoom.builder().id(null).name(roomName).build());
    }

    @Override
    public ChatRoom getRoom(Long roomId) {
        return chatRoomRepository.findChatRoomById(roomId);
    }

    @Override
    public void addUserToRoom(Long roomId, String userName) {
        getRoom(roomId).getUsers().add(userName);
    }

    @Override
    public void deleteUserFromRoom(Long roomId, String userName) {
        getRoom(roomId).getUsers().remove(userName);
    }

    @Override
    public List<ChatRoom> getAllRooms() {
        return chatRoomRepository.findAll().stream().toList();
    }
}
