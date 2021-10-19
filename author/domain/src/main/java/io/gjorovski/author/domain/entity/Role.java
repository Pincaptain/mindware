package io.gjorovski.author.domain.entity;

import lombok.*;

/**
 * @author Borjan Gjorovski
 * @version 1.0
 * @created 14/10/2021 - 2:11 PM
 * @project mindware
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Role {

    private Long id;
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
