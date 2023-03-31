package cz.cvut.fel.groscdan.crmsystem.repository.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.TaskState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStateRepository extends JpaRepository<TaskState, Long> {
}