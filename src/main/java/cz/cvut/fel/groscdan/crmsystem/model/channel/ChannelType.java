package cz.cvut.fel.groscdan.crmsystem.model.channel;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
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

    @ManyToMany
    private List<Channel> channel;
}