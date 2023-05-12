package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.PatchError;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import cz.cvut.fel.groscdan.crmsystem.model.project.*;
import cz.cvut.fel.groscdan.crmsystem.repository.project.*;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import cz.cvut.fel.groscdan.crmsystem.service.channel.PostService;
import cz.cvut.fel.groscdan.crmsystem.service.channel.ChannelService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Service
public class TaskService extends AbstractService<TaskRepository, Task> {

    private final TaskLabelService taskLabelService;
    private final TaskStateService taskStateService;
    private final TimeSpentService timeSpentService;
    private final PostService postService;
    private final CommentService commentService;
    private final PersonService personService;
    private final ProjectService projectService;
    private final ChannelService channelService;

    public TaskService(TaskRepository repository, TaskLabelService taskLabelService, TaskStateService taskStateService, TimeSpentService timeSpentService, PostService postService, CommentService commentService, PersonService personService, ProjectService projectService, ChannelService channelService) {
        super(repository, "Task");
        this.taskLabelService = taskLabelService;
        this.taskStateService = taskStateService;
        this.timeSpentService = timeSpentService;
        this.postService = postService;
        this.commentService = commentService;
        this.personService = personService;
        this.projectService = projectService;
        this.channelService = channelService;
    }

    @Override
    protected Task updateExisting(Task existingRecord, Task record) {
        // TODO
        return null;
    }

    public void addLabel(Long taskId, Long labelId) {
        TaskLabel taskLabel = taskLabelService.getOneById(labelId, new PatchError());
        Task task = getOneById(taskId, new PatchError());

        task.addLabel(taskLabel);

        repository.saveAndFlush(task);
    }

    public void removeLabel(Long taskId, Long labelId) {
        TaskLabel taskLabel = taskLabelService.getOneById(labelId, new PatchError());
        Task task = getOneById(taskId, new PatchError());

        task.removeLabel(taskLabel);

        repository.saveAndFlush(task);
    }

    public Set<TaskLabel> getAllLabels(Long id) {
        Task task = getOneById(id);
        return task.getTaskLabels();
    }

    public void setState(Long taskId, Long stateId) {
        Task task = getOneById(taskId, new PatchError());
        TaskState taskState = taskStateService.getOneById(stateId, new PatchError());

        task.setTaskState(taskState);

        repository.saveAndFlush(task);
    }

    public TaskState getState(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Channel with id " + id + " not found."));

        repository.saveAndFlush(task);

        return task.getTaskState();
    }

    public List<TimeSpent> getTimeSpent(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task with id " + id + " does not exists."));
        return timeSpentService.findAllByTask(task);
    }

    public void addPost(Long taskId, Long postId) {
        Task task = getOneById(taskId, new PatchError());
        Post post = postService.getOneById(postId, new PatchError());

        task.addPost(post);

        repository.saveAndFlush(task);
    }

    public void removePost(Long taskId, Long postId) {
        Task task = getOneById(taskId, new PatchError());
        Post post = postService.getOneById(postId, new PatchError());

        task.removePost(post);

        repository.saveAndFlush(task);
    }

    public List<Comment> getTaskComments(Long taskId) {
        Task task = getOneById(taskId);

        return commentService.findAllByTask(task);
    }

    public Person getAssignee(Long taskId) {
        Task task = repository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Task with id " + taskId + " does not exists."));

        return task.getAssignedPerson();
    }

    public void setAssignee(Long taskId, Long assigneeId) {
        Task task = getOneById(taskId, new PatchError());
        Person person = personService.getOneById(assigneeId, new PatchError());
        if (assigneeId != null) {
            person = personService.getOneById(assigneeId, new PatchError());
        }

        task.setAssignedPerson(person);

        repository.saveAndFlush(task);
    }

    public List<Task> getProjectTasks(Long id) {
        Project project = projectService.getOneById(id);

        return repository.getTasksByProject(project);
    }

    public void setProject(Long taskId, Long projectId) {
        Project project = projectService.getOneById(projectId, new PatchError());
        Task task = getOneById(taskId, new PatchError());

        if (task.getProject() != null) {
            task.setProject(project);
            repository.saveAndFlush(task);
        } else {
            throw new PatchError();
        }
    }

    public Set<Post> getTaskPosts(Long taskId) {
        Task task = getOneById(taskId);

        return task.getPosts();
    }
}
