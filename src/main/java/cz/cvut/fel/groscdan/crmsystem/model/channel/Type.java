package cz.cvut.fel.groscdan.crmsystem.model.channel;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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