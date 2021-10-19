package io.gjorovski.noteit.mapper;

import io.gjorovski.noteit.dto.NoteDto;
import io.gjorovski.noteit.model.Note;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 09/10/2021 - 1:07 AM
 * @project mindware
 */
public interface NoteMapper {

    Note noteDtoToNote(NoteDto noteDto);

    Note updateNoteFromNoteDto(Note note, NoteDto noteDto);
}
