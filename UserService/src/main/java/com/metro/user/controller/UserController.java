package com.metro.user.controller;

import com.metro.user.controller.payload.AuthReq;
import com.metro.user.controller.payload.AuthResp;
import com.metro.util.dto.UserCreationReq;
import com.metro.util.dto.UserCreationResp;
import com.metro.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/public/createUser")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Success",response = UserCreationResp.class),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ApiOperation(value = "User this service to crete new user")
    public ResponseEntity<UserCreationResp> creteUser(UserCreationReq req){
        return userService.createUser(req).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/public/login")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Success",response = AuthResp.class),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ApiOperation(value = "Login")
    public ResponseEntity<AuthResp> login(AuthReq req){
        return userService.login(req).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
