package io.gjorovski.author.domain.exception;

import io.gjorovski.author.domain.util.Violation;
import lombok.Getter;

import java.util.List;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 19/10/2021 - 2:37 PM
 * @project mindware
 */
@Getter
public class InvalidUserException extends RuntimeException {

    private final List<Violation> violations;

    public InvalidUserException(List<Violation> violations) {
        super(violations.get(0).getMessage());

        this.violations = violations;
    }
}
