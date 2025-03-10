package com.example.JPAEXAMINATIONFINAL;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @PersistenceContext
    private EntityManager em;

    ChannelRepository repo;

    public ChannelService(EntityManager em, ChannelRepository repo) {
        this.em = em;
        this.repo = repo;
    }
    public Channel addChannel(Channel c) {
         return null;
    }
    public List<Channel> getChannel(Long id) {
        return null;
    }
    public Channel deleteChannel(Long id) {
        return null;
    }
    public Channel addmessage(){
        return null;
    }
    public Channel getAllMessagesFromChannel(Long id) {
        return null;
    }


}
