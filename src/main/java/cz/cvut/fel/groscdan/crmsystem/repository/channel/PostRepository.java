package cz.cvut.fel.groscdan.crmsystem.repository.channel;

import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
