package cz.cvut.fel.groscdan.crmsystem.model.crm;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractState;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "source")
public class Source extends AbstractState {
}