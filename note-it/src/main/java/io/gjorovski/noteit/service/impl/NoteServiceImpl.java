package io.gjorovski.noteit.service.impl;

import io.gjorovski.noteit.dto.NoteDto;
import io.gjorovski.noteit.exception.NoteNotFoundException;
import io.gjorovski.noteit.mapper.NoteMapper;
import io.gjorovski.noteit.model.Note;
import io.gjorovski.noteit.repository.NoteRepository;
import io.gjorovski.noteit.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 08/10/2021 - 10:57 PM
 * @project mindware
 */
@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    private final NoteMapper noteMapper;

    @Override
    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(long id) {
        return noteRepository
                .findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    @Override
    public Note createNote(NoteDto noteDto) {
        Note note = noteMapper.noteDtoToNote(noteDto);

        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Note updateNote(long id, NoteDto noteDto) {
        Note note = noteMapper.updateNoteFromNoteDto(getNoteById(id), noteDto);

        return noteRepository.save(note);
    }
}
