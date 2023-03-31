package cz.cvut.fel.groscdan.crmsystem.model.project;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import javax.persistence.*;


@Entity
@Table(name = "comment")
public class Comment extends AbstractEntity {

    @Column
    private String text;

    @ManyToOne
    private Task task;

    @ManyToOne
    @JoinColumn(name = "responded_id", updatable = false)
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Person person;


}