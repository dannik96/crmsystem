package cz.cvut.fel.groscdan.crmsystem.model.channel;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "data")
public class Data extends AbstractEntity {
    @Column
    private String location;

    @Column
    private String type;

    @ManyToMany
    private List<Post> posts;
}