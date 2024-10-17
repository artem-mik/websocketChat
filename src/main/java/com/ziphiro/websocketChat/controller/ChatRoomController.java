package com.ziphiro.websocketChat.controller;

import com.ziphiro.websocketChat.dto.JoinRoomRequest;
import com.ziphiro.websocketChat.entity.ChatRoom;
import com.ziphiro.websocketChat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @MessageMapping("/createRoom")
    @SendTo("/topic/rooms")
    public ChatRoom createRoom (String roomName){
        return chatRoomService.createRoom(roomName);
    }

    @MessageMapping("/getRooms")
    @SendTo("/topic/rooms")
    public List<ChatRoom> getRooms() {
        return chatRoomService.getAllRooms();  // Возвращаем список всех комнат
    }

    @MessageMapping("/joinRoom")
    @SendTo("/topic/rooms/{roomId}")
    public String joinRoom (JoinRoomRequest request){
        Long roomId = request.getRoomId();
        String userName = request.getUserName();
        chatRoomService.addUserToRoom(roomId, userName);
        return userName + " joined to room: " + chatRoomService.getRoom(roomId).getName();
    }
}
