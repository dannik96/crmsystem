package cz.cvut.fel.groscdan.crmsystem.model.channel;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "audience")
public class Audience extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "audiences", fetch = FetchType.LAZY)
    private Set<Channel> channels;

    @ManyToMany
    @JoinTable(
            name = "audience_customer",
            joinColumns = @JoinColumn(name = "audience_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Audience> customers;
}