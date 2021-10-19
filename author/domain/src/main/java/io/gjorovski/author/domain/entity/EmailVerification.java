package io.gjorovski.author.domain.entity;

import io.gjorovski.author.domain.exception.InvalidEmailVerificationException;
import io.gjorovski.author.domain.util.AttributeViolation;
import io.gjorovski.author.domain.util.BeanValidatable;
import io.gjorovski.author.domain.util.Violation;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 15/10/2021 - 4:12 AM
 * @project mindware
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
public class EmailVerification extends BeanValidatable<EmailVerification> {

    private final int EMAIL_VERIFICATION_LIFESPAN = 10;

    private Long id;
    private String code = UUID.randomUUID().toString();
    private LocalDateTime createdAt = LocalDateTime.now();
    @NotNull
    private User user;

    public EmailVerification(User user) {
        this.user = user;
    }

    public LocalDateTime getExpiresAt() {
        return createdAt.plusMinutes(EMAIL_VERIFICATION_LIFESPAN);
    }

    /**
     * Provides a custom validation that prevents the user from being activated
     * if the email verification expired.
     *
     * @return list of violations including the email verification expired
     */
    @Override
    public List<Violation> validate() {
        List<Violation> violations = super.validate();

        if (getExpiresAt().isBefore(LocalDateTime.now())) {
            violations.add(new Violation("Email verification must not be expired."));
        }

        return violations;
    }

    /**
     * Activates the user that the verification object holds.
     */
    public void verify() {
        if (isInvalid()) {
            throw new InvalidEmailVerificationException(validate());
        }

        user.activate();
    }
}
