package cz.cvut.fel.groscdan.crmsystem.model.channel;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import cz.cvut.fel.groscdan.crmsystem.model.project.Task;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post extends AbstractEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "content")
    private String content;
    @Column
    private LocalDateTime postDate;

    @ManyToMany
    @JoinTable(
            name = "posts_channels",
            joinColumns = @JoinColumn(name = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Channel> channels;

    @ManyToMany
    @JoinTable(
            name = "posts_datas",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "data_id"))
    private List<Data> data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private PostState postState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Person author;

    public Post() {

    }

    public Post(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + content + "]";
    }

    public void removeChannel(Channel channel) {
        channels.remove(channel);
    }

    public void addChannel(Channel channel) {
        channels.add(channel);
    }
}
