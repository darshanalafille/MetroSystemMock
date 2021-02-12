package com.metro.card.controller.payload;

import com.metro.util.dto.UserCreationResp;
import io.swagger.annotations.ApiModel;

@ApiModel
public class CreateCardResponse {

    private Long cardNumber;
    private UserCreationResp user;

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public UserCreationResp getUser() {
        return user;
    }

    public void setUser(UserCreationResp user) {
        this.user = user;
    }
}
