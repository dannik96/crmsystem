package cz.cvut.fel.groscdan.crmsystem.repository.channel;

import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
