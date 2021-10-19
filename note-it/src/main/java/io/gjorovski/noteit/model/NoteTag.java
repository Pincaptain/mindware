package io.gjorovski.noteit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 08/10/2021 - 10:07 PM
 * @project mindware
 */
@Entity
@Table(name = "note_tag", schema = "public")
@Data
@NoArgsConstructor
public class NoteTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String value;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Note> notes = new ArrayList<>();

    public static NoteTag withNote(String value, Note note) {
        NoteTag noteTag = new NoteTag();
        noteTag.setValue(value);
        noteTag.setNotes(List.of(note));

        return noteTag;
    }
}
