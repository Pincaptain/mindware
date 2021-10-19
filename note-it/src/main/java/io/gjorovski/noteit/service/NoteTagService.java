package io.gjorovski.noteit.service;

import io.gjorovski.noteit.model.NoteTag;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 09/10/2021 - 3:12 AM
 * @project mindware
 */
public interface NoteTagService {

    NoteTag getOrCreateNoteTag(NoteTag noteTag);
}
