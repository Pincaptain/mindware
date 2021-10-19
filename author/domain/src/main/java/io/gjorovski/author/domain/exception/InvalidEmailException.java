package io.gjorovski.author.domain.exception;

import io.gjorovski.author.domain.util.Violation;
import lombok.Getter;

import java.util.List;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 16/10/2021 - 6:07 PM
 * @project mindware
 */
@Getter
public class InvalidEmailException extends RuntimeException {

    private final List<Violation> violations;

    public InvalidEmailException(List<Violation> violations) {
        super(violations.get(0).getMessage());

        this.violations = violations;
    }
}
