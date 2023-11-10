
package com.jeeproject.jeeProject.dao.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtAuthenticationResponse {
    private String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public JwtAuthenticationResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
