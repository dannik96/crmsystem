package cz.cvut.fel.groscdan.crmsystem.repository.channel;

import cz.cvut.fel.groscdan.crmsystem.model.channel.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {
}
