package models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
    public MessageType type;
    public int status;
    public String message;

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public enum MessageType {
        ERROR,
        INFO,
        SUCCESSFUL,
        NOT_FOUND,
        UNAUTHORIZED,
        BAD_REQUEST,
        FORBIDDEN,
        INTERNAL_SERVER_ERROR
    }

    public Message() {
    }

    public Message(int status, String message, MessageType type) {
        this.message = message;
        this.status = status;
        this.type = type;
    }
}

