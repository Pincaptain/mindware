package io.gjorovski.noteit.repository;

import io.gjorovski.noteit.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 08/10/2021 - 10:56 PM
 * @project mindware
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
