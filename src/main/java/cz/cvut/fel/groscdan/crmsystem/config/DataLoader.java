package cz.cvut.fel.groscdan.crmsystem.config;

import cz.cvut.fel.groscdan.crmsystem.model.channel.*;
import cz.cvut.fel.groscdan.crmsystem.model.event.Event;
import cz.cvut.fel.groscdan.crmsystem.model.event.EventType;
import cz.cvut.fel.groscdan.crmsystem.model.project.*;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.PostRepository;
import cz.cvut.fel.groscdan.crmsystem.security.model.ERole;
import cz.cvut.fel.groscdan.crmsystem.security.model.User;
import cz.cvut.fel.groscdan.crmsystem.security.model.UserRole;
import cz.cvut.fel.groscdan.crmsystem.security.repository.UserRoleRepository;
import cz.cvut.fel.groscdan.crmsystem.security.service.UserService;
import cz.cvut.fel.groscdan.crmsystem.service.channel.*;
import cz.cvut.fel.groscdan.crmsystem.service.event.EventService;
import cz.cvut.fel.groscdan.crmsystem.service.event.EventTypeService;
import cz.cvut.fel.groscdan.crmsystem.service.project.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
@Log4j2
public class DataLoader implements ApplicationRunner {

    private final PostRepository postRepository;
    private final UserService userService;
    private final PersonService personService;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;
    private final EventTypeService eventTypeService;
    private final ProjectService projectService;
    private final ProjectStateService projectStateService;
    private final PostStateService postStateService;
    private final TaskStateService taskStateService;
    private final ProjectTypeService projectTypeService;
    private final ChannelTypeService channelTypeService;
    private final TaskLabelService taskLabelService;
    private final AudienceService audienceService;
    private final ChannelService channelService;
    private final EventService eventService;
    private final PostService postService;
    private final TaskService taskService;
    User admin;
    User moderator;
    User user;

    @Autowired
    public DataLoader(PostRepository tutorialRepository, UserService userService, PersonService personService, PasswordEncoder passwordEncoder,
                      UserRoleRepository userRoleRepository, EventTypeService eventTypeService, ProjectService projectService,
                      ProjectStateService projectStateService, PostStateService postStateService, TaskStateService taskStateService,
                      ProjectTypeService projectTypeService, ChannelTypeService channelTypeService, TaskLabelService taskLabelService,
                      AudienceService audienceService, ChannelService channelService, EventService eventService, PostService postService,
                      TaskService taskService) {
        this.postRepository = tutorialRepository;
        this.userService = userService;
        this.personService = personService;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
        this.eventTypeService = eventTypeService;
        this.projectService = projectService;
        this.projectStateService = projectStateService;
        this.postStateService = postStateService;
        this.taskStateService = taskStateService;
        this.projectTypeService = projectTypeService;
        this.channelTypeService = channelTypeService;
        this.taskLabelService = taskLabelService;
        this.audienceService = audienceService;
        this.channelService = channelService;
        this.eventService = eventService;
        this.postService = postService;
        this.taskService = taskService;
    }

    public void run(ApplicationArguments args) {
        //postRepository.save(new Post("lala"));

        createUsers();


        Person us = createPerson(user, "John", "Wick", "+420 123 456 789");
        Person mod = createPerson(moderator, "Winston", "Scott", "+420 456 789 123");
        Person ad = createPerson(admin, "Santino", "D'Antonio", "+420 789 123 567");

        List<ProjectState> projectStates = createProjectStates();
        List<PostState> postStates = createPostStates();
        List<TaskState> taskStates = createTaskStates();

        List<ProjectType> projectTypes = createProjectTypes();
        List<TaskLabel> taskLabels = createTaskLabels();
        List<ChannelType> channelChannelTypes = createChannelTypes();
        List<EventType> eventTypes = createEventTypes();

        Project project = createProject(projectStates.get(0), projectTypes, mod);
        List<Event> events = createEvents(eventTypes, project);

        List<Audience> audiences = createAudiences();
        List<Channel> channels = createChannels(audiences, project);
        List<Task> tasks = createTasks(us, mod, taskStates, taskLabels, project);
        List<Post> posts = createPosts(channels, us, postStates, tasks);

    }

    private List<Task> createTasks(Person us, Person mod, List<TaskState> taskStates, List<TaskLabel> taskLabels, Project project) {
        List<Task> tasks = new ArrayList<>();

        Task task = new Task();
        task.setAssignedPerson(mod);
        task.setTaskLabels(new HashSet<>(List.of(taskLabels.get(3), taskLabels.get(2))));
        task.setProject(project);
        task.setName("Review post");
        task.setDeadline(LocalDateTime.of(2023, 6, 20, 11, 0));
        task.setState(taskStates.get(2));
        task.setDescription("Need to review the post for the event.");
        task.setPriority(1);
        task.setCreatedByPerson(mod);
        tasks.add(task);

        task = new Task();
        task.setAssignedPerson(mod);
        task.setTaskLabels(new HashSet<>(List.of(taskLabels.get(1))));
        task.setProject(project);
        task.setName("Write the post");
        task.setDeadline(LocalDateTime.of(2023, 6, 20, 11, 0));
        task.setState(taskStates.get(1));
        task.setDescription("Need to write the post for the event.");
        task.setPriority(1);
        task.setCreatedByPerson(us);
        tasks.add(task);

        task = new Task();
        task.setAssignedPerson(mod);
        task.setTaskLabels(new HashSet<>(List.of(taskLabels.get(3), taskLabels.get(2))));
        task.setProject(project);
        task.setName("Create email response");
        task.setDeadline(LocalDateTime.of(2023, 5, 20, 11, 0));
        task.setState(taskStates.get(0));
        task.setDescription("Create email response for people who appliend for study at CTU.");
        task.setCreatedByPerson(mod);
        task.setPriority(1);
        tasks.add(task);

        task = new Task();
        task.setAssignedPerson(mod);
        task.setTaskLabels(new HashSet<>(List.of(taskLabels.get(0))));
        task.setProject(project);
        task.setName("Create budget");
        task.setDeadline(LocalDateTime.of(2023, 4, 20, 11, 0));
        task.setState(taskStates.get(4));
        task.setDescription("Need to create the budget prediction and planes for spending resources.");
        task.setCreatedByPerson(mod);
        task.setPriority(1);
        tasks.add(task);

        task = new Task();
        task.setAssignedPerson(mod);
        task.setTaskLabels(new HashSet<>(List.of(taskLabels.get(3), taskLabels.get(2))));
        task.setProject(project);
        task.setName("Review the campaign results");
        task.setState(taskStates.get(3));
        task.setDescription("Create review of the campaign result and organise lessons learned.");
        task.setCreatedByPerson(mod);
        task.setPriority(3);
        tasks.add(task);

        return taskService.create(tasks);
    }

    private List<Post> createPosts(List<Channel> channels, Person user, List<PostState> postStates, List<Task> tasks) {
        List<Post> posts = new ArrayList<>();

        Post post = new Post();
        post.setName("Lets study FEE");
        post.setContent("Let's go to study FEE.");
        post.setChannel(List.of(channels.get(0), channels.get(1), channels.get(2)));
        post.setPostState(postStates.get(0));
        post.setAuthor(user);
        post.setTasks(List.of(tasks.get(0), tasks.get(1)));
        post.setPostDate(LocalDateTime.of(2023, 6, 25, 11, 00));
        posts.add(post);

        post = new Post();
        post.setName("Best in the world");
        post.setContent("Wanna be the best in the world? Lets check our programmes.");
        post.setChannel(List.of(channels.get(0), channels.get(1), channels.get(2)));
        post.setPostState(postStates.get(4));
        post.setAuthor(user);
        post.setTasks(List.of(tasks.get(0), tasks.get(1)));
        post.setPostDate(LocalDateTime.of(2023, 5, 25, 11, 00));
        posts.add(post);

        post = new Post();
        post.setName("End of the year");
        post.setContent("The year comes to its end. Let's celebrate together at he school year party.");
        post.setChannel(List.of(channels.get(2)));
        post.setPostState(postStates.get(2));
        post.setAuthor(user);
        post.setPostDate(LocalDateTime.of(2023, 6, 25, 11, 00));
        posts.add(post);


        return postService.create(posts);
    }

    private List<Channel> createChannels(List<Audience> audiences, Project project) {
        List<Channel> channels = new ArrayList<>();

        Channel channel = new Channel();
        channel.setName("Facebook paid");
        channel.setDescription("Paid ads on the Facebook.");
        channel.setLocation("Facebook");
        channel.setAudiences(new HashSet<>(audiences));
        channel.addProject(project);
        channels.add(channel);

        channel = new Channel();
        channel.setName("Instagram paid");
        channel.setDescription("Paid ads on the Instagram.");
        channel.setLocation("Instagram");
        channel.setAudiences(new HashSet<>(audiences));
        channel.addProject(project);
        channels.add(channel);

        channel = new Channel();
        channel.setName("Google paid");
        channel.setDescription("Paid ads on the Google.");
        channel.setLocation("Google");
        channel.setAudiences(new HashSet<>(audiences));
        channel.addProject(project);
        channels.add(channel);

        channel = new Channel();
        channel.setName("FEE main notice board");
        channel.setDescription("Main notice board after the main entrance in the Dejvice campus.");
        channel.setLocation("Dejvice");
        channel.setAudiences(new HashSet<>(List.of(audiences.get(2))));
        channel.addProject(project);
        channels.add(channel);

        return channelService.create(channels);
    }

    private List<Audience> createAudiences() {
        List<Audience> audiences = new ArrayList<>();

        Audience audience = new Audience();
        audience.setName("CZ 18-25");
        audience.setDescription("Whole country of Czechia aged between 18-25.");
        audiences.add(audience);

        audience = new Audience();
        audience.setName("SK 18-25");
        audience.setDescription("Whole country of Slovakia aged between 18-25.");
        audiences.add(audience);

        audience = new Audience();
        audience.setName("Prague 18-25");
        audience.setDescription("Targeted only Prague location aged between 18-25.");
        audiences.add(audience);

        return audienceService.create(audiences);
    }

    private List<TaskLabel> createTaskLabels() {
        List<TaskLabel> taskLabels = new ArrayList<>();

        TaskLabel taskLabel = new TaskLabel();
        taskLabel.setName("High priority");
        taskLabel.setDescription("High difficulty.");
        taskLabels.add(taskLabel);

        taskLabel = new TaskLabel();
        taskLabel.setName("Medium priority");
        taskLabel.setDescription("Medium difficulty.");
        taskLabels.add(taskLabel);

        taskLabel = new TaskLabel();
        taskLabel.setName("Low priority");
        taskLabel.setDescription("Lowest difficulty.");
        taskLabels.add(taskLabel);

        taskLabel = new TaskLabel();
        taskLabel.setName("Idea");
        taskLabel.setDescription("Only idea with no deeper analysis. Might not work.");
        taskLabels.add(taskLabel);

        return taskLabelService.create(taskLabels);
    }

    private List<ChannelType> createChannelTypes() {
        List<ChannelType> channelType = new ArrayList<>();

        ChannelType projectChannelType = new ChannelType();
        projectChannelType.setName("Social Media");
        projectChannelType.setDescription("Social networks.");
        channelType.add(projectChannelType);

        projectChannelType = new ChannelType();
        projectChannelType.setName("Direct communication");
        projectChannelType.setDescription("Direct communication via messaging.");
        channelType.add(projectChannelType);

        projectChannelType = new ChannelType();
        projectChannelType.setName("Classic media");
        projectChannelType.setDescription("Classic form of communication through standard channels.");
        channelType.add(projectChannelType);

        projectChannelType = new ChannelType();
        projectChannelType.setName("Live presentations");
        projectChannelType.setDescription("Communication through the presentation.");
        channelType.add(projectChannelType);

        return channelTypeService.create(channelType);
    }

    private List<ProjectType> createProjectTypes() {
        List<ProjectType> projectTypes = new ArrayList<>();

        ProjectType projectType = new ProjectType();
        projectType.setName("Study appliance");
        projectType.setDescription("Study appliance category.");
        projectTypes.add(projectType);

        projectType = new ProjectType();
        projectType.setName("University propagation");
        projectType.setDescription("Propagation of the university to public.");
        projectTypes.add(projectType);

        projectType = new ProjectType();
        projectType.setName("Research propagation");
        projectType.setDescription("Propagation of results of the research project.");
        projectTypes.add(projectType);


        return projectTypeService.create(projectTypes);
    }

    private List<TaskState> createTaskStates() {
        List<TaskState> taskStates = new ArrayList<>();

        TaskState taskState = new TaskState();
        taskState.setName("Open");
        taskState.setDescription("State for open tasks.");
        taskStates.add(taskState);

        taskState = new TaskState();
        taskState.setName("Cancelled");
        taskState.setDescription("State for cancelled tasks.");
        taskStates.add(taskState);

        taskState = new TaskState();
        taskState.setName("Ongoing");
        taskState.setDescription("State for ongoing tasks.");
        taskStates.add(taskState);

        taskState = new TaskState();
        taskState.setName("Postpone");
        taskState.setDescription("State for postponed tasks.");
        taskStates.add(taskState);

        taskState = new TaskState();
        taskState.setName("Done");
        taskState.setDescription("State for done tasks.");
        taskStates.add(taskState);

        return taskStateService.create(taskStates);
    }

    private List<PostState> createPostStates() {
        List<PostState> postStates = new ArrayList<>();

        PostState postState = new PostState();
        postState.setName("Draft");
        postState.setDescription("Post is in draft mode.");
        postStates.add(postState);

        postState = new PostState();
        postState.setName("Validated");
        postState.setDescription("Post is validated.");
        postStates.add(postState);

        postState = new PostState();
        postState.setName("Review");
        postState.setDescription("Post is ready to review.");
        postStates.add(postState);

        postState = new PostState();
        postState.setName("Posted");
        postState.setDescription("Post is posted.");
        postStates.add(postState);

        postState = new PostState();
        postState.setName("Cancelled");
        postState.setDescription("Post is cancelled.");
        postStates.add(postState);

        return postStateService.create(postStates);
    }

    private List<ProjectState> createProjectStates() {
        List<ProjectState> projectStates = new ArrayList<>();

        ProjectState projectState = new ProjectState();
        projectState.setName("Open");
        projectState.setDescription("State for open projects.");
        projectStates.add(projectState);

        projectState = new ProjectState();
        projectState.setName("Cancelled");
        projectState.setDescription("State for cancelled projects.");
        projectStates.add(projectState);

        projectState = new ProjectState();
        projectState.setName("Ongoing");
        projectState.setDescription("State for ongoing projects.");
        projectStates.add(projectState);

        projectState = new ProjectState();
        projectState.setName("Postpone");
        projectState.setDescription("State for postponed projects.");
        projectStates.add(projectState);

        return projectStateService.create(projectStates);
    }

    private Project createProject(ProjectState projectState, List<ProjectType> projectTypes, Person mod) {
        Project project = new Project();

        project.setName("2023 - study applications");
        project.setDescription("Goal of the project is to get at least 1000 applications for studying programmes on CTU FEE. " +
                "Budget is set to 200 000 CZK.");
        project.setDeadline(LocalDateTime.of(2023, 8, 31, 23, 59));
        project.setManager(personService.getOneById(mod.getId()));
        project.setProjectState(projectState);
        project.addProjectType(projectTypes.get(0));
        return projectService.create(project);
    }

    private List<Event> createEvents(List<EventType> eventTypes, Project project) {
        List<Event> events = new ArrayList<>();

        Event event = new Event();
        event.setName("Open day");
        event.setDescription("Open day for public to see the offers of the study programmes on CTU FEE. There will be " +
                "guided tours on the chosen workplaces and laboratories. In the morning there will be presentations of all " +
                "study programmes starts at 10:00." +
                "" +
                "Program:" +
                "10:00 - 11:00 Presentations of study programmes" +
                "11:00 - 12:00 Presentations of FEE teams and departments" +
                "12:30 - 15:30 Guided tours");
        event.setStartDate(LocalDateTime.of(2023, 7, 1, 10, 0));
        event.setEndDate(LocalDateTime.of(2023, 7, 1, 16, 0));
        event.setEventTypes(new HashSet<>(eventTypes));
        event.setProject(project);
        events.add(event);

        event.setName("Open day 2");
        event.setDescription("Open day for public to see the offers of the study programmes on CTU FEE. There will be " +
                "guided tours on the chosen workplaces and laboratories. In the morning there will be presentations of all " +
                "study programmes starts at 10:00." +
                "" +
                "Program:" +
                "10:00 - 11:00 Presentations of study programmes" +
                "11:00 - 12:00 Presentations of FEE teams and departments" +
                "12:30 - 15:30 Guided tours");
        event.setStartDate(LocalDateTime.of(2023, 8, 1, 10, 0));
        event.setEndDate(LocalDateTime.of(2023, 8, 1, 16, 0));
        event.setEventTypes(new HashSet<>(eventTypes));
        event.setProject(project);
        events.add(event);

        return eventService.create(events);
    }

    private List<EventType> createEventTypes() {
        List<EventType> eventTypes = new ArrayList<>();
        EventType eventType = new EventType();
        eventType.setName("Youtube event");
        eventType.setDescription("Event takes place on Youtube channel by online streaming.");
        eventTypes.add(eventType);

        eventType = new EventType();
        eventType.setName("On site event");
        eventType.setDescription("Event takes place in the buildings of FEE. Entrance is free for everyone.");

        eventTypes.add(eventType);

        eventTypeService.create(eventTypes);
        return eventTypes;
    }

    private void createUsers() {
        admin = new User("admin", "admin@admin.cz", passwordEncoder.encode("admin"));
        moderator = new User("moderator", "moderator@moderator.cz", passwordEncoder.encode("admin"));
        user = new User("user", "user@user.cz", passwordEncoder.encode("admin"));

        UserRole adminRole = userRoleRepository.getUserRoleByName(ERole.ROLE_ADMIN);
        UserRole moderatorRole = userRoleRepository.getUserRoleByName(ERole.ROLE_MODERATOR);
        UserRole userRole = userRoleRepository.getUserRoleByName(ERole.ROLE_USER);
//        userRoleRepository.save(userRole);

        admin.addRole(adminRole);
        moderator.addRole(moderatorRole);
        user.addRole(userRole);

        userService.create(admin);
        userService.create(moderator);
        userService.create(user);
    }

    private Person createPerson(User user, String name, String surname, String phone) {
        Person person = new Person(user);
        person.setName(name);
        person.setSurname(surname);
        person.setPhone(phone);

        return personService.create(person);
    }
}