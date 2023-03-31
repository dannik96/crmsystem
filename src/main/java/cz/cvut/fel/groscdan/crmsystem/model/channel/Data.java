package cz.cvut.fel.groscdan.crmsystem.model.channel;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import javax.persistence.*;


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