package cz.cvut.fel.groscdan.crmsystem.model.crm;

import cz.cvut.fel.groscdan.crmsystem.model.channel.Audience;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Product;
import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer extends Person {


    @ManyToMany
    private List<Product> products;

    @ManyToMany
    private List<Project> projects;

    @ManyToMany
    private List<Audience> audiences;


}