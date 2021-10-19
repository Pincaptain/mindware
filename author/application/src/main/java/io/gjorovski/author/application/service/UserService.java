package io.gjorovski.author.application.service;

import io.gjorovski.author.domain.entity.Email;
import io.gjorovski.author.domain.entity.User;
import io.gjorovski.author.domain.entity.EmailVerification;
import org.springframework.stereotype.Service;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 16/10/2021 - 4:51 PM
 * @project mindware
 */
@Service
public class UserService {

    public void createUser() {
        User user = new User("", "", new Email(""));
        EmailVerification verification = new EmailVerification(user);
    }
}
