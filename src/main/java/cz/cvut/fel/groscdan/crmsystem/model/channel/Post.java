package cz.cvut.fel.groscdan.crmsystem.model.channel;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import cz.cvut.fel.groscdan.crmsystem.model.project.Task;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post extends AbstractEntity {


    @Column(name = "content")
    private String content;

    @ManyToMany
    private List<Channel> channel;

    @ManyToMany
    @JoinTable(
            name = "posts_datas",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "data_id"))
    private List<Data> types;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private PostState postState;

    @ManyToMany
    @JoinTable(
            name = "tasks_posts",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks;

    public Post() {

    }

    public Post(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + content + "]";
    }
}
