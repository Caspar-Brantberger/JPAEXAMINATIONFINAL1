package com.example.JPAEXAMINATIONFINAL;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String message;

    @ManyToOne
    @JoinColumn(name = "channel_id",nullable = false)
    @Getter
    @Setter
    @JsonBackReference
    private Channel channel;

    public Message(String message, Channel channel) {
        this.message = message;
        this.channel = channel;
    }

    public Message(){
    }
}
