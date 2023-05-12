package cz.cvut.fel.groscdan.crmsystem.repository.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import cz.cvut.fel.groscdan.crmsystem.model.project.Task;
import cz.cvut.fel.groscdan.crmsystem.model.project.TaskState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> getTasksByProject(Project project);

    List<Task> findByTaskState(TaskState taskState);
}