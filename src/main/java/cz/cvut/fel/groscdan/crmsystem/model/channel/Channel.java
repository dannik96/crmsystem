package cz.cvut.fel.groscdan.crmsystem.model.channel;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "channels")
@Getter
@Setter
public class Channel extends AbstractEntity {

    @Column()
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "channels")
    private Set<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "channels_types",
            joinColumns = @JoinColumn(name = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    private Set<ChannelType> channelTypes;


    @ManyToMany
    @JoinTable(
            name = "audiences_channels",
            joinColumns = @JoinColumn(name = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "audience_id"))
    private Set<Audience> audiences;


    @ManyToMany
    @JoinTable(
            name = "projects_channels",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private Set<Project> projects;

    public boolean addType(ChannelType channelType) {
        return channelTypes.add(channelType);
    }

    public boolean removeType(ChannelType channelType) {
        return channelTypes.remove(channelType);
    }

    public boolean addAudience(Audience type) {
        return audiences.add(type);
    }

    public boolean removeAudience(Audience type) {
        return audiences.remove(type);
    }

    public void addProject(Project project) {
        if (projects == null) {
            projects = new HashSet<>();
        }
        projects.add(project);
    }
}
