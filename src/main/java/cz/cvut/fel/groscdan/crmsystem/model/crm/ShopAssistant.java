package cz.cvut.fel.groscdan.crmsystem.model.crm;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractPerson;
import javax.persistence.*;

import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "shop_assistant")
@RequiredArgsConstructor
public class ShopAssistant extends AbstractPerson {

}