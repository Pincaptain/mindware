package io.gjorovski.author.domain.entity;

import io.gjorovski.author.domain.util.ExtendedStringUtils;
import io.gjorovski.author.domain.util.ListUtils;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 14/10/2021 - 1:57 PM
 * @project mindware
 */
@Data
@Builder
public class User {

    private Long id;
    private String username;
    private String password;
    private Email email;
    private String firstName = ExtendedStringUtils.empty();
    private String lastName = ExtendedStringUtils.empty();
    private List<Role> roles = ListUtils.empty();
    private Boolean isActive;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public User(String username, String password, Email email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void activate() {
        isActive = true;

        email.verify();
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
    }
}
