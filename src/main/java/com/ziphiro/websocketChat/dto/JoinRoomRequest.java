package com.ziphiro.websocketChat.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JoinRoomRequest {

    private Long roomId;
    private String userName;

}
