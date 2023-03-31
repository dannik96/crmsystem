package cz.cvut.fel.groscdan.crmsystem.model.crm;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractPerson;
import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "shop_assistant")
@RequiredArgsConstructor
public class ShopAssistant extends AbstractPerson {

}