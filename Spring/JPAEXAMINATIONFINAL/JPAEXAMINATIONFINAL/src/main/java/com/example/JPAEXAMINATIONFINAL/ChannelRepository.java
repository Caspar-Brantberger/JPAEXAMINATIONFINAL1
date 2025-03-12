package com.example.JPAEXAMINATIONFINAL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
Optional<Channel> findById(Long id);

@Query("SELECT c from Channel c LEFT JOIN FETCH c.messages WHERE c.id = :id")
Optional<Channel> findByIdWithMessages(@Param("id") Long id);
}
