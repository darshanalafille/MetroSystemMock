package com.metro.util.dto;

import java.util.List;

public class MetroResponse {

    private Boolean status;
    private List<String> failReasons;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<String> getFailReasons() {
        return failReasons;
    }

    public void setFailReasons(List<String> failReasons) {
        this.failReasons = failReasons;
    }
}
