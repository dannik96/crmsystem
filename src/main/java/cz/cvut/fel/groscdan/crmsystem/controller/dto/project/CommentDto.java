package cz.cvut.fel.groscdan.crmsystem.controller.dto.project;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Comment} entity
 */
@Data
public class CommentDto implements Serializable {
    private final Long id;
    private final String text;
}