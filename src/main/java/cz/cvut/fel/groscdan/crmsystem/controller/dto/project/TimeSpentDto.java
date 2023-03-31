package cz.cvut.fel.groscdan.crmsystem.controller.dto.project;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.TimeSpent} entity
 */
@Data
public class TimeSpentDto implements Serializable {
    private final Long id;
    private final LocalDate date;
    private final Integer time;
}