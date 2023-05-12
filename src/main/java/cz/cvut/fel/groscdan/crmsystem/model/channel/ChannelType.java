package cz.cvut.fel.groscdan.crmsystem.model.channel;

import javax.persistence.*;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractState;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "channel_types")
@Getter
@Setter
public class ChannelType extends AbstractState {

    @ManyToMany(mappedBy = "channelTypes")
    private List<Channel> channels;

    public void removeChannel(Channel channel) {
        channels.remove(channel);
        channel.removeType(this);
    }
}