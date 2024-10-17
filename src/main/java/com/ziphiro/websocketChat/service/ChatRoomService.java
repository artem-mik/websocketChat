package com.ziphiro.websocketChat.service;

import com.ziphiro.websocketChat.entity.ChatRoom;

import java.util.List;

public interface ChatRoomService {

    ChatRoom createRoom(String roomName);
    ChatRoom getRoom (Long roomId);
    void addUserToRoom(Long roomId, String userName);
    void deleteUserFromRoom(Long roomId, String userName);
    List<ChatRoom> getAllRooms();
}
