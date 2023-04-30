package cz.cvut.fel.groscdan.crmsystem.model.channel;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import javax.persistence.*;


import java.util.List;
import java.util.Set;

@Entity
@Table(name = "audience")
public class Audience extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany
    private Set<Channel> channels;

    @ManyToMany
    @JoinTable(
            name = "audience_customer",
            joinColumns = @JoinColumn(name = "audience_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Audience> customers;
}