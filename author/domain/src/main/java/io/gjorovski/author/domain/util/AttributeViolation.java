package io.gjorovski.author.domain.util;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 16/10/2021 - 5:07 PM
 * @project mindware
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class AttributeViolation extends Violation {

    private String attribute;

    public AttributeViolation(String message, String attribute) {
        super(message);

        this.attribute = attribute;
    }

    @Override
    public String getMessage() {
        return String.format("%s: %s", attribute, message);
    }
}
