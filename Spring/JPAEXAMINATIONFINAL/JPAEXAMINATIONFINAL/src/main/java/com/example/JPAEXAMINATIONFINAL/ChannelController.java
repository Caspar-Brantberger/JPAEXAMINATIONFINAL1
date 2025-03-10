package com.example.JPAEXAMINATIONFINAL;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List <Channel> getChannelById(Long id) {
        return channelService.getChannel();
    }

    @PostMapping
    public ResponseEntity<Channel> createChannelByRequest(@Valid @RequestBody Channel channel) {

        Channel result = channelService.addChannel(channel);

        return ResponseEntity.ok(result);
    }

    @PutMapping("/add")
    public ResponseEntity<Channel> addMessageToChannel(Channel channel,long id) {
        Channel newChannel = channelService.addMessageToChannel(channel,id);
        return ResponseEntity.ok(newChannel);
    }

    @PutMapping("/update")
    public ResponseEntity<Channel> updateMessageFromChannel(@Valid @RequestBody Channel newChannel){

        Channel channel = channelService.updateChannelMessage(newChannel);

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
