package cz.cvut.fel.groscdan.crmsystem.model.channel;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @ManyToMany
    @JoinTable(
            name = "posts_channel",
            joinColumns = @JoinColumn(name = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "channels_types",
            joinColumns = @JoinColumn(name = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    private Set<Type> types;


    @ManyToMany
    @JoinTable(
            name = "channel_audience",
            joinColumns = @JoinColumn(name = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "audience_id"))
    private Set<Audience> audiences;

    public boolean addType(Type type) {
        return types.add(type);
    }

    public boolean removeType(Type type) {
        return types.remove(type);
    }

    public boolean addAudience(Audience type) {
        return audiences.add(type);
    }

    public boolean removeAudience(Audience type) {
        return audiences.remove(type);
    }
}
