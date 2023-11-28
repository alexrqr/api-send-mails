package com.api.sendemails.apiEmail.app.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    private String emailUser;
    private String message;
    private String code;

}
