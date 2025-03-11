package com.example.JPAEXAMINATIONFINAL;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Channel> getChannelById(Long id) {
        return repo.findById((long) Math.toIntExact(id));
    }
    public void deleteChannel(Long id) {
        repo.deleteById((long) Math.toIntExact(id));
    }

    public void deleteMessageFromChannel(long messageId) {
        repo.deleteById((long) messageId);
    }
    public Channel updateMessageToChannel(Channel newChannel) {

        return repo.findById((long) Math.toIntExact(newChannel.getId())).map(channel -> {
            channel.setMessage(newChannel.getMessage());
            return repo.save(channel);
        }).orElse(null);
    }
    public Channel addChannelMessage(Channel newChannel) {
        em.clear();
        addChannel(newChannel);
        return repo.save(newChannel);
    }
    public Channel getAllMessagesFromChannel(Long id) {
        return repo.findByIdWithMessages(id).orElse(null);
    }



}
