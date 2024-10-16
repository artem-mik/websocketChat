package com.ziphiro.websocketChat.service;

import com.ziphiro.websocketChat.entity.ChatRoom;

public interface ChatRoomService {

    ChatRoom createRoom(String roomName);
    ChatRoom getRoom (Long roomId);
    void addUserToRoom(Long roomId, String userName);
    void deleteUserFromRoom(Long roomId, String userName);
}
