package com.stefanini.dto.token;

public class AuthTokenDTO {

    private final String accessToken;

    public AuthTokenDTO(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
