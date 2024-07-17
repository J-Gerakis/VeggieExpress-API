package org.qj.veggieexpress.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Message {
    private String content;
    private Boolean isError = false;

    public Message(String content) {
        this.content = content;
    }

}
