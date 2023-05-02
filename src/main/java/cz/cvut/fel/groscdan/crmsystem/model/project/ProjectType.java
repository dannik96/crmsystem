package cz.cvut.fel.groscdan.crmsystem.model.project;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractState;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "project_type")
public class ProjectType extends AbstractState {
}
