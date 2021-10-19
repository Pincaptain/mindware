package io.gjorovski.noteit.service.impl;

import io.gjorovski.noteit.model.NoteTag;
import io.gjorovski.noteit.repository.NoteTagRepository;
import io.gjorovski.noteit.service.NoteTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 09/10/2021 - 3:13 AM
 * @project mindware
 */
@Service
@RequiredArgsConstructor
public class NoteTagServiceImpl implements NoteTagService {

    private final NoteTagRepository noteTagRepository;

    @Override
    public NoteTag getOrCreateNoteTag(NoteTag noteTag) {
        return noteTagRepository.findFirstByValue(noteTag.getValue())
                .orElseGet(() -> noteTagRepository.save(noteTag));
    }
}
