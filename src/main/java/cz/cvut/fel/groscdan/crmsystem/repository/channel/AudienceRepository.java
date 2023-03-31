package cz.cvut.fel.groscdan.crmsystem.repository.channel;

import cz.cvut.fel.groscdan.crmsystem.model.channel.Audience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudienceRepository extends JpaRepository<Audience, Long> {
}
