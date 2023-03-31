package cz.cvut.fel.groscdan.crmsystem.model.event;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Product;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event")
@Getter
@Setter
public class Event extends AbstractEntity {
    @Column
    private String description;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToMany
    @JoinTable(
            name = "product_event",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> tasks;

    @ManyToMany
    @JoinTable(
            name = "event_event_type",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "event_type_id"))
    private List<EventType> eventTypes;


}