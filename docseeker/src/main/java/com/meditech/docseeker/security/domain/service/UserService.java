package com.meditech.docseeker.security.domain.service;


import com.meditech.docseeker.healing.domain.model.entity.New;
import com.meditech.docseeker.security.domain.model.entity.User;
import com.meditech.docseeker.security.domain.service.communication.AuthenticateRequest;
import com.meditech.docseeker.security.domain.service.communication.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    ResponseEntity<?> authenticate(AuthenticateRequest request);

    ResponseEntity<?> register(RegisterRequest request);

    List<User> getAll();

    Boolean createNew(New _new, User user);

}