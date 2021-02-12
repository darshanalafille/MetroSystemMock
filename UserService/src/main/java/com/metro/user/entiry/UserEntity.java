package com.metro.user.entiry;

import javax.persistence.*;

@Entity
@Table(name = "TBL_USER")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long userId;
    private String name;
    @Column(unique = true)
    private String idNumber;
    private String pin;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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
