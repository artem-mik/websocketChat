package com.ziphiro.websocketChat.service.impl;

import com.ziphiro.websocketChat.entity.ChatRoom;
import com.ziphiro.websocketChat.service.ChatRoomService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ConcurrentHashMap <Long, ChatRoom> rooms = new ConcurrentHashMap<>();

    @Override
    public ChatRoom createRoom(String roomName) {
        ChatRoom room = ChatRoom.builder().name(roomName).build();
        rooms.put(room.getId(), room);
        return room;
    }

    @Override
    public ChatRoom getRoom(Long roomId) {
        return rooms.get(roomId);
    }

    @Override
    public void addUserToRoom(Long roomId, String userName) {
        getRoom(roomId).getUsers().add(userName);
    }

    @Override
    public void deleteUserFromRoom(Long roomId, String userName) {
        getRoom(roomId).getUsers().remove(userName);
    }
}
