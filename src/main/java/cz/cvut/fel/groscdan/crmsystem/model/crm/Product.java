package cz.cvut.fel.groscdan.crmsystem.model.crm;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import cz.cvut.fel.groscdan.crmsystem.model.event.Event;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Integer price;

    @ManyToMany
    private List<Event> events;

    @ManyToMany
    @JoinTable(
            name = "product_customer",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customers;

    @ManyToMany
    private List<Project> projects;



}