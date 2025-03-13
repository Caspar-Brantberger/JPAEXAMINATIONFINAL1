package com.example.JPAEXAMINATIONFINAL;

import jakarta.transaction.Transactional;
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

    //Funkar inte
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);

    }

    public Message updateMessage(Long id, String newMessage) {
        Message message = messageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Message not found"));
        message.setMessage(newMessage);
        return messageRepository.save(message);
    }
}
