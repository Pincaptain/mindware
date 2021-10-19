package io.gjorovski.noteit.repository;

import io.gjorovski.noteit.model.NoteTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 09/10/2021 - 3:11 AM
 * @project mindware
 */
public interface NoteTagRepository extends JpaRepository<NoteTag, Long> {

    Optional<NoteTag> findFirstByValue(String value);
}
