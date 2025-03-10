package com.example.JPAEXAMINATIONFINAL;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

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

    @Getter
    @Setter
    private String message;


    @Getter
    @Setter
    private Long messageId;

    public Channel() {
   }

}
