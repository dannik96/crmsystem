package cz.cvut.fel.groscdan.crmsystem.model.crm;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "purchase_detail")
@Getter
@Setter
public class PurchaseDetail extends AbstractEntity {

    @ManyToOne
    private Product product;

    @ManyToOne
    private Purchase purchase;

    @Column
    private Integer price;

    @Column
    private Integer count;

}