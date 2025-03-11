package com.example.JPAEXAMINATIONFINAL;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    MessageRepository messageRepository;

    ChannelRepository channelRepository;

    public MessageService(MessageRepository messageRepository, ChannelRepository channelRepository) {
        this.messageRepository = messageRepository;
        this.channelRepository = channelRepository;
    }
    public Message addMessage(Long id, String newMessage) {
        Channel channel = channelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Channel not found"));
        Message message = new Message(newMessage, channel);
        channel.add(message);
       return messageRepository.save(message);
    }
    //DeleteMessage

    //UppdateMessage
}
