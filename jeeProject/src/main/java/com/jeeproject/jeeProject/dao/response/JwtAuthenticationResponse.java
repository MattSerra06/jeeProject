
package com.jeeproject.jeeProject.dao.response;

import com.jeeproject.jeeProject.models.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtAuthenticationResponse {
    private String token;
    private String firstName;
    private String lastName;
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public JwtAuthenticationResponse(String token, String firstName, String lastName, Role role) {
        this.token = token;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public JwtAuthenticationResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
