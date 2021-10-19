package io.gjorovski.author.domain.util;

import java.util.List;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 16/10/2021 - 5:05 PM
 * @project mindware
 */
public abstract class Validatable {

    public abstract List<Violation> validate();

    public boolean isValid() {
        return validate().isEmpty();
    }

    public boolean isInvalid() {
        return !isValid();
    }
}
