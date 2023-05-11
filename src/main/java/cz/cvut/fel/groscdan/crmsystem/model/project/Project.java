package cz.cvut.fel.groscdan.crmsystem.model.project;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Customer;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.support.JpaEvaluationContextExtension;

import javax.persistence.*;


import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "project")
public class Project extends AbstractEntity {

    @Column
    private LocalDateTime deadline;

    @Column
    private LocalDateTime start;

    @Column
    private String description;

    @Column
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Person manager;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ProjectType projectType;

    @ManyToOne
    @JoinColumn(name = "project_state_id")
    private ProjectState projectState;

    @ManyToMany
    @JoinTable(
            name = "project_channel",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private Set<Channel> channels;

    @ManyToMany
    @JoinTable(
            name = "project_customer",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Customer> customers;

    @ManyToMany
    @JoinTable(
            name = "project_product",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    public void removeChannel(Channel channel) {
        channels.remove(channel);
    }

    public void addProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }
}