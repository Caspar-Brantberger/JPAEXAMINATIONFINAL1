package com.example.JPAEXAMINATIONFINAL;

import jakarta.validation.Valid;
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
    public Optional<Channel> getChannelById(@PathVariable Long id) {
        Optional<Channel> channel = channelService.getChannelById(id);

        return channelService.getChannelById(id);
    }

    @PostMapping
    public ResponseEntity<Channel> createChannelByRequest(@Valid @RequestBody Channel channel) {

        Channel result = channelService.addChannel(channel);

        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}/add")
    public ResponseEntity<Channel> addMessageToChannel(Channel newchannel) {
        Channel newChannel = channelService.addChannelMessage(newchannel);
        return ResponseEntity.ok(newChannel);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Channel> updateMessageFromChannel(@Valid @RequestBody Channel newChannel){

        Channel channel = channelService.updateMessageToChannel(newChannel);

        if (channel != null) {
            return ResponseEntity.accepted().body(newChannel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteChannel(@PathVariable Long id) {
        channelService.deleteChannel(id);
    }

    @DeleteMapping("/{messageId}/message")
    public void deleteMessageFromChannel(@PathVariable Long messageId) {
        channelService.deleteMessageFromChannel(messageId);
    }

}
