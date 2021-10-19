package io.gjorovski.noteit.mapper.impl;

import io.gjorovski.noteit.dto.NoteDto;
import io.gjorovski.noteit.mapper.NoteMapper;
import io.gjorovski.noteit.model.Note;
import io.gjorovski.noteit.model.NoteTag;
import io.gjorovski.noteit.service.NoteTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 09/10/2021 - 2:27 AM
 * @project mindware
 */
@Component
@RequiredArgsConstructor
public class NoteMapperImpl implements NoteMapper {

    private final NoteTagService noteTagService;

    @Override
    public Note noteDtoToNote(NoteDto noteDto) {
        if (noteDto == null) {
            return null;
        }

        Note note = new Note();

        setContent(note, noteDto.getContent());
        setTitle(note, noteDto.getTitle());
        setTags(note, noteDto.getTags());

        return note;
    }

    @Override
    public Note updateNoteFromNoteDto(Note note, NoteDto noteDto) {
        if (noteDto == null) {
            return note;
        }

        setContent(note, noteDto.getContent());
        setTitle(note, noteDto.getTitle());
        setTags(note, noteDto.getTags());

        return note;
    }

    private void setContent(Note note, String content) {
        note.setContent(content);
    }

    private void setTitle(Note note, String title) {
        if (title != null) {
            note.setTitle(title);
        }
    }

    private void setTags(Note note, String tags) {
        if (tags != null) {
            if (tags.equals("")) {
                note.setTags(new ArrayList<>());
            }

            note.setTags(commaSeparatedTagsToNoteTags(note, tags));
        }
    }

    private List<NoteTag> commaSeparatedTagsToNoteTags(Note note, String commaSeparatedTags) {
        String[] tags = commaSeparatedTags.toLowerCase().replaceAll("\\s", "").split(",");

        return Arrays
                .stream(tags)
                .map(tag -> noteTagService.getOrCreateNoteTag(NoteTag.withNote(tag, note)))
                .collect(Collectors.toList());
    }
}
