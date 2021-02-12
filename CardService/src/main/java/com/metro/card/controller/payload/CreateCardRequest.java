package com.metro.card.controller.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CreateCardRequest {

    @ApiModelProperty(name = "Name of the Customer", value = "Jhone X")
    private String name;
    @ApiModelProperty(name = "National ID card number", value = "256655441144")
    private String idNumber;
    @ApiModelProperty(name = "Secret Key")
    private String pin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
