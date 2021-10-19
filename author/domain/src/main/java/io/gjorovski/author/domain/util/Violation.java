package io.gjorovski.author.domain.util;

import lombok.*;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 16/10/2021 - 5:06 PM
 * @project mindware
 */
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Violation {

    protected String message;

    public String getMessage() {
        return message;
    }
}
