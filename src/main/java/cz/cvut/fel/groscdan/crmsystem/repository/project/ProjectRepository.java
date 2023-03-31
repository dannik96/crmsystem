package cz.cvut.fel.groscdan.crmsystem.repository.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}