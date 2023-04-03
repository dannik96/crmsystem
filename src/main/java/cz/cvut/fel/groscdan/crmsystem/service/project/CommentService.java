package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Comment;
import cz.cvut.fel.groscdan.crmsystem.model.project.Task;
import cz.cvut.fel.groscdan.crmsystem.repository.project.CommentRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends AbstractService<CommentRepository, Comment> {

    public CommentService(CommentRepository repository) {
        super(repository, "Comment");
    }

    @Override
    protected Comment updateExisting(Comment existingRecord, Comment record) {
        return null;
    }

    public List<Comment> findAllByTask(Task task) {
        return repository.findAllByTask(task);
    }
}
