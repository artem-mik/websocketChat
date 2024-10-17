package com.ziphiro.websocketChat.repository;

import com.ziphiro.websocketChat.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    ChatRoom findChatRoomByName(String roomName);
    ChatRoom findChatRoomById(Long roomId);

}
