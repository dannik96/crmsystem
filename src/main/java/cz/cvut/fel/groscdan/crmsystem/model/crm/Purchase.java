package cz.cvut.fel.groscdan.crmsystem.model.crm;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "purchase")
@Getter
@Setter
public class Purchase extends AbstractEntity {

    @Column
    private LocalDateTime purchaseDate;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shop_assistant_id")
    private ShopAssistant shopAssistant;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private Source source;

}