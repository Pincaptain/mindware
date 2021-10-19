package io.gjorovski.noteit.service;

import io.gjorovski.noteit.dto.NoteDto;
import io.gjorovski.noteit.model.Note;

import java.util.List;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 08/10/2021 - 10:57 PM
 * @project mindware
 */
public interface NoteService {

    List<Note> getNotes();

    Note getNoteById(long id);

    Note createNote(NoteDto noteDto);

    void deleteNote(long id);

    Note updateNote(long id, NoteDto noteDto);
}
