package com.example.JPAEXAMINATIONFINAL;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> addMessage(@PathVariable Long id,@RequestBody String newMessage) {
        Message message = messageService.addMessage(id, newMessage);
        return ResponseEntity.ok(message);
    }
}
