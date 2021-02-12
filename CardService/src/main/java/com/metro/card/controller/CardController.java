package com.metro.card.controller;

import com.metro.card.controller.payload.CreateCardRequest;
import com.metro.card.controller.payload.CreateCardResponse;
import com.metro.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/api/issueCard")
    public ResponseEntity<CreateCardResponse> issueCard(@RequestBody CreateCardRequest request){
        return cardService.createCard(request).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
