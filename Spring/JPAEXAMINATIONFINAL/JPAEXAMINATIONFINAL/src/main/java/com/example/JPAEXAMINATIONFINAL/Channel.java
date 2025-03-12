package com.example.JPAEXAMINATIONFINAL;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "channels")
public class Channel {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Channel name cannot be blank")
    @Size(min = 2, max = 20,message = "Channel name must be between 2 and 20 characters")
    private String channelName;

    @Getter
    @Setter
    @NotBlank(message = "Channel descpriction cannot be blank")
    @Size(min = 2, max = 60 , message = "Channel description must be between 2 and 60 characters")
    private String channelDescription;


    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Message> messages;


    @Getter
    @Setter
    @NotBlank(message = "Write something fun! Message cannot be blank.")
    private String message;


    public void add(Message message){
        this.messages.add(message);
        message.setChannel(this);
    }
    public Channel() {
   }

}
