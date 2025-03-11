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

    public Channel getAllMessagesFromChannel(Long id) {
        return repo.findByIdWithMessages(id).orElse(null);
    }



}
