package cz.cvut.fel.groscdan.crmsystem.controller.project;


import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.PersonMapper;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.*;
import cz.cvut.fel.groscdan.crmsystem.model.project.*;
import cz.cvut.fel.groscdan.crmsystem.service.project.TaskService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/task")
public class TaskController{

    private final TaskService taskService;
    private final TaskMapper taskMapper = Mappers.getMapper(TaskMapper.class);
    private final LabelMapper labelMapper = Mappers.getMapper(LabelMapper.class);
    private final TimeSpentMapper timeSpentMapper = Mappers.getMapper(TimeSpentMapper.class);
    private final TaskStateMapper taskStateMapper = Mappers.getMapper(TaskStateMapper.class);
    private final CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);
    private final PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);



    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAll() {
        List<Task> tasks = taskService.getAll();
        return new ResponseEntity<>(tasks.stream().map(taskMapper::taskToTaskDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> get(@PathVariable Long id) {
        Task task = taskService.getOneById(id);
        return new ResponseEntity<>(taskMapper.taskToTaskDto(task), HttpStatus.OK);
    }

    // TODO need to map Person to User to set createdBy
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {

        Task task = taskMapper.taskDtoToTask(taskDto);
        task = taskService.create(task);
        taskDto = taskMapper.taskToTaskDto(task);
        return new ResponseEntity<>(taskDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto typeDto) {
        Task task = taskMapper.taskDtoToTask(typeDto);
        task = taskService.update(task);
        return new ResponseEntity<>(taskMapper.taskToTaskDto(task), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) throws DeleteError {
        taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PatchMapping("/{taskId}/add-label/{labelId}")
    public ResponseEntity<?> addChannelAudience(@PathVariable Long taskId, @PathVariable Long labelId) {
        taskService.addLabel(taskId, labelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{taskId}/remove-label/{labelId}")
    public ResponseEntity<?> removeChannelAudience(@PathVariable Long taskId, @PathVariable Long labelId) {
        taskService.removeLabel(taskId, labelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/labels")
    public ResponseEntity<?> getTaskLabels(@PathVariable Long id) {
        Set<Label> posts = taskService.getAllLabels(id);
        return new ResponseEntity<>(labelMapper.labelToLabelDto(posts), HttpStatus.OK);
    }

    @PatchMapping("/{taskId}/set-state/{stateId}")
    public ResponseEntity<?> setState(@PathVariable Long taskId, @PathVariable Long stateId) {
        taskService.setState(taskId, stateId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/state")
    public ResponseEntity<?> getTaskState(@PathVariable Long id) {
        TaskState state = taskService.getState(id);
        return new ResponseEntity<>(taskStateMapper.taskStateToTaskStateDto(state), HttpStatus.OK);
    }

    @GetMapping("/{id}/spent-time")
    public ResponseEntity<?> getTaskTimeSpent(@PathVariable Long id) {
        List<TimeSpent> timeSpent = taskService.getTimeSpent(id);
        return new ResponseEntity<>(timeSpentMapper.timeSpentToTimeSpentDto(timeSpent), HttpStatus.OK);
    }

    @PatchMapping("/{taskId}/add-post/{postId}")
    public ResponseEntity<?> addPost(@PathVariable Long taskId, @PathVariable Long postId) {
        taskService.addPost(taskId, postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{taskId}/remove-post/{postId}")
    public ResponseEntity<?> removePost(@PathVariable Long taskId, @PathVariable Long postId) {
        taskService.removePost(taskId, postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // comments
    @GetMapping("/{taskId}/comments")
    public ResponseEntity<?> getTaskComments(@PathVariable Long taskId) {
        List<Comment> timeSpent = taskService.getTaskComments(taskId);
        return new ResponseEntity<>(commentMapper.commentToCommentDto(timeSpent), HttpStatus.OK);
    }

    // assignee
    @GetMapping("/{taskId}/assignee")
    public ResponseEntity<?> getTaskAssignee(@PathVariable Long taskId) {
        Person person = taskService.getAssignee(taskId);
        return new ResponseEntity<>(personMapper.personToPersonDto(person), HttpStatus.OK);
    }

    @PatchMapping("/{taskId}/assignee/{assigneeId}")
    public ResponseEntity<?> setTaskAssignee(@PathVariable Long taskId, @PathVariable Long assigneeId) {
        taskService.setAssignee(taskId, assigneeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // project
    @PatchMapping("/{taskId}/set-project/{projectId}")
    public ResponseEntity<?> setProject(@PathVariable Long taskId, @PathVariable Long projectId) {
        taskService.setProject(taskId, projectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
