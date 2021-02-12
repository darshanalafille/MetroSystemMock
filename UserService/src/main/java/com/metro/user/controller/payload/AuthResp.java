package com.metro.user.controller.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.metro.util.dto.MetroResponse;
import com.metro.util.dto.UserCreationResp;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResp extends MetroResponse {

    @JsonProperty("user")
    private UserCreationResp user;
    @JsonProperty("token")
    private String token;

    public UserCreationResp getUser() {
        return user;
    }

    public void setUser(UserCreationResp user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
