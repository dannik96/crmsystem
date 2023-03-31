package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.PatchError;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import cz.cvut.fel.groscdan.crmsystem.model.project.*;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.PostRepository;
import cz.cvut.fel.groscdan.crmsystem.repository.project.*;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TaskService extends AbstractService<TaskRepository, Task> {

    private final LabelRepository labelRepository;
    private final TaskStateRepository taskStateRepository;
    private final TimeSpentRepository timeSpentRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final PersonRepository personRepository;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository repository, LabelRepository labelRepository, TaskStateRepository taskStateRepository, TimeSpentRepository timeSpentRepository, PostRepository postRepository, CommentRepository commentRepository, PersonRepository personRepository, ProjectRepository projectRepository) {
        super(repository);
        this.labelRepository = labelRepository;
        this.taskStateRepository = taskStateRepository;
        this.timeSpentRepository = timeSpentRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.personRepository = personRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    protected Task updateExisting(Task existingRecord, Task record) {
        // TODO
        return null;
    }

    public void addLabel(Long taskId, Long labelId) {
        Label label = labelRepository.findById(labelId).orElseThrow(PatchError::new);
        Task task = repository.findById(taskId).orElseThrow(PatchError::new);

        task.addLabel(label);

        repository.saveAndFlush(task);
    }

    public void removeLabel(Long taskId, Long labelId) {
        Label label = labelRepository.findById(labelId).orElseThrow(() -> new EntityNotFoundException("Channel with id " + labelId + " not found."));
        Task task = repository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Channel with id " + taskId + " not found."));

        task.removeLabel(label);

        repository.saveAndFlush(task);
    }

    public Set<Label> getAllLabels(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Channel with id " + id + " not found."));
        return task.getLabels();
    }

    public void setState(Long taskId, Long stateId) {
        Task task = repository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Channel with id " + taskId + " not found."));
        TaskState taskState = taskStateRepository.findById(stateId).orElseThrow(() -> new EntityNotFoundException("Channel with id " + stateId + " not found."));

        task.setState(taskState);

        repository.saveAndFlush(task);
    }

    public TaskState getState(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Channel with id " + id + " not found."));

        repository.saveAndFlush(task);

        return task.getState();
    }

    public List<TimeSpent> getTimeSpent(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task with id " + id + " does not exists."));
        return timeSpentRepository.findAllByTask(task);
    }

    public void addPost(Long taskId, Long postId) {
        Task task = repository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Task with id " + taskId + " does not exists."));
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post with id " + postId + " does not exists."));

        task.addPost(post);

        repository.saveAndFlush(task);
    }

    public void removePost(Long taskId, Long postId) {
        Task task = repository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Task with id " + taskId + " does not exists."));
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post with id " + postId + " does not exists."));

        task.removePost(post);

        repository.saveAndFlush(task);
    }

    public List<Comment> getTaskComments(Long taskId) {
        Task task = repository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Task with id " + taskId + " does not exists."));

        return commentRepository.findAllByTask(task);
    }

    public Person getAssignee(Long taskId) {
        Task task = repository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Task with id " + taskId + " does not exists."));

        return task.getAssignedPerson();
    }

    public void setAssignee(Long taskId, Long assigneeId) {
        Task task = repository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Task with id " + taskId + " does not exists."));
        Person person = personRepository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Person with id " + taskId + " does not exists."));

        task.setAssignedPerson(person);
    }

    public List<Task> getProjectTasks(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Project with id " + id + " does not exists."));

        return repository.getTasksByProject(project);
    }

    public void setProject(Long taskId, Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new EntityNotFoundException("Project with id " + projectId + " does not exists."));
        Task task = repository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Project with id " + projectId + " does not exists."));

        if (task.getProject() != null) {
            task.setProject(project);
            repository.saveAndFlush(task);
        } else {
            throw new PatchError();
        }
    }
}
