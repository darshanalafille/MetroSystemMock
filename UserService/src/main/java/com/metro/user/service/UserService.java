package com.metro.user.service;

import com.metro.user.controller.payload.AuthReq;
import com.metro.user.controller.payload.AuthResp;
import com.metro.util.dto.UserCreationReq;
import com.metro.util.dto.UserCreationResp;
import com.metro.user.entiry.UserEntity;
import com.metro.user.repo.UserRepository;
import com.metro.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper mapper;

    public Optional<UserCreationResp> createUser(UserCreationReq req){
        UserEntity user = userRepository.save(mapper.getEntity(req));
        UserCreationResp resp = mapper.getUserResponseEntiry(user);
        resp.setStatus(true);
        resp.setFailReasons(new ArrayList<>());
        return Optional.of(resp);
    }

    public Optional<AuthResp> login(AuthReq authReq){
        var op = userRepository.findByIdNumberAndPin(authReq.getIdNumber(),authReq.getPin());
        AuthResp authResp = new AuthResp();
        if(op.isPresent()){
            authResp.setToken(JWTUtils.generateToken(op.get().getUserId(),op.get().getIdNumber()));
            authResp.setUser(mapper.getUserResponseEntiry(op.get()));
            authResp.setStatus(true);
        }else {
            authResp.setStatus(false);
            authResp.setFailReasons(List.of("Wrong pin or id"));
        }
        return Optional.of(authResp);
    }

}
