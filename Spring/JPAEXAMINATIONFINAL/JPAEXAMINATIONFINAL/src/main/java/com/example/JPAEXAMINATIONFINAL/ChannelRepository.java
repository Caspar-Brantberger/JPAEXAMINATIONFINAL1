package com.example.JPAEXAMINATIONFINAL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {
Optional<Channel> findByChannelName(String channelName);

}
