package com.jeeproject.jeeProject.services;

import com.jeeproject.jeeProject.dao.request.SignInRequest;
import com.jeeproject.jeeProject.dao.request.SignUpRequest;
import com.jeeproject.jeeProject.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}
