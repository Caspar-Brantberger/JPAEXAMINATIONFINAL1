package com.example.JPAEXAMINATIONFINAL;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@lombok.Generated
@Entity
@Table( name = "channels")
public class Channel {

    @NotBlank(message = "Channel name cannot be blank")
    @Size(min = 2, max = 20,message = "Channel name must be between 2 and 20 characters")
    private String channelName;

    @NotBlank(message = "Channel descpriction cannot be blank")
    @Size(min = 2, max = 60 , message = "Channel description must be between 2 and 60 characters")
    private String channelDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long messageId;

    public Channel() {
    }

}
