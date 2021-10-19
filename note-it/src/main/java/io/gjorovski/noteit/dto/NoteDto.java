package io.gjorovski.noteit.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 09/10/2021 - 12:40 AM
 * @project mindware
 */
@Data
@NoArgsConstructor
public class NoteDto {

    private String title;

    @NotBlank
    private String content;

    private String tags;
}
