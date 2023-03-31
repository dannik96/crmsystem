package cz.cvut.fel.groscdan.crmsystem.model.channel;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "type")
@Getter
@Setter
public class Type extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany
    private List<Channel> channel;
}