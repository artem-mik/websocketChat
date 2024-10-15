package com.ziphiro.websocketChat.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "chat_messages")
public class ChatMessage {

    @Id
    @SequenceGenerator(name = "chat_messages_sequence", sequenceName = "chat_messages_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_messages_sequence")
    @Column(name = "chat_message_id")
    private Long id;
    private String username;
    private String content;
    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

}
