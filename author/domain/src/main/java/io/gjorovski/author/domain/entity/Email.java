package io.gjorovski.author.domain.entity;

import io.gjorovski.author.domain.exception.InvalidEmailException;
import io.gjorovski.author.domain.util.BeanValidatable;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 14/10/2021 - 2:09 PM
 * @project mindware
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Email extends BeanValidatable<Email> {

    private Long id;
    @NotNull
    private String value;
    private Boolean isVerified;
    private LocalDateTime verifiedAt;

    public Email(String value) {
        this.value = value;
    }

    public Email(long id, String value) {
        this.id = id;
        this.value = value;
    }

    /**
     * Verifies the email and sets the verified time to the current time.
     */
    public void verify() {
        if (isInvalid()) {
            throw new InvalidEmailException(validate());
        }

        isVerified = true;
        verifiedAt = LocalDateTime.now();
    }
}
