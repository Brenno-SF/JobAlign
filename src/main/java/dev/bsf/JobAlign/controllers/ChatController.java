package dev.bsf.JobAlign.controllers;

import dev.bsf.JobAlign.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateContent(){
        return chatService.generateContent()
                .map(card -> ResponseEntity.ok(card))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
