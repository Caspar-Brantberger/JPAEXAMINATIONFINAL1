package com.example.JPAEXAMINATIONFINAL;

import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/channel")
@RestController
public class ChannelController {

    ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping
    public List<Channel> getAllChannels() {
        return channelService.getChannel();
    }
    @GetMapping("/{id}")
    public ResponseEntity <Channel> getChannelAllMessagesWithId(@PathVariable Long id) {
        Channel channel = channelService.getAllMessagesFromChannel(id);

        return ResponseEntity.ok(channel);
    }

    @PostMapping
    public ResponseEntity<Channel> createChannelByRequest(@Valid @RequestBody Channel channel) {

        Channel result = channelService.addChannel(channel);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public void deleteChannel(@PathVariable Long id) {
        channelService.deleteChannel(id);
    }


}
