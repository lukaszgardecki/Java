package com.example.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;
    private String time;

    public enum MessageType {
        CHAT, // for normal messaged
        JOIN, // for when a user joins the chat
        LEAVE // for when a user leaves the chat
    }

}
