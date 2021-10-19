package io.gjorovski.noteit.controller;

import io.gjorovski.noteit.dto.NoteDto;
import io.gjorovski.noteit.model.Note;
import io.gjorovski.noteit.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 08/10/2021 - 10:58 PM
 * @project mindware
 */
@RestController
@CrossOrigin
@RequestMapping("noteit/api/v1/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping(produces = "application/json")
    public List<Note> getNotes() {
        return noteService.getNotes();
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public Note getNote(@PathVariable long id) {
        return noteService.getNoteById(id);
    }

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Note createNote(@RequestBody @Valid NoteDto noteDto) {
        return noteService.createNote(noteDto);
    }

    @DeleteMapping(value = "{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNote(@PathVariable long id) {
        noteService.deleteNote(id);
    }

    @PutMapping(value = "{id}", produces = "application/json")
    public Note updateNote(@PathVariable long id, @RequestBody @Valid NoteDto noteDto) {
        return noteService.updateNote(id, noteDto);
    }
}
