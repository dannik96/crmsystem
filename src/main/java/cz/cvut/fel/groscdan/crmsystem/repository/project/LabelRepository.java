package cz.cvut.fel.groscdan.crmsystem.repository.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Long> {
}