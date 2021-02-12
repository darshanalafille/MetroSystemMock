package com.metro.card.service;

import com.metro.card.controller.payload.CreateCardRequest;
import com.metro.card.controller.payload.CreateCardResponse;
import com.metro.util.dto.UserCreationReq;
import com.metro.util.dto.UserCreationResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.CacheRequest;
import java.util.Collections;
import java.util.Optional;

@Service
public class CardService {

    @Value("${user.service}")
    String userService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired


    public Optional<CreateCardResponse> createCard(CreateCardRequest request){
        var userOp = createUser(request);
        if(userOp.isPresent()){
            // TODO : persist and retrun
        }
        return Optional.empty();
    }

    private Optional<UserCreationResp> createUser(CreateCardRequest request){
        UserCreationReq userCreationReq = new UserCreationReq();
        userCreationReq.setIdNumber(request.getIdNumber());
        userCreationReq.setName(request.getName());
        userCreationReq.setPin(request.getPin());
        final String url = userService + "/public/createUser";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<UserCreationReq> entity = new HttpEntity<>(userCreationReq,headers);
        ResponseEntity<UserCreationResp> resp = restTemplate.exchange(url, HttpMethod.POST,entity,UserCreationResp.class);
        if(resp.getStatusCodeValue() == 200){
            return Optional.of(resp.getBody());
        }
        return Optional.empty();
    }

}
