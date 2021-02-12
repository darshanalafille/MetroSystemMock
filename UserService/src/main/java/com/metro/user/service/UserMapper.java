package com.metro.user.service;

import com.metro.util.dto.UserCreationReq;
import com.metro.util.dto.UserCreationResp;
import com.metro.user.entiry.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserEntity getEntity(UserCreationReq req){
        UserEntity entity = new UserEntity();
        entity.setIdNumber(req.getIdNumber());
        entity.setName(req.getName());
        entity.setPin(req.getPin());
        return entity;
    }

    public UserCreationResp getUserResponseEntiry(UserEntity entity){
        UserCreationResp resp = new UserCreationResp();
        resp.setUserId(entity.getUserId());
        resp.setId(entity.getIdNumber());
        resp.setName(entity.getName());
        return resp;
    }





}
