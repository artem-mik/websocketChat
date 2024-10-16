package com.ziphiro.websocketChat.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "chat_rooms")
public class ChatRoom {

    @Id
    @SequenceGenerator(name = "chat_rooms_sequence", sequenceName = "chat_rooms_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_rooms_sequence")
    @Column(name = "chat_room_id")
    private Long id;

    private String name;
    private Set<String> users;
}
