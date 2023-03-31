package cz.cvut.fel.groscdan.crmsystem.model.project;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "task")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Task extends AbstractEntity {

    @Column
    private LocalDateTime deadline;

    @Column
    private String description;

    @Column
    private String name;

    @Column
    private Integer priority;

    @ManyToMany
    @ToString.Exclude
    private Set<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "task_labels",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "labels_id")
    )
    @ToString.Exclude
    private Set<Label> labels;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private TaskState state;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Person createdByPerson;


    @ManyToOne
    @JoinColumn(name = "assigne_id")
    private Person assignedPerson;

    public void addLabel(Label label) {
        labels.add(label);
    }

    public void removeLabel(Label label) {
        labels.remove(label);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Task task = (Task) o;
        return id != null && Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void removePost(Post post) {
        posts.remove(post);
    }
}