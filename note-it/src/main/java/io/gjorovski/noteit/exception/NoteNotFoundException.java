package io.gjorovski.noteit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 09/10/2021 - 12:07 AM
 * @project mindware
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoteNotFoundException extends RuntimeException {

    public NoteNotFoundException(long id) {
        super(String.format("User with id(%d) was not found.", id));
    }
}
