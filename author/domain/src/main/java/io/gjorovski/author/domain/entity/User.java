package io.gjorovski.author.domain.entity;

import io.gjorovski.author.domain.exception.InvalidEmailException;
import io.gjorovski.author.domain.util.BeanValidatable;
import io.gjorovski.author.domain.util.ExtendedStringUtils;
import io.gjorovski.author.domain.util.ListUtils;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 14/10/2021 - 1:57 PM
 * @project mindware
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
public class User extends BeanValidatable<User> {

    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
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

    /**
     * Activates the user and verifies its email.
     */
    public void activate() {
        if (isInvalid()) {
            throw new InvalidEmailException(validate());
        }

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
