package cz.cvut.fel.groscdan.crmsystem.model.project;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Audience;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Customer;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Product;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "project")
public class Project extends AbstractEntity {

    @Column
    private LocalDateTime deadline;

    @Column
    private String description;

    @Column
    private String name;

    @Column(updatable = false)
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Person person;

    @ManyToMany
    @JoinTable(
            name = "project_audience",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "audience_id"))
    private List<Audience> audiences;

    @ManyToMany
    @JoinTable(
            name = "project_customer",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customers;

    @ManyToMany
    @JoinTable(
            name = "project_product",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

}