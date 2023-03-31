package cz.cvut.fel.groscdan.crmsystem.repository.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Task;
import cz.cvut.fel.groscdan.crmsystem.model.project.TimeSpent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TimeSpentRepository extends JpaRepository<TimeSpent, Long> {
    List<TimeSpent> findAllByTask(Task task);
}