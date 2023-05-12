package cz.cvut.fel.groscdan.crmsystem.repository.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectState;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByProjectState(ProjectState postState);

    List<Project> findByProjectType(ProjectType projectType);
}