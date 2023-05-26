package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Comment;
import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import cz.cvut.fel.groscdan.crmsystem.model.project.Task;
import cz.cvut.fel.groscdan.crmsystem.repository.project.CommentRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import cz.cvut.fel.groscdan.crmsystem.util.UserToPersonMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends AbstractService<CommentRepository, Comment> {

    private final UserToPersonMapper userToPersonMapper;

    public CommentService(CommentRepository repository, UserToPersonMapper userToPersonMapper) {
        super(repository, "Comment");
        this.userToPersonMapper = userToPersonMapper;
    }

    @Override
    public Comment create(Comment record) {
        Comment comment = super.create(record);
        Person person = userToPersonMapper.getOneById(record.getPerson().getId()).getPerson();
        comment.setPerson(person);
        return repository.saveAndFlush(comment);
    }

    @Override
    protected Comment updateExisting(Comment existingRecord, Comment record) {
        return null;
    }

    public List<Comment> findAllByTask(Task task) {
        return repository.findAllByTask(task);
    }
}
