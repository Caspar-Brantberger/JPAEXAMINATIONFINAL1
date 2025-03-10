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

    public ChannelService( ChannelRepository repo, EntityManager em) {
        this.repo = repo;
        this.em = em;
    }

    public Channel addChannel(Channel c) {
        em.clear();

        return repo.save(c);
    }
    public List<Channel> getChannel() {
        List<Channel> channels = repo.findAll();
        return channels;
    }
    public void deleteChannel(Long id) {
        repo.deleteById(id);
    }

    public void deleteMessageFromChannel(Long id,String message) {
        repo.deleteById(id);
    }
    public Channel addMessageToChannel(Channel c,long id,String message) {
        em.clear();
        return repo.save(c);
    }
    public Channel updateChannelMessage(Channel newChannel) {
        return repo.save(newChannel);
    }
    public List<Channel> getAllMessagesFromChannel(Long id) {
        List<Channel> channels = repo.findAll();
        return channels;
    }



}
